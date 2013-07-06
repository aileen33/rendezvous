/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import entities.Usuario;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import sessionbeans.UsuarioFacadeLocal;

/**
 *
 * @author Aileen
 */
@Named(value = "managedBeanUsuario")
@RequestScoped
public class ManagedBeanUsuario {

    @EJB
    private UsuarioFacadeLocal usuarioFacade;
    private String nombre;
    private String contraseña;
    private Usuario usuarios;

    public ManagedBeanUsuario() {
    }

    public UsuarioFacadeLocal getUsuarioFacade() {
        return usuarioFacade;
    }

    public void setUsuarioFacade(UsuarioFacadeLocal usuarioFacade) {
        this.usuarioFacade = usuarioFacade;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Usuario getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuario usuarios) {
        this.usuarios = usuarios;
    }

    /**
     * Creates a new instance of ManagedBeanUsuario
     */
    @PostConstruct
    public void init() {
        //usuarios = usuarioFacade.find(nombre);
    }

    public void borrarCuenta() {
        Usuario usuario;
        usuario = new Usuario(nombre, contraseña);
        usuarioFacade.remove(usuario);

    }
}
