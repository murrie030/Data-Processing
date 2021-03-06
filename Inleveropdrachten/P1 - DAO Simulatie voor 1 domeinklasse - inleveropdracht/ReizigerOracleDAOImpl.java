package p1DAO;

import java.util.List;
import java.util.ArrayList;

public class ReizigerOracleDAOImpl extends OracleBaseDAO {
	private List<Reiziger> reizigers = new ArrayList<Reiziger>();

	public List<Reiziger> findAll() {
		return reizigers;
	};

	public List<Reiziger> findAllByGBdatum(String GBdatum) {
		List<Reiziger> GBReiziger = new ArrayList<Reiziger>();
		for (Reiziger reiziger : this.reizigers) {
			if (reiziger.getGBdatum() != null) {
				if (reiziger.getGBdatum().toString().contentEquals(GBdatum)) {
					GBReiziger.add(reiziger);
				}
			}
		}

		return GBReiziger;
	}

	public Reiziger save(Reiziger reiziger) {
		if (!this.reizigers.contains(reiziger)) {
			this.reizigers.add(reiziger);
		}
		return reiziger;
	}

	public Reiziger update(Reiziger reiziger) {
		if (!this.reizigers.contains(reiziger)) {
			this.reizigers.remove(reiziger);
			this.reizigers.add(reiziger);
			return reiziger;
		}
		return reiziger;
	}

	public boolean delete(Reiziger reiziger) {
		if (this.reizigers.contains(reiziger)) {
			this.reizigers.remove(reiziger);
			return true;
		}
		return false;
	}
}
