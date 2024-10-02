package farmacia.model;

import java.util.List;
import java.util.Vector;

import common.FileUtil;
import common.IRepo;
/**
 * Class Repositorio of Clientes implementing an Interface IRepo
 * @author Fernando
 *
 */
public class RepoFileBinFarmacia implements IRepo<Farmacia>{
	final String filePathFarmacia ="data/farmacias.dat";
	private List<Farmacia> farmacias;
	public RepoFileBinFarmacia(){
		init();
	}
	/**
	 * data initialization
	 */ 
	public void init() {
		List<Farmacia> cTemp=FileUtil.readList(filePathFarmacia);
		if (cTemp==null)
			farmacias=new Vector<>();
		else
			farmacias=cTemp;
	}
	
	/**
	 * adds a new farmacia
	 * @param o new farmacia
	 * @return true if succeed or false
	 */
	public boolean create(Farmacia o) {
		try {
			farmacias.add(o);
			FileUtil.save(filePathFarmacia, farmacias);
		}catch(Exception e) {
			return false;
		}
		return true;
	}
	/**
	 * @return list of clientes
	 */
	public List<Farmacia> read() {
		return farmacias;
	}
	/**
	 * update an existing farmacia
	 * @param pos farmacia position
	 * @param o new farmacia
	 * @return true if succeed
	 */
	public boolean update(int pos,Farmacia o) {
		try {
			farmacias.set(pos,o);
			FileUtil.save(filePathFarmacia, farmacias);
		}catch(Exception e) {
			return false;
		}
		return true;
	}
	/**
	 * delete a given farmacia
	 * @param pos farmacia position
	 * @return farmacia deleted or null
	 */
	public Farmacia delete(int pos) {
		try {
			Farmacia ret=farmacias.remove(pos);
			FileUtil.save(filePathFarmacia, farmacias);
			return ret;
		}catch(Exception e) {
			return null;
		}
	}

	/**
	 * search a given farmacia
	 * @param o farmacia to be found
	 * @return position or -1
	 */
	public int search(int o) {
		for (int i=0;i<farmacias.size();i++) {
			Farmacia e=farmacias.get(i);
			if(e.equals(o))
				return i;
		}
		return -1;
	}
}
