package ar.com.balancer.components.clientes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.vaadin.server.FontAwesome;
import com.vaadin.shared.ui.ValueChangeMode;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import ar.com.balancer.domain.Cliente;
import ar.com.balancer.repository.ClienteRepository;

@SpringComponent
@UIScope
public class ClientesLayout extends VerticalLayout {

	private static final long serialVersionUID = 1L;

	private final ClienteRepository repo;
	private final ClienteEditor editor;
	final TextField filter;
	private final Button addNewBtn;
	final Grid<Cliente> grid;
	
	@Autowired
	public ClientesLayout(ClienteRepository clienteRepository, ClienteEditor clienteEditor) {
		this.repo = clienteRepository;
		this.editor = clienteEditor;
		this.filter = new TextField();
		this.filter.setPlaceholder("Filtrar por Nombre");
		this.addNewBtn = new Button("Agregar cliente", FontAwesome.PLUS);
		this.grid = new Grid<>(Cliente.class);
		
		VerticalLayout mainLayout = new VerticalLayout();
		mainLayout.setSizeFull();
		addComponent(mainLayout);
		
		HorizontalLayout actions = new HorizontalLayout(filter, addNewBtn);
		mainLayout.addComponent(actions);
		
		HorizontalLayout table = new HorizontalLayout(grid, editor);
		table.setSizeFull();
		grid.setColumns("id", "nombre", "calle", "numero", "telefono");
		mainLayout.addComponent(table);
		
		filter.setValueChangeMode(ValueChangeMode.LAZY);
		filter.addValueChangeListener(e -> listCustomers(e.getValue()));
		
		grid.asSingleSelect().addValueChangeListener(e -> {
			editor.editcliente(e.getValue());
		});
		
		// Instantiate and edit new Customer the new button is clicked
		addNewBtn.addClickListener(e -> editor.editcliente((new Cliente(""))));
		
		editor.setChangeHandler(() -> {
			editor.setVisible(false);
			listCustomers(filter.getValue());
		});
		
		listCustomers(null);
	}
	
	void listCustomers(String filterText) {
		if (StringUtils.isEmpty(filterText)) {
			grid.setItems(repo.findAll());
		}
		else {
			grid.setItems(repo.findByNombreStartsWithIgnoreCase(filterText));
		}
	}
	
	

}
