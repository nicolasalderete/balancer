package ar.com.balancer.views;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;

import ar.com.balancer.components.clientes.ClientesLayout;
import ar.com.balancer.components.productos.ProductosLayout;
import ar.com.balancer.components.transportistas.TransportistasLayout;

@SpringView(name = Administracion.VIEW_NAME)
@UIScope
public class Administracion extends VerticalLayout implements View {

	private static final long serialVersionUID = 1L;
	
	public static final String VIEW_NAME = "administracion";
	
	@Autowired
	private ClientesLayout clientesTab;

	@Autowired
	private ProductosLayout productosTab;
	
	@Autowired
	private TransportistasLayout transportistasTab;
	
    @PostConstruct
    void init() {
        
        TabSheet tabs = new TabSheet();
        addComponent(tabs);
        
        tabs.addTab(clientesTab, "Clientes");
        tabs.addTab(productosTab, "Productos");
        tabs.addTab(transportistasTab, "Transportistas");
    }

    @Override
    public void enter(ViewChangeEvent event) {
        // This view is constructed in the init() method()
    }
}