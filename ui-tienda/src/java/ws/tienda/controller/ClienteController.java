/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.tienda.controller;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import ws.tienda.entities.ClienteEntity;
import ws.tienda.model.ClienteModel;
import ws.tienda.utils.JsfUtil;
import ws.tienda.utils.JpaUtil;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.faces.application.FacesMessage;

/**
 *
 * @author KiDo
 */
@ManagedBean
@RequestScoped
public class ClienteController {

   private ClienteEntity cliente= new ClienteEntity();
   
    private List<ClienteEntity> listaClientes;
    private ClienteModel modelo = new ClienteModel();

 
    public ClienteController() {
        cliente = new ClienteEntity();
    }

    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    public List<ClienteEntity> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<ClienteEntity> listaClientes) {
        this.listaClientes = listaClientes;
    }

   

    public String guardarRegistro() {
        if (modelo.insertarEntidad(cliente) != 1) {
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("ya existe un registro"));
            
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Se ha registrado exitosamente"));
        }
       // return "clientes?ui-tienda-redirect=true";
       return "";
    }

    public String eliminarRegistro() {
        //leyendo el parametro enviador desde la vista
        String identificador = JsfUtil.getRequest().getParameter("idCliente");
        if (modelo.eliminarEntidad(identificador) > 0) {
            JsfUtil.setFlashMessage("exito", "El caso ha sido eliminado");
        }//fin if
        else {
            JsfUtil.setErrorMessage(null, "Lo sentimos, no se pudo borrar el registro");
        }//fin else
        return "clientes?ui-tienda-redirect=true";
    }//fin del metodo eliminar 

    public String enviarDato() {
        try {
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            String referencia = request.getParameter("cliente");
            cliente = modelo.obtenerEntidad(referencia);
            return "cliente";
        } catch (Exception e) {
            return null;
        }
    }

    public String modificarRegistro() {

        if (modelo.modificarEntidad(cliente) > 0) {

            JsfUtil.setFlashMessage("exito", "El registro ha sido editado");
        }//fin if
        else {
            JsfUtil.setErrorMessage(null, "Lo sentimos, no se pudo editar el registro");
        }//fin else

        return "clientes?ui-tienda-redirect=true";
    }

}//fin clase
