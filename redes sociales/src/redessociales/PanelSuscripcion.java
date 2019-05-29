package redessociales;

import java.util.ArrayList;

public class PanelSuscripcion extends Panel {

	public ArrayList<Perfil> colaboradores;

	public PanelSuscripcion(Perfil autor) {
		super(autor);
		colaboradores=new ArrayList<Perfil>();
	}

	@Override
	public Mensaje publicarMensaje(Mensaje mensaje, String texto, Perfil autor) {
		Mensaje m = new Mensaje(texto, autor, mensaje);
		if (autor.equals(getAutor())) {
			this.getMensajes().add(m);
			return m;

		}
		for (Perfil perfil : colaboradores) {
			if (autor.equals(perfil)) {
				this.getMensajes().add(m);
				return m;
			}
		}
		return null;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		PanelSuscripcion obj = null;
		try {
			obj = (PanelSuscripcion) super.clone();
		} catch (CloneNotSupportedException ex) {
			System.out.println(" no se puede duplicar");
		}
		obj.colaboradores = (ArrayList<Perfil>) obj.colaboradores.clone();
		obj.getMensajes().clear();
		return obj;
	}

	@Override
	public Mensaje publicarMensaje(String texto) {
		Mensaje m = new Mensaje(texto, this.getAutor());

		this.getMensajes().add(m);
		return m;

	}
}
