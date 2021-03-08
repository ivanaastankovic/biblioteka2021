package biblioteka;

import java.util.LinkedList;

import biblioteka.interfejs.BibliotekaInterface;

public class Biblioteka implements BibliotekaInterface {

	private LinkedList<Knjiga> knjige = new LinkedList<Knjiga>();
	@Override
	public void dodajKnjigu(Knjiga knjiga) {
		if(knjiga==null)
			throw new NullPointerException("Knjiga ne sme biti null.");
		if(knjige.contains(knjiga))
			throw new RuntimeException("Knjiga vec postoji");
		knjige.add(knjiga);
	}

	@Override
	public void obrisiKnjigu(Knjiga knjiga) {
		knjige.remove(knjiga);
	}

	@Override
	public LinkedList<Knjiga> vratiSveKnjige() {
		return knjige;
	}

	@Override
	public LinkedList<Knjiga> pronadjiKnjigu(Autor autor, String isbn, String naslov, String izdavac) {
		if(autor==null && isbn==null && naslov==null && izdavac==null) {
			return knjige;
		}
		
		LinkedList<Knjiga> rezultat = new LinkedList<Knjiga>();
		for(Knjiga k:knjige) {
			if(k.getNaslov().contains(naslov)) {
				rezultat.add(k);
			}
		}
		return rezultat;
	}

}
