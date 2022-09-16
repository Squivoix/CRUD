/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Victor Henrique
 */
public abstract class Utils {

    public static int user_id = 0;
    public static int profile = 0;

    /**
     * Opens a new frame without closing the previous frame.
     *
     * @param frame The frame to be open.
     */
   public static void OpenNewWindow(JFrame frame) {
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Opens a new frame and closes the previous frame.
     *
     * @param frame The frame to be open.
     * @param previousFrame The frame to be closed.
     */
    public static void OpenNewWindow(JFrame frame, JFrame previousFrame) {
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        previousFrame.dispose();
    }

    /**
     * Returns all database registries.
     *
     * @param db The database to be consulted.
     * @return Returns a ResultSet.
     */
    public static ResultSet SelectAllRegistry(String db) {
        try {
            Connection connection = DBConnection.GetConnection();
            
            String sql = "SELECT * FROM " + db;
            Statement command = connection.createStatement();
            
            ResultSet result = command.executeQuery(sql);
            
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    /**
     * Returns a single database registry.
     *
     * @param id The id of the registry.
     * @param db The database to be consulted.
     * @return Returns a ResultSet.
     */
    public static ResultSet SelectSingleRegistry(int id, String db) {
        try {
            Connection connection = DBConnection.GetConnection();
            
            String sql = "SELECT * FROM " + db + " WHERE id = " + id;
            
            Statement command = connection.createStatement();

            ResultSet result = command.executeQuery(sql);
            
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    /**
     * Inserts a new book registry in the database.
     * @param values The values to be inserted.
     * @return Returns true if the registry was successfully inserted.
     */
    public static boolean InsertNewBookRegistry(String[] values) {
        try {
            Connection connection = DBConnection.GetConnection();

            String sql = "INSERT INTO books (isbn, title, author, publisher, year, observations) VALUES (?, ?, ?, ?, ?, ?)";
            
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, values[0]);
            statement.setString(2, values[1]);
            statement.setString(3, values[2]);
            statement.setString(4, values[3]);
            statement.setInt(5, Integer.parseInt(values[4]));
            statement.setString(6, values[5]);

            statement.execute();
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    /**
     * Updates a registry in books database.
     *
     * @param id The id of the registry to be updated.
     * @param values The values to update.
     * @return Returns true if the operation was successfull.
     */
    public static boolean UpdateBookRegistry(int id, String[] values) {
        try {
            Connection connection = DBConnection.GetConnection();

            String sql = "UPDATE books SET isbn = ?, title = ?, author = ?, publisher = ?, year = ?, observations = ? WHERE id = ?";
            
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, values[0]);
            statement.setString(2, values[1]);
            statement.setString(3, values[2]);
            statement.setString(4, values[3]);
            statement.setInt(5, Integer.parseInt(values[4]));
            statement.setString(6, values[5]);
            statement.setInt(7, id);

            statement.execute();
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }
    
    /**
     * Updates a single registry in the given database
     * @param id The id of the regsitry
     * @param db The database to be updated
     * @param column The column of the database
     * @param value The value to be update
     * @return Returns true if the operation was successfull.
     */
    public static boolean UpdateSingleRegistry(int id, String db, String column, String value) {
        try {
            Connection connection = DBConnection.GetConnection();

            String sql = String.format("UPDATE %s SET %s = '%s' WHERE id = %d", db, column, value, id);
            
            Statement statement = connection.createStatement();
            
            statement.execute(sql);
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }
    
    /**
     * Deletes registry from the given database.
     *
     * @param id The id of the registry to be deleted.
     * @param db The database to be consulted.
     * @return Returns true or false depending if succeded or not.
     */
    public static boolean DeleteRegistry(int id, String db) {
        try {
            Connection connection = DBConnection.GetConnection();
            
            String sql = String.format("DELETE FROM %s WHERE id = %d", db, id);
            Statement command = connection.createStatement();
            
            command.execute(sql);
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    /**
     * Borrows a book.
     * @param book_id The id of the book to be borrowed.
     * @return Returns true if the operation was successfull.
     */
    public static boolean BorrowBook(int book_id) {
        try {
            Connection connection = DBConnection.GetConnection();
            
            String sql = String.format("UPDATE books SET borrowed = TRUE WHERE id = " + book_id);
            
            Statement statement = connection.createStatement();
            
            statement.execute(sql);
            
            sql = "INSERT INTO borrows (id_book, id_user) VALUES (?, ?)";
            
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, book_id);
            preparedStatement.setInt(2, user_id);

            preparedStatement.execute();
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }

    /**
     * Selects all borrow registries that matches the user id.
     * @return Returns all registries that contains the id of the user.
     */
    public static ResultSet SelectUserBorrows() {
        try {
            Connection connection = DBConnection.GetConnection();
            String sql = "SELECT * FROM borrows WHERE id_user = " + user_id;
            
            Statement command = connection.createStatement();
            
            ResultSet result = command.executeQuery(sql);
            
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    /**
     * Unborrows a book.
     * @param id The id of the borrow.
     * @param book_id The id of the bok.
     * @return Returns true if operation was successfull.
     */
    public static boolean UnBorrowBook(int id, int book_id) {
        try {
            Connection connection = DBConnection.GetConnection();
            
            String sql = "UPDATE borrows SET date_effective = NOW(), is_returned = TRUE WHERE id = " + id;
            Statement command = connection.createStatement();
            
            command.execute(sql);
            
            sql = "UPDATE books SET borrowed = FALSE WHERE id = " + book_id;
            command = connection.createStatement();
            
            command.execute(sql);
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    /**
     * Verifies if book has been borrowed
     * @param id The id of the borrow
     * @return Returns true if book have been returned, and returns false if book has not been returned.
     */
    public static boolean VerifyBorrow(int id) {
        try {
            Connection connection = DBConnection.GetConnection();
            
            String sql = "SELECT is_returned FROM borrows WHERE id = " + id;
            
            Statement statement = connection.createStatement();
            
            ResultSet result = statement.executeQuery(sql);
            
            while(result.next()) {
                return result.getBoolean("is_returned");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    /**
     * Filters the book registry, adn return the result if found any. This function also orders the result if given any.
     * @param filter The words to look for in the database.
     * @param orderTitle The title of the column to order by. If null the function orders by ASC.
     * @param order The order, if is DESC or ASC.
     * @return 
     */
    public static ResultSet FilterBooks(String filter, String orderTitle, String order) {
        try {
            Connection connection = DBConnection.GetConnection();
            StringBuilder sql = new StringBuilder();
            
            if(profile == 5) {
                sql.append("SELECT * FROM books WHERE id LIKE '%");
                sql.append(filter);
                sql.append("%' OR isbn LIKE '%");
            } else {
                sql.append("SELECT * FROM books WHERE isbn LIKE '%");
            }
            
            sql.append(filter);
            sql.append("%' OR title LIKE '%");
            sql.append(filter);
            sql.append("%' OR author LIKE '%");
            sql.append(filter);
            sql.append("%' OR publisher LIKE '%");
            sql.append(filter);
            sql.append("%' OR year LIKE '%");
            sql.append(filter);
            sql.append("%' OR observations LIKE '%");
            sql.append(filter);
                
            if(orderTitle.equals("null")) {
                sql.append("%'");
            } else if(!filter.equals("null") && !orderTitle.equals("null")) {
                sql.append("%' ORDER BY ");
                sql.append(orderTitle);
                sql.append(" ");
                sql.append(order);
            } else {
                sql.delete(0, sql.length());
                sql.append("SELECT * FROM books ORDER BY ");
                sql.append(orderTitle);
                sql.append(" ");
                sql.append(order);
            }
                       
            Statement command = connection.createStatement();
            
            ResultSet result = command.executeQuery(sql.toString());
            
            return result;
        } catch(SQLException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    /**
     * Verifies if email is already registered in database.
     *
     * @param email The email to be verified.
     * @return Returns true if the email is available for use and returns false if email is not available.
     */
    public static boolean VerifyUserAvailability(String email) {
        try {
            Connection connection = DBConnection.GetConnection();
            
            String sql = "SELECT * FROM users";
            Statement command = connection.createStatement();
            ResultSet result = command.executeQuery(sql);
            
            while (result.next()) {
                if (result.getString("email").equals(email)) {
                    return false;
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return true;
    }

    /**
     * Verify if user is registered in database.
     *
     * @param email The email of the user.
     * @param password The password of the user.
     * @return Return true if user exist and returns false if user does not exist.
     */
    public static boolean VerifyExistingUser(String email, char[] password) {
        try {
            String pass = "";
            for(char c: password) {
                pass += c;
            }
            
            Connection connection = DBConnection.GetConnection();
            
            String sql = "SELECT * FROM users";
            Statement command = connection.createStatement();
            ResultSet result = command.executeQuery(sql);
            
            while (result.next()) {
                if (result.getString("email").equals(email) && result.getString("password").equals(pass)) {
                    return true;
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }

    /**
     * Register a new client user.
     *
     * @param name The name of the user.
     * @param email The email of the user.
     * @param password The password of the user.
     * @param profile The profile of the user.
     * @return Returns true if operation was successfull.
     */ 
    public static boolean RegisterNewUser(String name, String email, char[] password, int profile) {
        try {
            String pass = "";
            for(char c : password) {
                pass += c;
            }
            
            Connection connection = DBConnection.GetConnection();

            String sql = "INSERT INTO users (name, email, password, profile) VALUES (?, ?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, pass);
            statement.setInt(4, profile);

            statement.execute();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }
    
    /**
     * Modifies the user.
     * @param id The id of the user.
     * @param values The values to be inserted.
     * @return Returns true if the operations was successfull.
     */
    public static boolean ModifyUser(int id, String[] values) {
        try {
            Connection connection = DBConnection.GetConnection();

            String sql = "UPDATE users SET name = ?, email = ?, password = ?, profile = ? WHERE id = ?";
            
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, values[0]);
            statement.setString(2, values[1]);
            statement.setString(3, values[2]);
            statement.setInt(4, Integer.parseInt(values[3]));
            statement.setInt(5, id);

            statement.execute();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }
    
    /**
     * Modifies the user.
     * @param id The id of the user.
     * @param name The new name of the user.
     * @param email The new email of the user.
     * @param password The new password of the user.
     * @return Returns true if the operations was successfull.
     */
    public static boolean ModifyUser(int id, String name, String email, String password) {
        try {
            Connection connection = DBConnection.GetConnection();

            String sql = "UPDATE users SET name = ?, email = ?, password = ? WHERE id = " + user_id;
            
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, password);

            statement.execute();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    /**
     * Sets the user profile.
     *
     * @param email The user email.
     */
    public static void SetUserProfile(String email) {
        try {
            Connection connection = DBConnection.GetConnection();
            
            String sql = "SELECT * FROM users WHERE email = '" + email + "'";
            Statement command = connection.createStatement();
            ResultSet result = command.executeQuery(sql);
            
            while (result.next()) {
                user_id = result.getInt("id");
                profile = result.getInt("profile");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
