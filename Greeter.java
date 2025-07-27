import java.util.Locale;
import java.util.ResourceBundle;

public class Greeter {

  private Locale locale;
  private String name;

  public Greeter(String language, String country, String name) {
    locale = new Locale(language, country);
    this.name = name;
  }

 public String sayHello() {
    ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", locale);
    String capitalizedName = name.substring(0, 1).toUpperCase() + name.substring(1);
    return messages.getString("greeting") + ", " + capitalizedName;
}

public static void main(String[] args) {
    if (args.length != 3) {
        System.out.println("Usage: java Greeter <language> <country> <name>");
        return;
    }
    String language = args[0];
    String country = args[1];
    String name = args[2].toUpperCase();
    Greeter greeter = new Greeter(language, country, name);
    System.out.println(greeter.sayHello());
}
}
