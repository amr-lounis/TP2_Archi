package Interface;

import java.util.ArrayList;
import java.util.Vector;

public interface IDB {
	int executeUpdate(String sql);
	ArrayList<Vector<Object>> executeQuery(String sql);
}
