package library_allocator;
import java.sql.*;
import javax.swing.*;

public class ResourceController{
    private Connection con = null;
    private Statement statement = null;
    //variables to send to DB
//   private String dept,  mat_id,  fullName, email,  phone,  category,  faculty_unit,  address;


   private String resourceType, resourceId, resourceTitle;
   private int resourceCopies;


  // Object mat;

    public ResourceController(String resourceType, String resourceId, String resourceTitle, int resourceCopies) {
        this.resourceType = resourceType;
        this.resourceId = resourceId;
        this.resourceTitle = resourceTitle;
        this.resourceCopies = resourceCopies;
    }
   
    

    /*public ResourceController(Object mat) {
        this.mat = mat;
        // JOptionPane.showMessageDialog(null, mat);
    }*/

    public ResourceController(String resourceTitle) {
        this.resourceTitle = resourceTitle;
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
    PreparedStatement prep = con.prepareStatement("INSERT INTO `resources` (`type`, `resource_id`, `title`, `copies`) VALUES (?, ?, ?, ?) ON DUPLICATE KEY UPDATE `type` = ?, `resource_id` = ?, `title` = ?, `copies` = ?");
    prep.setString(1,resourceType); 
    prep.setString(2,resourceId); 
    prep.setString(3,resourceTitle);     
    prep.setInt(4,resourceCopies);
    //IN CASE data already exist
    prep.setString(5,resourceType); 
    prep.setString(6,resourceId); 
    prep.setString(7,resourceTitle);     
    prep.setInt(8,resourceCopies);
    prep.execute();
                  
   }
   
   public boolean validateInput(){
   //validate user input and returns true if validation is okay    
   if(!requiredInput(resourceId) || !minText(2, resourceId)){
    sendError("Sorry, Error in resource Id");
    return false;
   }else if(!requiredInput(resourceTitle) || !minText(1, resourceTitle)){
        sendError("Resource title too short");
        return false;
   }else if(resourceCopies < 1){
       sendError("Sorry, resource copies must be greater than zero");
   return false;
   }
   
   return true;
   }
   
   
   
   public String sendError(String data){
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
   
    public void deleteResource() throws SQLException{
        //deleting a resource
        PreparedStatement prep = con.prepareStatement("DELETE FROM `resources` WHERE title =  ?");
        prep.setString(1, resourceTitle); 
        prep.execute();
        JOptionPane.showMessageDialog(null, "Resource deleted..!!", "Successful", JOptionPane.PLAIN_MESSAGE);

   }
   
   }