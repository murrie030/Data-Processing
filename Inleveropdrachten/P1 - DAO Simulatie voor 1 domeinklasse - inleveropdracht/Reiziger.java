package p1DAO;

import java.util.Date;

public class Reiziger {
	private int reizigerId;
	private String naam;
	private Date gbdatum;

	public Reiziger() {

	}

	public void setReizigerId(int reizigerId) {
		this.reizigerId = reizigerId;
	}

	public int getReizigerId() {
		return reizigerId;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public Date getGBdatum() {
		return gbdatum;
	}

	public void setGBdatum(Date gbdatum) {
		this.gbdatum = gbdatum;
	}
}
