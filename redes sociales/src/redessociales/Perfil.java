package redessociales;

import java.util.ArrayList;
import java.util.HashMap;

public class Perfil {

	public String identificador;
	private Panel panelPersonal;

	private HashMap<String, Panel> temas;

	public Perfil(String identificador) {

		this.identificador = identificador;
		this.panelPersonal = new PanelPrivado(this);
		this.temas = new HashMap<String, Panel>();

	}

	public void addTema(String clave) {
		temas.put(clave, new PanelSuscripcion(this));
	}

	public Panel buscarPanel(String tema) {

		return temas.get(tema);

	}

	public Panel getPanelPersonal() {
		return panelPersonal;
	}

	public void setPanelPersonal(Panel panelPersonal) {
		this.panelPersonal = panelPersonal;
	}

	public HashMap<String, Panel> getTemas() {
		return temas;
	}

	public void setTemas(HashMap<String, Panel> temas) {
		this.temas = temas;
	}
	
}
