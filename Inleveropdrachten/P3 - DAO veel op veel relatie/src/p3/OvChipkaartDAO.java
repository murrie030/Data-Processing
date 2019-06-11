package p3;

import java.util.List;

public interface OvChipkaartDAO {
	public List<OvChipkaart> findByReiziger(int reizigerId);

	public OvChipkaart save(OvChipkaart ovChipkaart);

	public OvChipkaart update(OvChipkaart ovChipkaart);

	public boolean delete(OvChipkaart ovChipkaart);

}
