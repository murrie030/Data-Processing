package p2DAO;

import java.util.List;
import java.util.ArrayList;
import java.sql.*;

public class ReizigerOracleDAOImpl extends OracleBaseDAO implements ReizigerDAO {
	private List<Reiziger> reizigers = new ArrayList<Reiziger>();

	public List<Reiziger> findAll() {
		return reizigers;
	};

	public List<Reiziger> findAllByGBdatum(String GBdatum) {
		List<Reiziger> GBReiziger = new ArrayList<Reiziger>();
		OvChipkaartOracleDAOImpl im = new OvChipkaartOracleDAOImpl();

		try {
			Connection myConn = getConnection();
			Statement myStmt = myConn.createStatement();
			String strQuery = "SELECT * FROM reiziger WHERE = to_date(" + "'" + GBdatum + "'" + ", 'DD-MM-YYYY)";
			ResultSet rs = myStmt.executeQuery(strQuery);

			while (rs.next()) {
				Reiziger reiziger = new Reiziger();
				reiziger.setNaam(rs.getString("VOORLETTERS") + " " + rs.getString("ACHTERNAAM"));
				reiziger.setReizigerId(rs.getInt("REIZIGERID"));

				for (OvChipkaart ov : im.findByReiziger(reiziger.getReizigerId())) {
					reiziger.voegOvToe(ov);
				}

				reizigers.add(reiziger);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return reizigers;
	}

	public Reiziger save(Reiziger reiziger) {
		try {
			int reizigerIdInt = 0;
			Connection myConn = getConnection();
			Statement myStmt = myConn.createStatement();
			ResultSet myRs = myStmt.executeQuery("SELECT * FROM reiziger ORDER BY reizigerid");
			while (myRs.next()) {
				reizigerIdInt = myRs.getInt("reizigerid");
			}
			
			reizigerIdInt = reizigerIdInt + 1;
			reiziger.setReizigerId(reizigerIdInt);
			
			String[] naam = reiziger.getNaam().split(" ");
			String achternaam = naam[1];
			
			Statement insertStmt = myConn.createStatement();
			insertStmt.executeQuery("INSERT INTO reiziger(reizigerid, voorletters, achternaam) "
					+ "VALUES('"+ reizigerIdInt + "','" + reiziger.getVoorletters() + "','" + achternaam +  "')");
			
			
		}catch(Exception exc) {
			exc.printStackTrace();
		}
		
		return reiziger;
	}
	
	public Reiziger update(Reiziger reiziger) {
		try {
			Connection myConn = getConnection();
			Statement myStmt = myConn.createStatement();
			String voorletter = reiziger.getNaam();
			voorletter = Character.toString(voorletter.charAt(0));
			String[] naam = reiziger.getNaam().split(" ");
			String achternaam = naam[1];
			
			String q = "Update REIZIGER SET voorletters = '" + voorletter + "', ACHTERNAAM = '" + achternaam + "' where REIZIGERID = " + reiziger.getReizigerId();
			ResultSet myRs = myStmt.executeQuery(q);
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		
		return reiziger;
	}
	
	
	public boolean delete(Reiziger reiziger) {
		try {
			Connection myConn = getConnection();
			Statement myStmt = myConn.createStatement();
			ResultSet myRs = myStmt.executeQuery("delete from REIZIGER "
					+ "where REIZIGERID = " + reiziger.getReizigerId());
			return true;
		} catch (Exception exc) {
			exc.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Reiziger> findByGBdatum(String GBdatum) {
		// TODO Auto-generated method stub
		return null;
	}
}