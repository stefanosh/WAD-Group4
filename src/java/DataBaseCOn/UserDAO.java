package DataBaseCOn;


import java.sql.SQLException;
import java.util.List;
import model.User;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author student
 */
public interface UserDAO {
    	List<User> findAll() throws SQLException;
	User findById(long id);
	User findByUsernameAndPassword(String username, String password);
	boolean insertUser(User user) throws SQLException;
	boolean deleteUser(User user)throws SQLException;
	boolean updateUser(User user)throws SQLException;
}
