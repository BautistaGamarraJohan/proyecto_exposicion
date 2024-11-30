package ProyectoExposicion.modelo.dao;

import ProyectoExposicion.modelo.entidades.Usuario;
import java.util.HashMap;
import java.util.Map;

public class UsuarioDAO {
    private static Map<String, Usuario> usuarios = new HashMap<>();

    public UsuarioDAO() {
        // Agregamos algunos usuarios de prueba
        usuarios.put("johan", new Usuario("johan", "johan2115"));
        usuarios.put("kimber", new Usuario("kimber", "kimber123"));
        usuarios.put("andy", new Usuario("andy", "andy123"));
        usuarios.put("carlos", new Usuario("carlos", "carlos123"));
        
    }

    public boolean validarUsuario(String nombreUsuario, String contraseña) {
        Usuario usuario = usuarios.get(nombreUsuario);
        return usuario != null && usuario.getContraseña().equals(contraseña);
    }
}