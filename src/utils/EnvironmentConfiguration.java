package utils;



/**
 * Created by Eugene on 2/26/2015.
 */
public class EnvironmentConfiguration {
    public String Name;
    public String WebUrl;


 public EnvironmentConfiguration(String env) {
        switch (env) {
            case "Staging":
                this.Name = "staging";
                this.WebUrl = "http://www.thomascook.de/";
                break;

            case "Integration":
                this.Name = "integration";
                this.WebUrl = "http://www.google.com.ua/";
                break;

            case "Production":
                this.Name = "production";
                this.WebUrl = "https://www.ukr.net/";
                break;

            default:
                this.Name = "staging";
                this.WebUrl = "http://www.thomascook.de/";
                break;
        }


}
}




