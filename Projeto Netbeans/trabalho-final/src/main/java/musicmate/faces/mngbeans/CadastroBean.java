package musicmate.faces.mngbeans;

import musicmate.persistence.entity.Artista;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
import utfpr.faces.support.PageBean;
import utfpr.persistence.controller.ArtistaJpaController;
import utfpr.persistence.controller.JpaController;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import java.util.Iterator;
import javax.faces.component.UISelectItems;
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

    public CadastroBean() throws ClassNotFoundException {

        ArtistaJpaController ajc = new ArtistaJpaController();
        artistas = new ArrayList(ajc.findArtistas());
    }

    public List<Artista> getArtistas() {
        return artistas;
    }
    
   
}