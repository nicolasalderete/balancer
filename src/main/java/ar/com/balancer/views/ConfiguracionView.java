package ar.com.balancer.views;

import javax.annotation.PostConstruct;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

@SpringView(name = ConfiguracionView.VIEW_NAME)
public class ConfiguracionView extends VerticalLayout implements View {

	private static final long serialVersionUID = 1L;
	
	public static final String VIEW_NAME = "configuracion";

    @PostConstruct
    void init() {
    	Label title = new Label("Configuración");
    	title.addStyleName(ValoTheme.LABEL_H2);
        addComponent(title);
    }

    @Override
    public void enter(ViewChangeEvent event) {
        // This view is constructed in the init() method()
    }
}