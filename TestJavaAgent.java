import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TestJavaAgent {

    int amount;
    TestJavaAgent(){
        amount = 1000;
    }

    public static String greet(Name name)
    {
        try {
            System.out.println(" ****");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return ("Hello " + name.getName());
    }

    public static void method (String a, String b, String c, boolean d)
    {
        System.out.println("method with 4 args called");

        for (int i = 0; ; i++) {
            Name name1 = new Name ("JavaAgent", "Executed");
            Name name2= new Name("AppD Successfully","Executed");

            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");	
            System.out.println(sdf.format(cal.getTime()) + " - " + greet(name1));
            System.out.println(sdf.format(cal.getTime()) + " - " + greet(name2));
        }
    }

    public static void main(String[] args) {
        method("A1", "A2", "A3", true);
    }
}


class Name {
    String firstName, lastName;
    Name (String i, String j)
    {
        firstName = i;
        lastName = j;
    }
    public String getName() {
        return (this.firstName + " " + this.lastName);
    }
    public String getFirstName(){
        return this.firstName;
    }
}