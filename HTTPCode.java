import java.util.Scanner;
import java.text.*;
import java.util.*;
import java.io.*;
import java.net.*;
import java.io.*;

//http://ec2-3-12-148-182.us-east-2.compute.amazonaws.com:8090/controller


public class HTTPCode {

    private static String NAME = "SAI";
    //private static final String GET_URL = "http://ec2-3-12-148-182.us-east-2.compute.amazonaws.com:8090/controller/rest/serverstatus";

    public static String greet(String name){

       try {
            sendHTTPRequest();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ("Hello " + name);
    }

    public static void sendHTTPRequest() throws IOException {
        URL url = new URL("TEST_HTTP_1");
        URLConnection uc = url.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));

        String inputLine;

        while((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
	
        in.close();
        
    }

    public static void main(String[] args){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss zzzz", Locale.getDefault());
        for(int i=0; ; i++){
            Date date = new Date();
            System.out.println(dateFormat.format(date) + "   " + greet(NAME));
        }

    }
    
    
}


