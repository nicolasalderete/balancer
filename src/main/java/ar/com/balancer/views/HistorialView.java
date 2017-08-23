package ar.com.balancer.views;

import javax.annotation.PostConstruct;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

@SpringView(name = HistorialView.VIEW_NAME)
public class HistorialView extends VerticalLayout implements View {

	private static final long serialVersionUID = 1L;
	
	public static final String VIEW_NAME = "historial";

    @PostConstruct
    void init() {
    	Label title = new Label("Historial");
    	title.addStyleName(ValoTheme.LABEL_H2);
        addComponent(title);
    }

    @Override
    public void enter(ViewChangeEvent event) {
        // This view is constructed in the init() method()
    }
}