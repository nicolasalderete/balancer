package ar.com.balancer.components.clientes;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.data.Binder;
import com.vaadin.event.ShortcutAction;
import com.vaadin.server.FontAwesome;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

import ar.com.balancer.domain.Cliente;
import ar.com.balancer.repository.ClienteRepository;

@SpringComponent
@UIScope
public class ClienteEditor extends VerticalLayout {

	private static final long serialVersionUID = 1L;

	private ClienteRepository repo;

	private Cliente cliente;
	TextField nombre = new TextField("Nombre");
	TextField calle = new TextField("Calle");

	/* Action buttons */
	Button save = new Button("Guardar", FontAwesome.SAVE);
	Button cancel = new Button("Cancelar");
	Button delete = new Button("Borrar", FontAwesome.TRASH_O);
	CssLayout actions = new CssLayout(save, cancel, delete);

	Binder<Cliente> binder = new Binder<>(Cliente.class);

	@Autowired
	public ClienteEditor(ClienteRepository repository) {
		this.repo = repository;
		
		setSizeFull();
		addComponents(nombre, calle, actions);

		binder.bindInstanceFields(this);

		// Configure and style components
		setSpacing(true);
		actions.setStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
		save.setStyleName(ValoTheme.BUTTON_PRIMARY);
		save.setClickShortcut(ShortcutAction.KeyCode.ENTER);

		// wire action buttons to save, delete and reset
		save.addClickListener(e -> repo.save(cliente));
		delete.addClickListener(e -> repo.delete(cliente));
		cancel.addClickListener(e -> editcliente(cliente));
		setVisible(false);
	}

	public interface ChangeHandler {

		void onChange();
	}

	public final void editcliente(Cliente c) {
		if (c == null) {
			setVisible(false);
			return;
		}
		final boolean persisted = c.getId() != null;
		if (persisted) {
			// Find fresh entity for editing
			cliente = repo.findOne(c.getId());
		} else {
			cliente = c;
		}
		cancel.setVisible(persisted);

		// Bind cliente properties to similarly named fields
		// Could also use annotation or "manual binding" or programmatically
		// moving values from fields to entities before saving
		binder.setBean(cliente);

		setVisible(true);

		// A hack to ensure the whole form is visible
		save.focus();
		// Select all text in firstName field automatically
		nombre.selectAll();
	}

	public void setChangeHandler(ChangeHandler h) {
		// ChangeHandler is notified when either save or delete
		// is clicked
		save.addClickListener(e -> h.onChange());
		delete.addClickListener(e -> h.onChange());
	}

}
