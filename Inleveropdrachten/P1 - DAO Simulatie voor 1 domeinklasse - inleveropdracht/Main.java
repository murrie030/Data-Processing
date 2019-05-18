package p1DAO;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
	public static void main(String[] args) {
		try{
			ReizigerOracleDAOImpl db = new ReizigerOracleDAOImpl();
			
			Reiziger r1 = new Reiziger();
			Reiziger r2 = new Reiziger();
			Reiziger r3 = new Reiziger();
			
			Date datum1 = new SimpleDateFormat("dd/mm/yyyy").parse("12/02/2017");
			r1.setNaam("Mustafa Toprak");
			r1.setGBdatum(datum1);
			db.save(r1);
			
			r2.setNaam("Tester 2");
			db.save(r2);
			
			r3.setNaam("Tester 3");
			db.save(r3);
			
			for (Reiziger reiziger : db.findAll()) {
				System.out.println(reiziger.getNaam());
			}
			System.out.println("Done");
			
			r2.setNaam("Jacob Dubbel");
			db.update(r2);
			
			for (Reiziger reiziger : db.findAllByGBdatum(datum1.toString())) {
				System.out.println(reiziger.getNaam());
			}
			System.out.println("Datum done");
			
			db.delete(r3);
			
			for (Reiziger reiziger :db.findAll()) {
				System.out.println(reiziger.getNaam());
			}
			System.out.println("Klaar");
			
		}catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
