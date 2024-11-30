package ProyectoExposicion.modelo.dao;

import ProyectoExposicion.modelo.entidades.Usuario;
import java.util.HashMap;
import java.util.Map;

public class UsuarioDAO {
    private static Map<String, Usuario> usuarios = new HashMap<>();

    public UsuarioDAO() {
        // Agregamos algunos usuarios de prueba
        usuarios.put("admin", new Usuario("admin", "123456"));
        usuarios.put("user", new Usuario("user", "123456"));
    }

    public boolean validarUsuario(String nombreUsuario, String contraseña) {
        Usuario usuario = usuarios.get(nombreUsuario);
        return usuario != null && usuario.getContraseña().equals(contraseña);
    }
}