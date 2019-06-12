package p2DAO;

import java.util.ArrayList;

public class Reiziger {
	private String naam;
	private String gbdatum;
	private ArrayList<OvChipkaart> ovKaarten; 
	private int reizigerId;

	public Reiziger() {
	};

	public Reiziger(String naam, String gbdatum) {
		this.gbdatum = gbdatum;
		this.naam = naam;
		ovKaarten = new ArrayList<OvChipkaart>();

	}

	public Reiziger(String naam, String gbdatum, int reizigerId) { 
		this.naam = naam;
		this.gbdatum = gbdatum;
		this.reizigerId = reizigerId;
		ovKaarten = new ArrayList<OvChipkaart>();

	}

	public void setReizigerId(int reizigerid) {
		this.reizigerId = reizigerId;
	}

	public int getReizigerId() {
		return reizigerId;
	}

	public void voegKaartToe(OvChipkaart kaart) {
		ovKaarten.add(kaart);
		System.out.println("kaart toegevoegd");
	}

	public ArrayList<OvChipkaart> getovKaarten() {
		return ovKaarten;
	}

	public String getNaam() { 
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public String getGBdatum() { 
		return gbdatum;
	}

	public void setGBdatum(String gbdatum) { 
		this.gbdatum = gbdatum;
	}
	
	public void voegOvToe(OvChipkaart ov) {
		if (!this.ovKaarten.contains(ov)) {
			this.ovKaarten.add(ov);
		}
	}
	public String toString() {
		String s = "Naam: " + naam + " , Geboortedatum: " + gbdatum;
		return s;
	}
}
