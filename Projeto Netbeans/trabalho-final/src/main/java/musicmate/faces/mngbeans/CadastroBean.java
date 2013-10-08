package musicmate.faces.mngbeans;

import musicmate.persistence.entity.Artista;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import musicmate.persistence.entity.Album;
import musicmate.persistence.entity.Faixa;
import utfpr.faces.support.PageBean;
import utfpr.persistence.controller.AlbumJpaController;
import utfpr.persistence.controller.ArtistaJpaController;

/**
 *
 * @author telmo
 */
@ManagedBean
@SessionScoped
public class CadastroBean extends PageBean {

    public static final String PLEASE_SELECT = "Selecione...";
    public static final String TOPLEVEL_LOOKUP_VALUE = "9999999";
    private ArrayList<Artista> artistas = null;
    private ArrayList<Album> albuns = null;
    private ArrayList<Faixa> faixas = null;
    private Artista artista = new Artista();
    private Album album = new Album();
    private Faixa faixa = new Faixa();

    public CadastroBean() throws ClassNotFoundException {
        ArtistaJpaController ajc = new ArtistaJpaController();
        artistas = new ArrayList(ajc.findArtistas());
    }

    public void cadastroArtistaAction() {
        ArtistaJpaController ajc = new ArtistaJpaController();
        artista.setCodigo(ajc.proxId());
        ajc.persist(artista);
        this.carregaArtistas();
    }

    public void cadastroAlbumAction() {
        AlbumJpaController ajc = new AlbumJpaController();
        ajc.persist(album);
    }

    public void carregaArtistas() {
        ArtistaJpaController ajc = new ArtistaJpaController();
        artistas = new ArrayList(ajc.findArtistas());
    }

    public void carregaAlbuns(int idArtista) {
        AlbumJpaController ajc = new AlbumJpaController();
        albuns = new ArrayList(ajc.findAlbunsByArtista(idArtista));
    }

    public void carregaFaixas(int idAlbum) {
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Faixa getFaixa() {
        return faixa;
    }

    public void setFaixa(Faixa faixa) {
        this.faixa = faixa;
    }

    public List<Artista> getArtistas() {
        return artistas;
    }

    public void setArtistas(ArrayList<Artista> artistas) {
        this.artistas = artistas;
    }
    
     public ArrayList<Album> getAlbuns() {
        return albuns;
    }

    public ArrayList<Faixa> getFaixas() {
        return faixas;
    }
}