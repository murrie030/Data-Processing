package p2DAO;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
	public static void main(String[] args) {
		try {
			ReizigerOracleDAOImpl db = new ReizigerOracleDAOImpl();		
			OvChipkaartOracleDAOImpl dbo = new OvChipkaartOracleDAOImpl();	
			
			OvChipkaart o1 = new OvChipkaart();
			o1.setKaartNummer(1234567);
			o1.setKlasse(1);
			o1.setReizigerId(2);
			o1.setSaldo(20.01);
			dbo.save(o1);
			
			for (OvChipkaart ov : dbo.findByReiziger(2)) {
				System.out.println(ov.getKaartNummer());
			}
			
			Reiziger r1 = new Reiziger();
			Reiziger r2 = new Reiziger();
			Reiziger r3 = new Reiziger();
			
			Date datum1 = new SimpleDateFormat("dd/mm/yyyy").parse("12/02/2017");
			r1.setNaam("Mustafa Toprak");
			r1.setVoorletters("MA");
			r1.setGBdatum(datum1);
			r1 = db.save(r1);
			
			r2.setNaam("Tester 2");
			r2 = db.save(r2);

			r3.setNaam("Tester 3");
			r3 = db.save(r3);

			for (Reiziger reiziger : db.findAll()) {
				System.out.println(reiziger.getNaam());
			}

			System.out.println("Done");
			
			r2.setNaam("Jacob Dubbel");
			db.update(r2);

			for (Reiziger reiziger : db.findAllByGBdatum("22-10-2002")) {
				System.out.println(reiziger.getNaam());
			}
			System.out.println("Datum done");
			
			db.delete(r3);
			System.out.println("Klaar");
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}