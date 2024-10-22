package pe.edu.cibertec.ef_app_diaz_server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.cibertec.ef_app_diaz_server.entity.Usuario;

import java.util.Optional;

public interface IUsuarioRepository extends JpaRepository<Usuario,Long> {
    Optional<Usuario> findByCodigo(String codigo);
}
