/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package musicmate.faces.mngbeans;

import java.util.ArrayList;
import java.util.Collection;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.ListDataModel;
import javax.servlet.http.HttpServletRequest;
import musicmate.persistence.entity.Album;
import musicmate.persistence.entity.Artista;
import musicmate.persistence.entity.Usuario;
import utfpr.faces.support.PageBean;
import utfpr.persistence.controller.ArtistaJpaController;
import utfpr.persistence.controller.UsuarioJpaController;


/**
 *
 * @author telmo
 */
@ManagedBean
@RequestScoped
public class ConsultaBean extends PageBean {
    
    private ListDataModel<Artista> artistasDataModel;
    private String busca;
    ArrayList<Artista> artistas;
    
    public ConsultaBean() {
        
        ArtistaJpaController ajc = new ArtistaJpaController();
        
        // tests
//        UsuarioJpaController ujc = new UsuarioJpaController();
//        
//        HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
//        String email = request.getUserPrincipal().getName();
//        Usuario u = ujc.getUsuarioByEmail(email);
//        
//        Artista a = new Artista();
//        a.setCodigo(1);
//        a.setNome("seis são loco");
//        a.setCodigoUsuario(u);
//        ajc.persist(a);
//        
//        Artista a5 = new Artista();
//        a5.setCodigo(2);
//        a5.setNome("cinco cinco");
//        a5.setCodigoUsuario(u);
//        ajc.persist(a5);
        
        artistas = new ArrayList(ajc.findArtistas());
//        artistas = ajc.findArtistasByNome("seis");
        artistasDataModel = new ListDataModel<>(artistas);
        
    }

    public ListDataModel<Artista> getArtistasDataModel() {
        return artistasDataModel;
    }

    public void setRevendedoresDataModel(ListDataModel<Artista> artistasDataModel) {
        this.artistasDataModel = artistasDataModel;
    }
    
    public String getBusca() {
        return busca;
    }

    public void setBusca(String busca) {
        this.busca = busca;
    }
    
    public void buscaTextChanged(ValueChangeEvent event) {
        String filtro = (String) event.getNewValue();
        
        ArtistaJpaController ajc = new ArtistaJpaController();
        artistas = new ArrayList(ajc.findArtistasByNome(filtro));
//        revendedoresDataModel = new ListDataModel<>(revendedores);
        
        artistasDataModel.setWrappedData(artistas);
    }
}
