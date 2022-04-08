package sample.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sample.utils.DButils;

public class UserDAO {

    public UserDTO checkLogin(String userID, String password) throws SQLException {
        UserDTO user = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DButils.getConnection();
            if (conn != null) {
                String sql = " SELECT fullName, roleID "
                        + " FROM tblUsers"
                        + " WHERE userID=? AND password=?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, userID);
                stm.setString(2, password);
                rs = stm.executeQuery();
                if (rs.next()) {
                    String fullName = rs.getString("fullName");
                    String roleID = rs.getString("roleID");
                    user = new UserDTO(userID, fullName, roleID, "");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return user;
    }
    
    public List<UserDTO> getListUser(String search) throws SQLException {
        List<UserDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DButils.getConnection();
            if (conn != null) {
                String sql = " SELECT userID, fullName, roleID, phone, address "
                        + " FROM tblUsers"
                        + " WHERE fullName like ? ";
                stm = conn.prepareStatement(sql);
                stm.setString(1, "%" + search + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    String userID = rs.getString("userID");
                    String fullName = rs.getString("fullName");
                    String roleID = rs.getString("roleID");
                    String phone = rs.getString("phone");
                    String address = rs.getString("address");
                    String password = "***";
                    list.add(new UserDTO(userID, fullName, roleID, password, phone, address));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public boolean deleteUser(String userID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DButils.getConnection();
            if (conn != null) {
                String sql = " DELETE tblUsers "
                        + " WHERE userID=? ";
                stm = conn.prepareStatement(sql);
                stm.setString(1, userID);
                check = stm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    public boolean updtae(UserDTO user) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DButils.getConnection();
            if (conn != null) {
                String sql = " UPDATE tblUsers set fullName=?, roleID=?, phone=?, address=? "
                        + " WHERE userID=? ";
                stm = conn.prepareStatement(sql);
                stm.setString(1, user.getFullName());
                stm.setString(2, user.getRoleID());
                stm.setString(3, user.getPhone());
                stm.setString(4, user.getAddress());
                stm.setString(5, user.getUserID());
                check = stm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    public boolean checkDuplicate(String userID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DButils.getConnection();
            if (conn != null) {
                String sql = " SELECT userID "
                        + " FROM tblUsers "
                        + " WHERE userID=? ";
                stm = conn.prepareStatement(sql);
                stm.setString(1, userID);
                rs = stm.executeQuery();
                if (rs.next()) {
                    check = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    public boolean insert(UserDTO user) throws SQLException, ClassNotFoundException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DButils.getConnection();
            if (conn != null) {
                String sql = " INSERT INTO tblUsers(userID, fullName, roleID, password, phone, address) "
                        + " VALUES(?,?,?,?, ?, ?) ";
                stm = conn.prepareStatement(sql);
                stm.setString(1, user.getUserID());
                stm.setString(2, user.getFullName());
                stm.setString(3, user.getRoleID());
                stm.setString(4, user.getPassword());
                stm.setString(5, user.getPhone());
                stm.setString(6, user.getAddress());
                check = stm.executeUpdate() > 0 ? true : false;
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }
}
