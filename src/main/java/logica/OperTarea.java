package logica;

import dto.Tarea;
import database.Conexiones;
import dto.Prioridad;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dora
 */
public class OperTarea implements Operaciones<Tarea> {

    @Override
    public int insertar(Tarea dato) {
        Conexiones c = new Conexiones();
        Connection cActiva = c.conectarse();
        if (cActiva != null) {
            try {
                String sql = "insert into tarea (tarea_nombre,tarea_descripcion,"
                        + "fecha_entrega,fecha_asignacion, prioridad_tarea, activo,proyecto_id,"
                        + "proyecto_nombre,usuario_id,usuario_nombre ) values (?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement ps = cActiva.prepareStatement(sql);
                ps.setString(1, dato.getTarea_nombre());
                ps.setString(2, dato.getTarea_descripcion());
                ps.setDate(3, (Date) dato.getFecha_entrega());
                ps.setDate(4, (Date) dato.getFecha_asignacion());
                ps.setString(5, dato.getPrioridad_tarea().getNombre());
                ps.setInt(6, dato.getActivo());
                ps.setInt(7, dato.getProyecto_id());
                ps.setString(8, dato.getProyecto_nombre());
                ps.setInt(9, dato.getUsuario_id());
                ps.setString(10, dato.getUsuario_nombre());
                int rta = ps.executeUpdate();
                return rta;
            } catch (SQLException ex) {
                Logger.getLogger(OperTarea.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return 0;

    }

    public String actualizar(Tarea dato) throws SQLException {
        String result = null;
        Conexiones c = new Conexiones();
        Connection cActiva = c.conectarse();
        c.conectarse();
        String sql = "UPDATE tarea SET id=?,tarea_nombre=?,tarea_descripcion=?,fecha_entrega=? WHERE id =? ";
        PreparedStatement ps = cActiva.prepareStatement(sql);

        try {
            if (cActiva != null) {
                ps = cActiva.prepareStatement(sql);
                ps.setString(1, dato.getTarea_nombre());
                ps.setString(2, dato.getTarea_descripcion());
                ps.setDate(3, (Date) dato.getFecha_entrega());
                ps.setDate(4, (Date) dato.getFecha_asignacion());
                ps.setString(5, dato.getPrioridad_tarea().getNombre());
                ps.setInt(6, dato.getActivo());
                ps.setInt(7, dato.getProyecto_id());
                ps.setString(8, dato.getProyecto_nombre());
                ps.setInt(7, dato.getUsuario_id());
                ps.setString(8, dato.getUsuario_nombre());

                result = "Tarea actualizada con exito, ID: " + dato.getTarea_id();
            }
        } catch (SQLException e) {
            result = "Error durante el registro: " + e.getMessage();
        } finally {
            try {
                if (cActiva != null) {
                    cActiva.close();
                    ps.close();
                }
            } catch (Exception e) {
                result = "Error " + e;
            }
        }
        return result;
    }

    public List<Tarea> consultar() {

        Conexiones c = new Conexiones();
        Connection cActiva = c.conectarse();
        List<Tarea> datos = new ArrayList<>();
        if (cActiva != null) {
            try {
                String sql = "SELECT * FROM tarea ";
                PreparedStatement ps = cActiva.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    Tarea e = new Tarea();
                    Long tarea_id = rs.getLong("tarea_id");
                    e.setTarea_id(tarea_id);
                    e.setTarea_nombre(rs.getString("tarea_nombre"));
                    e.setTarea_descripcion(rs.getString("tarea_descripcion"));
                    e.setFecha_entrega(rs.getDate("fecha_entrega"));
                    e.setFecha_asignacion(rs.getDate("fecha_asignacion"));
                    String pri = rs.getString("Prioridadtarea");
                    e.setPrioridad_tarea(validaEnum(pri));
                    e.setActivo(rs.getInt("Activo"));
                    e.setProyecto_id(rs.getInt("proyecto_id"));
                    e.setProyecto_nombre(rs.getString("proyecto_nombre"));
                    e.setUsuario_id(rs.getInt("usuario_id"));
                    e.setUsuario_nombre(rs.getString("usuario_nombre"));

                    datos.add(e);
                }

            } catch (SQLException ex) {
                Logger.getLogger(OperTarea.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                c.desconectase(cActiva);
            }
        }
        return datos;

    }

    private Prioridad validaEnum(String prog) {
        Prioridad pri = null;
        if (pri.equals(Prioridad.MEDIA.getNombre())) {
            pri = Prioridad.MEDIA;
        }
        if (pri.equals(Prioridad.ALTA.getNombre())) {
            pri = Prioridad.ALTA;
        }
        if (pri.equals(Prioridad.BAJA.getNombre())) {
            pri = Prioridad.BAJA;
        }
        return pri;

    }

    public Tarea Buscar(Long id) throws SQLException {
        Tarea mat = new Tarea();
        Conexiones c = new Conexiones();
        Connection cActiva = c.conectarse();
        String sql = "SELECT * FROM tarea WHERE id = ? ";
        c.conectarse();
        PreparedStatement ps = cActiva.prepareStatement(sql);
        try {
            if (cActiva != null) {
                ps = cActiva.prepareStatement(sql);
                ps.setLong(1, id);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    Long tarea_id = rs.getLong("tarea_id");
                    mat.setTarea_nombre(rs.getString("tarea_nombre"));
                    mat.setTarea_descripcion(rs.getString("tarea_descripcion"));
                    mat.setFecha_entrega(rs.getDate("///"));
                    mat.setFecha_asignacion(rs.getDate("///"));
                    String pri = rs.getString("Prioridadtarea");
                    mat.setPrioridad_tarea(validaEnum(pri));
                    mat.setActivo(rs.getInt("Activo"));
                    mat.setProyecto_id(rs.getInt("proyecto_id"));
                    mat.setProyecto_nombre(rs.getString("proyecto_nombre"));
                    mat.setUsuario_id(rs.getInt("usuario_id"));
                    mat.setUsuario_nombre(rs.getString("usuario_nombre"));
                    
                   


                }
                rs.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(OperTarea.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            c.desconectase(cActiva);
        }
        return mat;
    }

    public String eliminar(Long Id) throws SQLException {
        String result = null;
        Conexiones c = new Conexiones();
        Connection cActiva = c.conectarse();
        String sql = "DELETE FROM tarea WHERE id = ? ";
        c.conectarse();
        PreparedStatement ps = cActiva.prepareStatement(sql);

        try {
            if (cActiva != null) {
                ps = cActiva.prepareStatement(sql);
                ps.setLong(1, Id);
                ps.executeUpdate();
                result = "Tarea eliminada con èxito";
            }
        } catch (SQLException e) {
            result = "Error en la consulta: " + e.getMessage();
        } finally {
            try {
                if (cActiva != null) {
                    cActiva.close();

                }
            } catch (Exception e) {
                result = "Error " + e;
            }
        }
        return result;
    }

    @Override
    public Tarea consultar(Long Id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
