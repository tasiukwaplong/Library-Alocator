/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library_allocator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author ALLAH NA MU
 */
public class TestClass {
    public static void main(String args[]){
        setResourceModel();
    }
    
        public static void setResourceModel(){
        Vector<String> columnNames = new Vector<String>();
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();

		try (
                        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_manager", "root", "");
                        Statement st = connect.createStatement();) {
			Class.forName("com.mysql.jdbc.Driver");
			String sql = "SELECT title FROM resources";
			ResultSet rs = st.executeQuery(sql);
			ResultSetMetaData metaData = rs.getMetaData();
			int columns = metaData.getColumnCount();
          
                        while (rs.next()) {
				Vector<Object> row = new Vector<Object>(columns);
				
                                for (int i = 1; i <= columns; i++) {
					row.addElement(rs.getObject(i));
                                        System.out.println(rs.getObject(i));
				}
//                                setResourceModel.setSelectedItem(row);
				data.addElement(row);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
    }
}
