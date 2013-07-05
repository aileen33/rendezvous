/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import entities.Comuna;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import sessionbeans.ComunaFacadeLocal;

/**
 *
 * @author Aileen
 */
@Named(value = "managedBeanComuna")
@Dependent
public class ManagedBeanComuna {

    /**
     * Creates a new instance of ManagedBeanComuna
     */
    public ManagedBeanComuna() {
    }
    @EJB
    private ComunaFacadeLocal comunaFacade;


    private String nombreComuna;
    private List<Comuna> comunas; 

    
    @PostConstruct
    public void init(){
        comunas= comunaFacade.findAll();
    }
    public String getNombreComuna() {
        return nombreComuna;
    }

    public void setNombreComuna(String nombreComuna) {
        this.nombreComuna = nombreComuna;
    }

    public List<Comuna> getComunas() {
        return comunas;
    }

    public void setComunas(List<Comuna> comunas) {
        this.comunas = comunas;
    }


}
