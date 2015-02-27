package utils;



/**
 * Created by Eugene on 2/26/2015.
 */
public class EnvironmentConfiguration {
    public String Name;
    public String WebUrl;
    public String ApiUrl;
    public String HubUrl;

    public enum Environments {
        Testing,
        Integration,
        Staging,
        Local,
        Production
    }

  EnvironmentConfiguration(Environments env) {
        switch (env) {
            case Local:
                Name = "local";
                WebUrl = "http://local.adquota.com/";
                this.ApiUrl = "http://localhost:24202/";
                this.HubUrl = "http://localhost:4444/wd/hub";
                break;
            case Integration:
                this.Name = "integration";
                this.WebUrl = "http://oldsst.int.adquota.com:81/";
                this.ApiUrl = "http://api.int.adquota.com/";
                this.HubUrl = "http://localhost:4444/wd/hub";
                break;
            case Production:
                this.Name = "production";
                this.WebUrl = "";
                this.ApiUrl = "";
                this.HubUrl = "";
                break;
            case Staging:
                this.Name = "staging";
                this.WebUrl = "";
                this.ApiUrl = "http://api.stage.adquota.com/";
                this.HubUrl = "";
                break;
            default:
                this.Name = "local";
                this.WebUrl = "http://local.adquota.com/";
                this.ApiUrl = "http://api.local.adquota.com/";
                this.HubUrl = "http://localhost:4444/wd/hub";
                break;
        }


}
}




