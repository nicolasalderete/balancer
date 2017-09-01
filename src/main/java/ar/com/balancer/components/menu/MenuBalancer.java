package ar.com.balancer.components.menu;

import com.vaadin.ui.MenuBar;

import ar.com.balancer.views.Administracion;
import ar.com.balancer.views.BalanzaView;
import ar.com.balancer.views.DefaultView;
import ar.com.balancer.views.HistorialView;

public class MenuBalancer extends MenuBar {

	private static final long serialVersionUID = 1L;

	public MenuBalancer() {
		addItem("Andreoli S.A.", null, command -> getUI().getNavigator().navigateTo(DefaultView.VIEW_NAME));
		addItem("BALANZA", command -> getUI().getNavigator().navigateTo(BalanzaView.VIEW_NAME));
		addItem("HISTORIAL", command -> getUI().getNavigator().navigateTo(HistorialView.VIEW_NAME));
		addItem("ADMINISTRACIÓN", command -> getUI().getNavigator().navigateTo(Administracion.VIEW_NAME));
		setWidth("100%");
	}
}
