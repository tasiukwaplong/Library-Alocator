package library_allocator;
import java.sql.*;
import javax.swing.*;

public class RegisterUser{
    private Connection con = null;
    private Statement statement = null;
    //variables to send to DB
   private String dept,  mat_id,  fullName, email,  phone,  category,  address;
   Object mat;
   
    public RegisterUser(String dept, String mat_id, String fullName, String email, String phone, String category, String address) {
        this.dept = dept;
        this.mat_id = mat_id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.category = category;
        this.address = address;
    }

    public RegisterUser(Object mat) {
        this.mat = mat;
       }
    
    
   
   
    public void connectToDB() throws SQLException{
        String url = "jdbc:mysql://localhost:3306/library_manager";
        String user = "root";
        String password = "";
            

        try{
            
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(url, user, password);
            
        }catch (Exception e){
            e.printStackTrace();
        }
        
    }
    
   public void registerUser() throws SQLException{
            
    PreparedStatement prep = con.prepareStatement("INSERT INTO `users` (`category`, `department`, `matric_or_id`, `name`, `phone`, `email`, `address`) VALUES (?, ?, ?, ?, ?, ?, ?)");
    prep.setString(1,category); 
//    prep.setString(2,faculty_unit); 
    prep.setString(2,dept);     
    prep.setString(3,mat_id); 
    prep.setString(4,fullName); 
    prep.setString(5,phone); 
    prep.setString(6,email); 
    prep.setString(7,address);

    prep.execute();
                  
   }
   
   public void deleteUser() throws SQLException{
    //deleting a user method
    // JOptionPane.showMessageDialog(null, mat);
    PreparedStatement prep = con.prepareStatement("DELETE FROM `users` WHERE matric_or_id =  ?");
    prep.setString(1,mat.toString()); 
    prep.execute();
    JOptionPane.showMessageDialog(null, "User has been deleted SUCCESSFULLY..!!", "Successful", JOptionPane.PLAIN_MESSAGE);
   }
   
   
   public boolean validateInput(){
   //validate user input and returns true if validation is okay    
   if(!requiredInput(dept) || !minText(5, dept)){
   //dept validator
    sendError("Sorry, Error in your input for department");
    return false;
   }else if(!requiredInput(mat_id) || !minText(5, mat_id)){
    //mat_id validator
        sendError("Sorry, Error in your input for Matric/Staff Id");
        return false;
   }else if(!requiredInput(fullName) || !minText(5, fullName)){
   //dept validator
   sendError("Sorry, Error in your input for name");
   return false;
   }else if(!requiredInput(phone) || !minText(11, phone)){
   //dept validator
    sendError("Sorry, Error in your input for phone Number");
   return false;
   }else if(!requiredInput(category) || !minText(5, category)){
   //dept validator
    sendError("Sorry, Error in your input for category");
        return false;
   }else if(!requiredInput(address) || !minText(10, address)){
   //dept validator
        sendError("Sorry, Error in your input for address");
        return false;
   }
   
   return true;
   }
   
   
   
   public String sendError(String data){
      // MainPage mainPage = new MainPage();
      // mainPage.setErrorMsg(data);
      JOptionPane.showMessageDialog(null, data, "Error", JOptionPane.ERROR_MESSAGE);
       System.out.println(data);
       return data;
   }
   
   public boolean requiredInput(String data){
        //checks if input is empty or not
        return data.trim().length() > 0;
      }
   
   
   public boolean minText(int limiter, String data){
        //checks if data is having minimum chracter count
        return data.trim().length() >= limiter;
   
   }
   
   
   }