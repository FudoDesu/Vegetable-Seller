
package sample.vegetable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sample.utils.DButils;

public class vegetableDAO {
    public List<vegetableDTO> getList(String search) throws SQLException {
        List<vegetableDTO> list= new ArrayList<>();
        Connection conn= null;
        PreparedStatement stm= null;
        ResultSet rs= null;
        try {
            conn = DButils.getConnection();
            if (conn != null) {
                String sql = " SELECT p.ProductID, p.ProductName, p.ProductPrice, p.Quantity, p.categoryID, p.description, c.categoryName "
                        + " FROM tblProduct p , tblCategory c "
                        + " WHERE p.categoryID = c.categoryID AND ProductName like ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, "%" + search + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    String productID = rs.getString("ProductID");
                    String productName = rs.getString("ProductName");
                    String category = rs.getString("categoryName");
                    int productPrice = rs.getInt("ProductPrice");
                    int quantity = rs.getInt("Quantity");
                    String description = rs.getString("description");
                    list.add(new vegetableDTO(productID, productName, category, productPrice, quantity, description));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs!= null) rs.close();
            if (stm!= null) stm.close();
            if (conn!= null) conn.close();
        }
        return list;
    }
}
