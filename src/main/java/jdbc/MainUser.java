package jdbc;

public class MainUser {
	public static void main(String[] args) {
		UserDAO userDAO = new UserDAO();
	//	userDAO.insertRecord(202,"samir","s@gmail.com");
	//userDAO.insertRecord(158,"samir","s@gmail.com");
	//userDAO.insertRecord(159,"samir","s@gmail.com");
	//userDAO.insertRecord(160,"samir","s@gmail.com");
	//userDAO.deleteRecord("samir");
		userDAO.updateRecord(202,"john","change@gmail.com");
		userDAO.fetchRecord();
		}

}
