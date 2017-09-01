package ar.com.balancer.components.transportistas;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@SpringComponent
@UIScope
public class TransportistasLayout extends VerticalLayout {

	private static final long serialVersionUID = 1L;
	
	public TransportistasLayout() {
		VerticalLayout mainLayout = new VerticalLayout();
		mainLayout.setSizeFull();
		addComponent(mainLayout);
		
		mainLayout.addComponent(new Label("Agregar tabla de trasnportistas"));
	}

}
