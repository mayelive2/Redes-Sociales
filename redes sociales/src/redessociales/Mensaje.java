package redessociales;

public class Mensaje implements Comparable<Mensaje> {

	private String texto;
	private Perfil autor;
	private boolean independiente = true;
	private Mensaje responde;

	public Mensaje(String texto, Perfil autor, Mensaje responde) {

		this.texto = texto;
		this.autor = autor;
		this.independiente = false;
		this.responde = responde;
	}

	public Mensaje(String texto, Perfil autor) {
		super();
		this.texto = texto;
		this.autor = autor;
		this.independiente = true;
		this.responde = null;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Perfil getAutor() {
		return autor;
	}

	public void setAutor(Perfil autor) {
		this.autor = autor;
	}

	public boolean isIndependiente() {
		return independiente;
	}

	public void setIndependiente(boolean independiente) {
		this.independiente = independiente;
	}

	public Mensaje getResponde() {
		return responde;
	}

	public void setResponde(Mensaje responde) {
		this.responde = responde;
	}

	@Override
	public int compareTo(Mensaje mensaje) {
		if (mensaje.getAutor().identificador.compareTo(this.getAutor().identificador) < 0) {
			return -1;
		} else if (mensaje.getAutor().identificador.compareTo(this.getAutor().identificador) > 0) {
			return 0;
		} else if (mensaje.getAutor().identificador.compareTo(this.getAutor().identificador) == 0) {
			if (mensaje.texto.compareTo(this.texto) < 0) {
				return -1;
			} else if (mensaje.texto.compareTo(this.texto) < 0) {
				return 0;
			}

		} else
			return 0;
		return 0;

	}

	@Override
	public String toString() {
		return "Autor :"+this.getAutor().identificador+"\\n"+this.texto+"\\n"+"es respuesta :"+(this.independiente) != null?"si es independiente":" no es independiente";
		
	}
	
}
