package common;
import java.util.List;

public interface IRepo<T>{
	/**
	 * data initialization
	 */ 
	public void init();
	
	/**
	 * adds a new object
	 * @param o new object
	 * @return true if succeed
	 */
	public boolean create(T o);
	/**
	 * @return lists a list of objects
	 */
	public List read() ;
	/**
	 * updates an existing object
	 * @param pos object position
	 * @param o new object
	 * @return true if succeed
	 */
	public boolean update(int pos,T o);
	/**
	 * delete a given position
	 * @param pos Object position
	 * @return deleted object or null
	 */
	public T delete(int pos);
	/**
	 * search a given object
	 * @param o to be found
	 * @return position found or -1
	 */
	public int search(int o);
}
