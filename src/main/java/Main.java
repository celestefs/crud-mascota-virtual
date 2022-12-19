import acciones.Morir;
import enumeradores.AlmacenAlimentos;
import enumeradores.EntretenimientosEnum;
import modelos.DukeMascota;
import modelos.Mascota;
import persistencia.mysql.MascotaPersistenceUseMySQL;
import persistencia.mysql.MySQLConnection;
import persistencia.persistenceCollections.MascotaPersistenceUseList;
import utils.RegistroCivilMascotas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {

        MascotaPersistenceUseList persistence = new MascotaPersistenceUseList();

        DukeMascota duke = new DukeMascota("Manchitas", "Celeste");
        DukeMascota duke2 = new DukeMascota("Pocho", "Celeste");
        DukeMascota duke3 = new DukeMascota("Colo", "Celeste");
        DukeMascota duke4 = new DukeMascota("Clarito", "Celeste");
        persistence.guardar(duke);
        persistence.guardar(duke2);
        persistence.guardar(duke3);
        persistence.guardar(duke4);

/*      System.out.println("antes de comer " + duke.getNivelEnergia());
        duke.comer(AlmacenAlimentos.ASADO);
        System.out.println("despues de comer " + duke.getNivelEnergia());

        duke.jugar(EntretenimientosEnum.LEER);
        duke.jugar(EntretenimientosEnum.PASEAR);

        duke.comer(AlmacenAlimentos.ENSALADA);
        duke.comer(AlmacenAlimentos.ASADO);

        System.out.println("despues de comer " + duke.getComidasIngeridas() + " comidas");
        System.out.println("su nivel de energia es " + duke.getNivelEnergia());
        System.out.println("tiene que ir al baño duke? " + duke.getPopo().tieneQueEvacuar(duke));


        System.out.println("antes de dormir la energia de duke era de " + duke.getNivelEnergia());
        duke.dormir(LocalTime.of(0,25));
        System.out.println("despues de dormir " + duke.getNivelEnergia());

        System.out.println(duke.getNivelEnergia());
        duke.comer(AlmacenAlimentos.ASADO);
        System.out.println("despues de comer " + duke.getComidasIngeridas() + " comidas");
        System.out.println(duke.getPopo().tieneQueEvacuar(duke));
        duke.comer(AlmacenAlimentos.ASADO);
        duke.comer(AlmacenAlimentos.ASADO);
        System.out.println("despues de comer " + duke.getComidasIngeridas() + " comidas");
        System.out.println(duke.getPopo().tieneQueEvacuar(duke));
        System.out.println(duke.getNivelEnergia());
        duke.irAlBaño();
        System.out.println(duke.getComidasIngeridas());


        System.out.println(duke.getNivelHambre());
        Morir.checkStatusGeneral(duke);
        System.out.println(duke.getActaDefuncion());
        RegistroCivilMascotas.guardarActa(duke);
        RegistroCivilMascotas.leerActaDefuncion(duke);

        Morir.checkStatusGeneral(duke);
        RegistroCivilMascotas.leerActaDefuncion(duke);

        try {
            MySQLConnection conexion = new MySQLConnection();
            Connection connection = conexion.establecerConexion();

            String sql = "CREATE TABLE mascotas "
                    + "(id INTEGER PRIMARY KEY AUTO_INCREMENT, "
                    + "nombre VARCHAR(255), "
                    + "propietario VARCHAR(255), "
                    + "fecha_nacimiento DATE, "
                    + "fecha_muerte DATE, "
                    + "nivel_energia INTEGER, "
                    + "nivel_hambre INTEGER, "
                    + "nivel_cansancio INTEGER, "
                    + "nivel_felicidad INTEGER, "
                    + "nivel_aburrimiento INTEGER) ";

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.executeUpdate();

            String sql = "INSERT INTO mascotas (id, nombre, propietario, fecha_nacimiento, fecha_muerte, nivel_energia, nivel_hambre, nivel_cansancio, nivel_felicidad, nivel_aburrimiento) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, duke4.getId());
            stmt.setString(2, duke4.getNombre());
            stmt.setString(3, duke4.getPropietario());
            stmt.setString(4, duke4.getFechaNacimiento().toString());
            stmt.setString(5, duke4.getFechaMuerte() != null ? duke.getFechaMuerte().toString() : null);
            stmt.setInt(6, duke4.getNivelEnergia());
            stmt.setInt(7, duke4.getNivelHambre());
            stmt.setInt(8, duke4.getNivelCansancio());
            stmt.setInt(9, duke4.getNivelFelicidad());
            stmt.setInt(10, duke4.getNivelAburrimiento());
            stmt.executeUpdate();
            stmt.close();
            conexion.cerrarConexion(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println(duke4.getNivelHambre());
        duke4.comer(AlmacenAlimentos.ENSALADA);
        System.out.println("despues de comer " + duke4.getNivelHambre());

        try {
            MySQLConnection conexion = new MySQLConnection();
            Connection connection = conexion.establecerConexion();

            String sql = "UPDATE mascotas SET nivel_hambre = ? WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, 19);
            stmt.setInt(2, 4);
            stmt.executeUpdate();
            stmt.close();
            conexion.cerrarConexion(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
*/
        MascotaPersistenceUseMySQL persistenceUseBDMySQL = new MascotaPersistenceUseMySQL();
        Mascota mascota = persistenceUseBDMySQL.getMascota(4);
        System.out.println(mascota.getNombre() + " " + mascota.getNivelHambre());
    }
}