/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import entities.Comuna;
import entities.TipoCargo;
import entities.Trabajador;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import sessionbeans.TrabajadorFacade;
import sessionbeans.TrabajadorFacadeLocal;

/**
 *
 * @author juand_000
 */
@Named(value = "managedBeanTrabajador")
@RequestScoped
public class ManagedBeanTrabajador {
    @EJB
    private TrabajadorFacadeLocal trabajadorFacade;

    /**
     * Creates a new instance of ManagedBeanTrabajador
     */
     
    private int rut;
    private int cargo;
    private String Cargo_nombre;
    private String Comuna_nombre;
    private String nombre;
    private String apellido_pat;
    private String apellido_mat;
    private String direccion;
    private int telefono;
    private String correo;
    private String fecha_nac;
    private List<Trabajador> trabajadores;
    private TipoCargo tipoCargo;
    private Comuna comuna;
    private Date fecha;
    
    
    
    public ManagedBeanTrabajador() {
    }

    public TipoCargo getTipoCargo() {
        return tipoCargo;
    }

    public void setTipoCargo(TipoCargo tipoCargo) {
        this.tipoCargo = tipoCargo;
    }

    public String getComuna_nombre() {
        return Comuna_nombre;
    }

    public void setComuna_nombre(String Comuna_nombre) {
        this.Comuna_nombre = Comuna_nombre;
    }


    
    @PostConstruct
    public void init(){
        trabajadores = trabajadorFacade.findAll();
    }
        public String getCargo_nombre() {
        return Cargo_nombre;
    }

    public void setCargo_nombre(String Cargo_nombre) {
        this.Cargo_nombre = Cargo_nombre;
    }
    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public int getCargo() {
        return cargo;
    }

    public void setCargo(int cargo) {
        this.cargo = cargo;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_pat() {
        return apellido_pat;
    }

    public void setApellido_pat(String apellido_pat) {
        this.apellido_pat = apellido_pat;
    }

    public String getApellido_mat() {
        return apellido_mat;
    }

    public void setApellido_mat(String apellido_mat) {
        this.apellido_mat = apellido_mat;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public List<Trabajador> getTrabajadores() {
        return trabajadores;
    }

    public void setTrabajadores(List<Trabajador> trabajadores) {
        this.trabajadores = trabajadores;
    }
    
    public void nuevoTrabajador(){
        Trabajador trabajador;
        trabajador = new Trabajador(rut, nombre, apellido_pat, apellido_pat, direccion, telefono, correo);
        // Guardar el cargo seleccionado
        boolean cont=true;
        int cont1=1;
        while(cont){
            tipoCargo = new TipoCargo(cont1);
            if(tipoCargo.toString().equals(Cargo_nombre)){
                cont=false;
                trabajador.setIdCargo(tipoCargo);
            }
            cont1++;
        }
        // Guardar la comuna seleccionada
        boolean cont2=true;
        int cont3=1;
        while(cont2){
            comuna = new Comuna(cont3);
            if(comuna.toString().equals(Comuna_nombre)){
                cont2=false;
                trabajador.setIdComuna(comuna);
            }
            cont3++;
        }
        
        fecha = new Date();
        fecha.getDate();
        trabajador.setFechaNacTrab(fecha);
        trabajadorFacade.create(trabajador);
    }
    
}
