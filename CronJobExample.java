import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class CronJobExample {

    private CronJobExample(){}

    public static void greet() throws IOException {
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        sendHTTPRequest();
    }

    public static void sendHTTPRequest() throws IOException {
        System.out.println("reached");
        URL google = new URL("https://www.google.com/");
        URLConnection gc = google.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(gc.getInputStream()));
        String inputLine;

        while((inputLine = in.readLine()) != null)
            System.out.println("check"+inputLine);
        in.close();
    }

    public static void main(String[] args) throws IOException {

        Timer timer = new Timer();
        MyTask1 task= new MyTask1();
        timer.schedule(task, 0, 10000);

        greet();
        System.exit(0);

    }
}

class MyTask1 extends TimerTask{

    @Override
    public void run() {
        // TODO Auto-generated method stub
        System.out.println(new Date());

    }
}