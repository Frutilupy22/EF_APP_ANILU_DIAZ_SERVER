package pe.edu.cibertec.ef_app_diaz_server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.ef_app_diaz_server.entity.Usuario;
import pe.edu.cibertec.ef_app_diaz_server.repository.IUsuarioRepository;

import java.util.Collection;
import java.util.Collections;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private IUsuarioRepository iUsuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = iUsuarioRepository.findByCodigo(username)
                .orElseThrow(() -> new UsernameNotFoundException("El usuario no ha sido encontrado"));

        return User.withUsername(usuario.getCodigo())
                .password(usuario.getPassword())
                .disabled(!usuario.getActivo())
                .build();
    }
}
