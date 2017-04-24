package DataBaseCOn;


import DataBaseCOn.UserDAO;
import DataBaseCOn.DBConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static model.Checker.getHash;
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
public class UserDAOImpl implements UserDAO{
    
	private static UserDAOImpl dao = null;
	
        private UserDAOImpl() {}
        
	public static UserDAOImpl getInstance(){
		if(dao == null)
			dao = new UserDAOImpl();
		return dao;
	}
        
        
	public List<User> findAll() throws SQLException {
		List<User> users = new ArrayList<>();
		Connection connection = DBConnection.getConnection();
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM USERS");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				long id = rs.getLong("id");
				String username = rs.getString("username");
				User u = new User(username,id);
				users.add(u);
			}

                return users;
        }

    @Override
    public User findById(long id) {
        User u=new User("notfound",-1);    
        try {
                Connection connection = DBConnection.getConnection();
                PreparedStatement stmt = connection.prepareStatement("SELECT * FROM USERS WHERE USERS.ID="+id);
                ResultSet rs = stmt.executeQuery();
                while(rs.next()) {
                    String username = rs.getString("username");
                    u = new User(username,id);
                }
            } catch (SQLException ex) {
                Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            return u;
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        User u=new User("notfound",-1);    
        try {
                Connection connection = DBConnection.getConnection();
                PreparedStatement stmt = connection.prepareStatement("SELECT * FROM USERS WHERE USERS.USERNAME="+username);
                ResultSet rs = stmt.executeQuery();
                if(!rs.next())
                {
                    System.out.println("Username does not exist!");
                }
                else
                while(rs.next()) {
                    String un = rs.getString("username");
                    String up = rs.getString("password");
                    if(up.equals(password))
                    {
                    long id=rs.getLong("ID");
                    u = new User(username,id);
                    }
                    else System.out.println("Wrong Password");
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            return u;
    }

    @Override
public boolean insertUser(User user) throws SQLException
   {
             String username=user.getUsername();
      long id=user.getId();
             String password =user.getPassword();
      String name =user.getName();
      String email =user.getEmail();
      String tel =user.getTel();
      String gender =user.getGender();
      String country =user.getCountry();
      Connection connection=null;
       try { 
       connection = DBConnection.getConnection();
       connection.setAutoCommit(false);    
       String sql1 = " INSERT INTO A.USERS (USERNAME, PASSWORD, NAME, EMAIL, TEL, GENDER, COUNTRY) 	VALUES (?,?,?,?,?,?,?)";    
       PreparedStatement preparedStmt = connection.prepareStatement(sql1,PreparedStatement.RETURN_GENERATED_KEYS );
      preparedStmt.setString (1,username);
      preparedStmt.setString (2, getHash(password));
      preparedStmt.setString   (3, name);
      preparedStmt.setString (4, email);
      preparedStmt.setString (5, tel);
      preparedStmt.setString   (6, gender);
      preparedStmt.setString (7, country);
      preparedStmt.executeUpdate();       
       connection.commit();
       return true;
       
   }
       catch(SQLException e)
       {
           e.printStackTrace();
           connection.rollback();
           return false;
       }
   }
    @Override
    public boolean deleteUser(User user)throws SQLException {
        return false;
    }

    @Override
    public boolean updateUser(User user) throws SQLException{
        return false;
    }

}

