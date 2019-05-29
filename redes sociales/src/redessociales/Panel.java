package redessociales;

import java.util.ArrayList;
import java.util.Collections;

public abstract class Panel {
	private Perfil autor;
	private ArrayList<Mensaje> mensajes;

	public Panel(Perfil autor) {
		super();
		this.setAutor(autor);
		this.mensajes = new ArrayList<Mensaje>();
	}

	public ArrayList<Mensaje> consultarRespuesta(Mensaje mensaje) {

		ArrayList<Mensaje> respuestas = new ArrayList<Mensaje>();
		for (Mensaje respuesta : mensajes) {
			if (mensaje.equals(respuesta.getResponde())) {
				respuestas.add(respuesta);
			}
		}
		return respuestas;

	}

	public boolean borrarMensaje(Mensaje mensaje) {

		for (Mensaje m : mensajes) {
			if (m.equals(mensaje)) {
				mensajes.remove(m);
				return true;
			}
		}

		return false;

	}

	

	public abstract Mensaje publicarMensaje(Mensaje mensaje, String texto, Perfil autor);

	public abstract Mensaje publicarMensaje(String texto);

	public Perfil getAutor() {
		return autor;
	}

	public void setAutor(Perfil autor) {
		this.autor = autor;
	}

	public ArrayList<Mensaje> getMensajes() {

		return mensajes;
	}

	public ArrayList<Mensaje> getMensajesOrdenados() {
		Collections.sort(mensajes);
		return mensajes;
	}

	public void setMensajes(ArrayList<Mensaje> mensajes) {
		this.mensajes = mensajes;
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
	

}
