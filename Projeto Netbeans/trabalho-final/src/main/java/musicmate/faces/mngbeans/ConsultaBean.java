/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package musicmate.faces.mngbeans;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.ListDataModel;
import musicmate.persistence.entity.Artista;
import utfpr.faces.support.PageBean;
import utfpr.persistence.controller.ArtistaJpaController;


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
        artistas = new ArrayList(ajc.findArtistas());
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
