package logica;

import dto.Usuario;
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
public class OperUsuario implements Operaciones2<Usuario> {

    @Override
    public int insertar(Usuario dato) {
        Conexiones c = new Conexiones();
        Connection cActiva = c.conectarse();
        if (cActiva != null) {
            try {
                String sql = "insert into usuario (usuario_nombre,usuario_apellido,"
                        + "usuario,password,grupo_usuarios_id,grupo_usuarios_nombre,usuario_correo) values (?,?,?,?,?,?,?)";
                PreparedStatement ps = cActiva.prepareStatement(sql);
                ps.setString(1, dato.getUsuario_nombre());
                ps.setString(2, dato.getUsuario_apellido());
                ps.setString(3, dato.getUsuario());
                ps.setString(4, dato.getPassword());
                ps.setInt(5, dato.getGrupo_usuarios_id());
                ps.setString(6, dato.getGrupo_usuarios_nombre());
                ps.setString(7, dato.getUsuario_correo());

                int rta = ps.executeUpdate();
                return rta;
            } catch (SQLException ex) {
                Logger.getLogger(OperUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return 0;

    }

    public String actualizar(Usuario dato) throws SQLException {
        String result = null;
        Conexiones c = new Conexiones();
        Connection cActiva = c.conectarse();
        c.conectarse();
        String sql = "UPDATE usuario SET id=?,usuario_nombre=?,usuario_apellido=?,usuario=? WHERE id =? ";
        PreparedStatement ps = cActiva.prepareStatement(sql);

        try {
            if (cActiva != null) {
                ps = cActiva.prepareStatement(sql);
                ps.setString(1, dato.getUsuario_nombre());
                ps.setString(2, dato.getUsuario_apellido());
                ps.setString(3, dato.getUsuario());
                ps.setString(4, dato.getPassword());
                ps.setInt(5, dato.getGrupo_usuarios_id());
                ps.setString(6, dato.getGrupo_usuarios_nombre());
                ps.setString(7, dato.getUsuario_correo());

                result = "Usuario actualizado con exito, ID: " + dato.getUsuario_id();
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

    public List<Usuario> consultar() {

        Conexiones c = new Conexiones();
        Connection cActiva = c.conectarse();
        List<Usuario> datos = new ArrayList<>();
        if (cActiva != null) {
            try {
                String sql = "SELECT * FROM usuario";
                PreparedStatement ps = cActiva.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    Usuario e = new Usuario();
                    Long usuario_id = rs.getLong("usuario_id");
                    e.setUsuario_id(usuario_id);
                    e.setUsuario_nombre(rs.getString("usuario_nombre"));
                    e.setUsuario_apellido(rs.getString("usuario_apellido"));
                    e.setUsuario(rs.getString("usuario"));
                    e.setPassword(rs.getString("password"));
                    e.setGrupo_usuarios_id(rs.getInt("grupo_usuarios_id"));
                    e.setGrupo_usuarios_nombre(rs.getString("grupo_usuarios_nombre"));
                    e.setUsuario_correo(rs.getString("usuario_correo"));

                    datos.add(e);
                }

            } catch (SQLException ex) {
                Logger.getLogger(OperUsuario.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                c.desconectase(cActiva);
            }
        }
        return datos;

    }

    public Usuario Buscar(Long id) throws SQLException {
        Usuario mat = new Usuario();
        Conexiones c = new Conexiones();
        Connection cActiva = c.conectarse();
        String sql = "SELECT * FROM Usuario WHERE id = ? ";
        c.conectarse();
        PreparedStatement ps = cActiva.prepareStatement(sql);
        try {
            if (cActiva != null) {
                ps = cActiva.prepareStatement(sql);
                ps.setLong(1, id);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {

                    Long usuario_id = rs.getLong("usuario_id");
                    mat.setUsuario_nombre(rs.getString("usuario_nombre"));
                    mat.setUsuario_apellido(rs.getString("usuario_apellido"));
                    mat.setUsuario(rs.getString("usuario"));
                    mat.setPassword(rs.getString("password"));
                    mat.setGrupo_usuarios_id(rs.getInt("grupo_usuarios_id"));
                    mat.setGrupo_usuarios_nombre(rs.getString("grupo_usuarios_nombre"));
                    mat.setUsuario_correo(rs.getString("usuario_correo"));

                }
                rs.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(OperUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            c.desconectase(cActiva);
        }
        return mat;
    }

    public String eliminar(Long Id) throws SQLException {
        String result = null;
        Conexiones c = new Conexiones();
        Connection cActiva = c.conectarse();
        String sql = "DELETE FROM usuario WHERE id = ? ";
        c.conectarse();
        PreparedStatement ps = cActiva.prepareStatement(sql);

        try {
            if (cActiva != null) {
                ps = cActiva.prepareStatement(sql);
                ps.setLong(1, Id);
                ps.executeUpdate();
                result = "Usuario eliminado con èxito";
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
    public Usuario consultar(Long Id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
