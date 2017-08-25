package ar.com.balancer.ui;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewDisplay;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.SpringViewDisplay;
import com.vaadin.ui.Component;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

import ar.com.balancer.constants.Styles;
import ar.com.balancer.views.BalanzaView;
import ar.com.balancer.views.ConfiguracionView;
import ar.com.balancer.views.HistorialView;

@SpringUI
@SpringViewDisplay
public class MyVaadinUI extends UI implements ViewDisplay {

	private static final long serialVersionUID = 1L;
	
	private Panel springViewDisplay;

    @Override
    protected void init(VaadinRequest request) {
        final VerticalLayout rootLayout = new VerticalLayout();
        rootLayout.setSizeFull();
        rootLayout.setMargin(true);
        rootLayout.setSpacing(true);
        setContent(rootLayout);
        
        MenuBar menuBar = new MenuBar();
		menuBar.addItem("Balanza", command -> getUI().getNavigator().navigateTo(BalanzaView.VIEW_NAME));
		menuBar.addItem("Historial", command -> getUI().getNavigator().navigateTo(HistorialView.VIEW_NAME));
		menuBar.addItem("Configuración", command -> getUI().getNavigator().navigateTo(ConfiguracionView.VIEW_NAME));
		menuBar.setWidth(Styles.Width.CIEN_PERCENT);
		menuBar.addStyleNames(ValoTheme.WINDOW_TOP_TOOLBAR);
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