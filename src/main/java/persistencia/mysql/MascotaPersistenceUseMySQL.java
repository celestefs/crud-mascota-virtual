package persistencia.mysql;

import modelos.Mascota;
import persistencia.IMascotaPersistence;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.List;
import java.util.Random;

public class MascotaPersistenceUseMySQL implements IMascotaPersistence {
    MySQLConnection mySQLConnection;
    Connection connection;

    public MascotaPersistenceUseMySQL() {
        this.mySQLConnection = new MySQLConnection();
        this.connection = mySQLConnection.establecerConexion();
    }

    @Override
    public void guardar(Mascota mascota) {
        try {
            String query = "INSERT INTO mascotas ("
                    + "(id INTEGER PRIMARY KEY AUTO_INCREMENT, "
                    + "nombre VARCHAR(255), "
                    + "propietario VARCHAR(255), "
                    + "fecha_nacimiento DATE, "
                    + "fecha_muerte DATE, "
                    + "nivel_energia INTEGER, "
                    + "nivel_hambre INTEGER, "
                    + "nivel_cansancio INTEGER, "
                    + "nivel_felicidad INTEGER, "
                    + "nivel_aburrimiento INTEGER) "
                    + ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = mySQLConnection.enviarConsulta(this.connection, query);
            stmt.setInt(1, mascota.getId());
            stmt.setString(2, mascota.getNombre());
            stmt.setString(3, mascota.getPropietario());
            stmt.setString(4, mascota.getFechaNacimiento().toString());
            stmt.setString(5, mascota.getFechaMuerte() != null ? mascota.getFechaMuerte().toString() : null);
            stmt.setInt(6, mascota.getNivelEnergia());
            stmt.setInt(7, mascota.getNivelHambre());
            stmt.setInt(8, mascota.getNivelCansancio());
            stmt.setInt(9, mascota.getNivelFelicidad());
            stmt.setInt(10, mascota.getNivelAburrimiento());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("problema para insertar los datos");
        }
    }

    @Override
    public Mascota getMascota(int id) {
        Mascota mascota = new Mascota();
        String query = "SELECT * FROM mascotas WHERE id = ?";
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                mascota.setId(rs.getInt("id"));
                mascota.setNombre(rs.getString("nombre"));
                mascota.setPropietario(rs.getString("propietario"));
                mascota.setFechaNacimiento((rs.getDate("fecha_nacimiento").toLocalDate().atTime(LocalTime.ofSecondOfDay(new Random().nextInt(86400)))));
                mascota.setNivelEnergia(rs.getInt("nivel_energia"));
                mascota.setNivelHambre(rs.getInt("nivel_hambre"));
                mascota.setNivelCansancio(rs.getInt("nivel_cansancio"));
                mascota.setNivelFelicidad(rs.getInt("nivel_felicidad"));
                mascota.setNivelAburrimiento(rs.getInt("nivel_aburrimiento"));
            }
        } catch (SQLException e) {
        }
        return mascota;
    }

    @Override
    public Mascota getMascota(String nombre) {
        return null;
    }

    @Override
    public List<Mascota> getAllMascotas() {
        return null;
    }

    @Override
    public void updateMascota(int id, Mascota mascota) {

}

    @Override
    public void deleteMascota(int id) {
        try {
            String sql = "DELETE FROM + mascotas + WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

