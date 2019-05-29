package redessociales;

import java.util.ArrayList;

public class App {

	public static void main(String[] args) {

		Perfil juan = new Perfil("juan");

		juan.addTema("Java vs. C++");

		Perfil pedro = new Perfil("Pedro");
		pedro.addTema("El nuevo estadio del Real Madrid");

		Perfil enrrique = new Perfil("Enrique");

		ArrayList<Perfil> perfiles = new ArrayList<Perfil>();
		perfiles.add(juan);
		perfiles.add(pedro);
		perfiles.add(enrrique);

		ArrayList<Panel> paneles = new ArrayList<Panel>();
		for (Perfil perfil : perfiles) {
			perfil.getPanelPersonal().publicarMensaje("Hola soy " + perfil.identificador + " �Bienvenidos!");
			paneles.add(perfil.getPanelPersonal());
			if (!perfil.getTemas().isEmpty()) {

				for (Panel panel : perfil.getTemas().values()) {
					paneles.add(panel);
				}

			}
		}
		for (Panel panel : paneles) {

			if (panel instanceof PanelPrivado) {
				((PanelPrivado) panel).palabasClave.add("Hola");
				((PanelPrivado) panel).palabasClave.add("Ral Madrid");
				((PanelPrivado) panel).palabasClave.add("Futbol");
			}

		}
		for (Perfil perfil : perfiles) {
			for (Panel panel : paneles) {
				if (panel instanceof PanelSuscripcion && !panel.getAutor().equals(perfil)) {
					((PanelSuscripcion) panel).colaboradores.add(perfil);	
					panel.publicarMensaje(null, "Muy interesante", perfil);
				}
			}
			
		}
		
		for (Panel panel : paneles) {
			System.out.println("propietario :"+panel.getAutor().identificador);
			System.out.println("numero de mensajes:"+panel.getMensajes().size());
			System.out.println(panel.toString());
		}

	}

}
