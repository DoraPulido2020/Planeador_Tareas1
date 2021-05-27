package logica;

import dto.Proyecto;
import database.Conexiones;
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
public class OperProyecto implements Operaciones1<Proyecto> {

    @Override
    public int insertar(Proyecto dato) {
        Conexiones c = new Conexiones();
        Connection cActiva = c.conectarse();
        if (cActiva != null) {
            try {
                String sql = "insert into proyecto (proyecto_nombre,proyecto_descripcion,"
                        + "fecha_inicio,fecha_fin) values (?,?,?,?)";

                PreparedStatement ps = cActiva.prepareStatement(sql);
                ps.setString(1, dato.getProyecto_nombre());
                ps.setString(2, dato.getProyecto_descripcion());
                ps.setDate(3, (Date) dato.getFecha_inicio());
                ps.setDate(4, (Date) dato.getFecha_fin());
                int rta = ps.executeUpdate();
                return rta;
            } catch (SQLException ex) {
                Logger.getLogger(OperProyecto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return 0;

    }

    public String actualizar(Proyecto dato) throws SQLException {
        String result = null;
        Conexiones c = new Conexiones();
        Connection cActiva = c.conectarse();
        c.conectarse();
        String sql = "UPDATE proyecto SET id=?,proyecto_nombre=?,proyecto_descripcion=?,fecha_inicio=? WHERE id =? ";
        PreparedStatement ps = cActiva.prepareStatement(sql);

        try {
            if (cActiva != null) {
                ps = cActiva.prepareStatement(sql);
                ps.setString(1, dato.getProyecto_nombre());
                ps.setString(2, dato.getProyecto_descripcion());
                ps.setDate(3, (Date) dato.getFecha_inicio());
                ps.setDate(4, (Date) dato.getFecha_fin());
                result = "Proyecto actualizado con exito, ID: " + dato.getProyecto_id();
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

    public List<Proyecto> consultar() {

        Conexiones c = new Conexiones();
        Connection cActiva = c.conectarse();
        List<Proyecto> datos = new ArrayList<>();
        if (cActiva != null) {
            try {
                String sql = "SELECT * FROM proyecto ";
                PreparedStatement ps = cActiva.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    Proyecto e = new Proyecto();
                    Long proyecto_id = rs.getLong("proyecto_id");
                    e.setProyecto_id(proyecto_id);
                    e.setProyecto_nombre(rs.getString("proyecto_nombre"));
                    e.setProyecto_descripcion(rs.getString("proyecto_descripcion"));
                    e.setFecha_inicio(rs.getDate("fecha_inicio"));
                    e.setFecha_fin(rs.getDate("fecha_fin"));
                    datos.add(e);
                }

            } catch (SQLException ex) {
                Logger.getLogger(OperProyecto.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                c.desconectase(cActiva);
            }
        }
        return datos;

    }

    public Proyecto Buscar(Long id) throws SQLException {
        Proyecto mat = new Proyecto();
        Conexiones c = new Conexiones();
        Connection cActiva = c.conectarse();
        String sql = "SELECT * FROM proyecto WHERE id = ? ";
        c.conectarse();
        PreparedStatement ps = cActiva.prepareStatement(sql);
        try {
            if (cActiva != null) {
                ps = cActiva.prepareStatement(sql);
                ps.setLong(1, id);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    Long proyecto_id = rs.getLong("proyecto_id");
                    mat.setProyecto_nombre(rs.getString("proyecto_nombre"));
                    mat.setProyecto_descripcion(rs.getString("proyecto_descripcion"));
                    mat.setFecha_inicio(rs.getDate("///"));
                    mat.setFecha_fin(rs.getDate("///"));
                }
                rs.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(OperProyecto.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            c.desconectase(cActiva);
        }
        return mat;
    }

    public String eliminar(Long Id) throws SQLException {
        String result = null;
        Conexiones c = new Conexiones();
        Connection cActiva = c.conectarse();
        String sql = "DELETE FROM proyecto WHERE id = ? ";
        c.conectarse();
        PreparedStatement ps = cActiva.prepareStatement(sql);

        try {
            if (cActiva != null) {
                ps = cActiva.prepareStatement(sql);
                ps.setLong(1, Id);
                ps.executeUpdate();
                result = "Proyecto eliminado con èxito";
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
    public Proyecto consultar(Long Id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  

}
