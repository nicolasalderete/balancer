package ar.com.balancer.ui;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewDisplay;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.SpringViewDisplay;
import com.vaadin.ui.Component;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

import ar.com.balancer.components.menu.MenuBalancer;

@SpringUI
@SpringViewDisplay
public class MyVaadinUI extends UI implements ViewDisplay {

	private static final long serialVersionUID = 1L;
	
	private Panel springViewDisplay;

    @Override
    protected void init(VaadinRequest request) {
        final VerticalLayout rootLayout = new VerticalLayout();
        rootLayout.setSizeFull();
        rootLayout.setMargin(false);
        setContent(rootLayout);
        
        MenuBalancer menuBar = new MenuBalancer();
		rootLayout.addComponent(menuBar);
		
        springViewDisplay = new Panel();
        springViewDisplay.setSizeFull();
        springViewDisplay.addStyleName(ValoTheme.PANEL_BORDERLESS);
        
        rootLayout.addComponent(springViewDisplay);
        rootLayout.setExpandRatio(springViewDisplay, 1.0f);

    }

    @Override
    public void showView(View view) {
        springViewDisplay.setContent((Component) view);
    }
}