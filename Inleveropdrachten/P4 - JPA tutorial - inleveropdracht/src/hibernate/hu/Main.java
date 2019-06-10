package hibernate.hu;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {
	public static void main(String[] args) throws SQLException, ParseException {

		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		Reiziger r = new Reiziger();
		r.setReizigerId(54);
		r.setAchternaam("Musta");
		r.setGeboortedatum(new SimpleDateFormat("dd-mm-yy").parse("06-12-80"));
		r.setVoorletters("M");

		Reiziger r2 = new Reiziger();
		r2.setReizigerId(55);
		r2.setAchternaam("Mustaf");
		r2.setGeboortedatum(new SimpleDateFormat("dd-mm-yy").parse("06-12-80"));
		r2.setVoorletters("M");

		Reiziger r3 = new Reiziger();
		r3.setReizigerId(56);
		r3.setAchternaam("Mustafa");
		r3.setGeboortedatum(new SimpleDateFormat("dd-mm-yy").parse("06-12-80"));
		r3.setVoorletters("M");

		session.save(r);
		session.save(r2);
		session.save(r3);

		r3.setAchternaam("Tpr");

		session.update(r3);

		session.delete(r2);

		t.commit();
		System.out.println("successfully saved");
		factory.close();
		session.close();
	}
}