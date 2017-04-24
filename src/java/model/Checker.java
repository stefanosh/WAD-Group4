package model;

import DataBaseCOn.UserDAO;
import DataBaseCOn.UserDAOImpl;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author root
 */
public class Checker {
    
    int x;
    UserDAOImpl dao=UserDAOImpl.getInstance();
    public Checker()
    {
     x=0;   
    }
    public static String getHash(String password) {
MessageDigest digest=null;
try {
digest = MessageDigest.getInstance("SHA-1");
} catch (NoSuchAlgorithmException ex) {
ex.printStackTrace();
}
digest.reset();
try {
digest.update(password.getBytes("UTF-8"));
} catch (UnsupportedEncodingException ex) {
ex.printStackTrace();
}
return new BigInteger(1, digest.digest()).toString(16);
}
    public void insertUserFunction(String username, String password,String name,String email, String tel, String gender, String country) throws SQLException
   {
       User u=new User(username,password, name, email,tel,gender,country);
       dao.insertUser(u);
   }

    public boolean userExists(String username) throws SQLException
    {
        
        List<User> users= dao.findAll();
        for(int i=0;i<users.size();i++)
            if( users.get(i).getUsername().trim().equals(username.trim()) ){
                return true;
            }
        return false;
    }
    
}
