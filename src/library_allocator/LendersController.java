package library_allocator;
import java.sql.*;
import javax.swing.*;

public class LendersController{
    private Connection con = null;
    private Statement statement = null;
    public String resourceId = null;
    public String resourceType = null;
    public String resourceCopies = null;
    
//variables to send to DB
   private String  id, mat_id,  bookTitle, dateCollected,  returnDate;

    public LendersController(String mat_id, String bookTitle,  String dateCollected, String returnDate) {
        this.mat_id = mat_id;
        this.bookTitle = bookTitle;
      //  this.bookNumber = bookNumber;
        this.dateCollected = dateCollected;
        this.returnDate = returnDate;
    }

    public LendersController(String mat_id) {
        this.mat_id = mat_id;
    }    

   public LendersController() {
       
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
    
   public void registerLender() throws SQLException{
        PreparedStatement prep = con.prepareStatement("INSERT INTO `lended` (`matric_or_id`, `book_title`, `date_collected`, `return_date`) VALUES (?, ?, ?, ?)");
         prep.setString(1,mat_id); 
         prep.setString(2,bookTitle); 
         prep.setString(3,dateCollected); 
         prep.setString(4,returnDate); 
         
         if(prep.executeUpdate() == 1){
             //System.out.println("UPDATE `resources` SET copies = copies - 1 WHERE `title` = ? AND copies > 0");
             PreparedStatement prep2 = con.prepareStatement("UPDATE `resources` SET copies = copies - 1 WHERE `title` = ? AND copies > 0");
             prep2.setString(1, bookTitle);
             prep2.executeUpdate();
         }
                  
   }
   
   public void deleteLended() throws SQLException{
    //deleting a user method
    PreparedStatement prep = con.prepareStatement("DELETE FROM `lended` WHERE matric_or_id =  ?");
    prep.setString(1,mat_id.toString()); 
    prep.execute();
    JOptionPane.showMessageDialog(null, "Data has been deleted SUCCESSFULLY..!!", "Successful", JOptionPane.PLAIN_MESSAGE);
                
   }
   
   public boolean checkMatric_Id(String mat_Id) throws SQLException{
   //check if user is already entered, and return matric or id of student
    PreparedStatement prep = con.prepareStatement("SELECT count(matric_or_id) FROM `users` WHERE matric_or_id =  ?");
    prep.setString(1, mat_Id); 
    ResultSet rs = prep.executeQuery();
    rs.next();
    
    //JOptionPane.showMessageDialog(null, "passed", "Successful", JOptionPane.PLAIN_MESSAGE);
    
    if(rs.getInt(1) >= 1){
        //JOptionPane.showMessageDialog(null, rs.getInt(1), "Successful", JOptionPane.PLAIN_MESSAGE);
        return true;
    }
    return false;
   }
   
    public String getLenderPhone(String mat_Id) throws SQLException{
        //check if user is already entered, and return matric or id of student
         PreparedStatement prep = con.prepareStatement("SELECT * FROM `users` WHERE matric_or_id =  ?");
         prep.setString(1, mat_Id); 
         ResultSet rs = prep.executeQuery();

         if(rs.next()){
             String lenderPhone = rs.getString("phone");
             return lenderPhone;
         }
         return null;
   }
      
   public void updateLenderStatus(String id) throws SQLException{
    PreparedStatement prep = con.prepareStatement("UPDATE `lended` SET `status` = 1 WHERE `id` = ?");
    prep.setString(1, id); 
    prep.execute();    
   }
    
   public boolean validateInput(){
   //validate user input and returns true if validation is okay    
   if(!requiredInput(mat_id) || !minText(5, mat_id)){
   //dept validator
    sendError("Sorry, Error in your input for mat_id");
    return false;
   }else if(!requiredInput(bookTitle) || !minText(3, bookTitle)){
   //dept validator
    sendError("Invalid resource title");
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
   
   public void getResourceDetails (String bTitle) throws SQLException{
        //check if user is already entered, and return matric or id of student
       
        connectToDB();
        PreparedStatement prep = con.prepareStatement("SELECT * FROM `resources` WHERE title =  ? LIMIT 1");
        prep.setString(1, bTitle);
        ResultSet rs = prep.executeQuery();
        
        if(rs.next()){
        resourceId = rs.getString("resource_id");
        resourceType = rs.getString("type");
        resourceCopies  = rs.getString("copies");
        }
   }
   
   }