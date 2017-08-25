package ar.com.balancer.views;

import javax.annotation.PostConstruct;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

@SpringView(name = BalanzaView.VIEW_NAME)
public class BalanzaView extends VerticalLayout implements View {

	private static final long serialVersionUID = 1L;
	
	public static final String VIEW_NAME = "balanza";

    @PostConstruct
    void init() {
    	Label title = new Label("Balanza");
    	title.addStyleName(ValoTheme.LABEL_H2);
        addComponent(title);
    }

    @Override
    public void enter(ViewChangeEvent event) {
        
    }
}