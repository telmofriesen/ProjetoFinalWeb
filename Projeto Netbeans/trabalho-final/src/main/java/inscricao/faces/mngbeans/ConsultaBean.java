/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inscricao.faces.mngbeans;

import com.icesoft.faces.component.ext.HtmlDataTable;
import inscricao.persistence.entity.Revendedor;
import utfpr.persistence.controller.RevendedorJpaController;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import utfpr.faces.support.PageBean;


/**
 *
 * @author telmo
 */
@ManagedBean
@RequestScoped
public class ConsultaBean extends PageBean {
    
    private ListDataModel<Revendedor> revendedoresDataModel;
    private ArrayList<Revendedor> revendedores;
    private String busca;
    
    public ConsultaBean() {
        
        RevendedorJpaController rjc = new RevendedorJpaController();
        revendedores = new ArrayList(rjc.getRevendedores());
        revendedoresDataModel = new ListDataModel<>(revendedores);
    }

    public ListDataModel<Revendedor> getRevendedoresDataModel() {
        return revendedoresDataModel;
    }

    public void setRevendedoresDataModel(ListDataModel<Revendedor> revendedoresDataModel) {
        this.revendedoresDataModel = revendedoresDataModel;
    }
    
    public String getBusca() {
        return busca;
    }

    public void setBusca(String busca) {
        this.busca = busca;
    }
    
    public void buscaTextChanged(ValueChangeEvent event) {
        String filtro = (String) event.getNewValue();
        
        RevendedorJpaController rjc = new RevendedorJpaController();
        revendedores = new ArrayList(rjc.getRevendedores(filtro));
//        revendedoresDataModel = new ListDataModel<>(revendedores);
        
        revendedoresDataModel.setWrappedData(revendedores);
    }
}
