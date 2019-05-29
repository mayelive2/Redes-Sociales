package redessociales;

import java.util.HashSet;

public class PanelPrivado extends Panel {

	HashSet<String> palabasClave;
	HashSet<Mensaje> seguimientos;

	public PanelPrivado(Perfil autor) {
		super(autor);
		this.palabasClave = new HashSet<String>();
		this.seguimientos = new HashSet<Mensaje>();
	}

	@Override
	public Mensaje publicarMensaje(Mensaje mensaje, String texto, Perfil autor) {
		if (mensaje != null) {
			Mensaje m = new Mensaje(texto, autor, mensaje);

			for (String string : palabasClave) {
				if (mensaje.getTexto().contains(string)) {
					seguimientos.add(mensaje);
					return m;
				}
			}
			this.getMensajes().add(m);
		}
		return null;

	}

	@Override
	public Mensaje publicarMensaje(String texto) {

		Mensaje m = new Mensaje(texto, this.getAutor());

		for (String string : palabasClave) {
			if (m.getTexto().contains(string)) {
				seguimientos.add(m);
				return m;
			}
			this.getMensajes().add(m);
		}

		return null;
	}

	@Override
	public boolean borrarMensaje(Mensaje mensaje) {
		if(seguimientos.contains(mensaje)) return false;
		return super.borrarMensaje(mensaje);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		System.out.println("no se puede copiar un panel privado");
		return null;
	}
	
	
	
}
