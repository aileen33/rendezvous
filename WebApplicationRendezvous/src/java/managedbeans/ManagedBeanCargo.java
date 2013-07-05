/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import entities.TipoCargo;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import sessionbeans.TipoCargoFacadeLocal;

/**
 *
 * @author Aileen
 */
@Named(value = "managedBeanCargo")
@Dependent
public class ManagedBeanCargo {

    /**
     * Creates a new instance of ManagedBeanCargo
     */
    public ManagedBeanCargo() {
    }
        @EJB
    private TipoCargoFacadeLocal tipoCargoFacade;

    private String nombreCargo;
    private List<TipoCargo> tipoCargos;

    @PostConstruct
    public void init(){
        tipoCargos = tipoCargoFacade.findAll();
    }
    
    public String getNombreCargo() {
        return nombreCargo;
    }

    public void setNombreCargo(String nombreCargo) {
        this.nombreCargo = nombreCargo;
    }

    public List<TipoCargo> getTipoCargos() {
        return tipoCargos;
    }

    public void setTipoCargos(List<TipoCargo> tipoCargos) {
        this.tipoCargos = tipoCargos;
    }
}
