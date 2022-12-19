package persistencia;

import modelos.Mascota;

import java.util.ArrayList;
import java.util.List;

public interface IMascotaPersistence {

    List<Mascota> bdMascotas = new ArrayList<>();
    void guardar(Mascota mascota);
    Mascota getMascota(int id);
    Mascota getMascota(String nombre);
    List<Mascota> getAllMascotas();
    void updateMascota(int id, Mascota mascota);
    void deleteMascota(int id);
}
