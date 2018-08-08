/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library_allocator;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.JOptionPane;

public class HttpURLCon {

    private final String USER_AGENT = "Mozilla/5.0";
    private String phone;
    private String messageBody;

    public HttpURLCon(String phone, String messageBody) {
        this.phone = phone;
        this.messageBody = messageBody;
    }
    
    
    @SuppressWarnings("empty-statement")
    public void sendGet() throws Exception {
        /*"http://127.0.0.1/test/?test=090315145346 hdhdh hdhdhd";*/
        String url = "http://localhost/sms/?smsBody=" + messageBody.replaceAll("\n| ", "%20");//"https://www.bulksmsnigeria.com/api/v1/sms/create?api_token=DnPwotHIFQarE7pukRbAn1nR5cODaMAZCMDnr5MGaWrWJV7akLHdTwXRYBIS&from=Library_Allocator&to=09031514346&body='hello'";
;
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        //Request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        //System.out.println("\nSending 'GET' request to URL : " + url);
        //System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        System.out.println(messageBody.replaceAll("\n| ", "%20"));
        JOptionPane.showMessageDialog(null, response.toString(), "Response", JOptionPane.PLAIN_MESSAGE);
    }
}