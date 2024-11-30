package ProyectoExposicion.controlador;

import ProyectoExposicion.modelo.dao.UsuarioDAO;
import ProyectoExposicion.vista.LoginVista;

public class LoginControlador {
    private final UsuarioDAO usuarioDAO;
    private final LoginVista loginVista;

    public LoginControlador() {
        this.usuarioDAO = new UsuarioDAO();
        this.loginVista = new LoginVista();
    }

    public boolean iniciarSesion() {
        boolean loginExitoso = false;
        
        while (!loginExitoso) {
            String[] credenciales = loginVista.mostrarLogin();
            loginExitoso = usuarioDAO.validarUsuario(credenciales[0], credenciales[1]);
            
            if (loginExitoso) {
                loginVista.mostrarExito();
                return true;
            } else {
                loginVista.mostrarError();
            }
        }
        return false;
    }
}