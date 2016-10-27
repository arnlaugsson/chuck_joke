package is.arnlaugsson.chuck_joke;

import spark.*;
import static spark.Spark.*;
import spark.servlet.SparkApplication;


public class ChuckWeb implements SparkApplication {

    public static void main(String[] args) {
        staticFileLocation("/public");
        SparkApplication chuckweb = new ChuckWeb();

        String port = System.getenv("PORT");
        if (port != null) {
            port(Integer.valueOf(port));
        }

        chuckweb.init();
    }

    @Override
    public void init() {
        final Chuck chuck = new Chuck();    
        post("/random", (req, res) -> chuck.random());
        post("/id", (req, res) -> chuck.getById(req.queryParams("id")));
        post("/setName", (req, res) -> {
            chuck.alterName(
                req.queryParams("firstName"),
                req.queryParams("lastName")
            );          
            res.status(200);
            return res;
        });
    }

}
