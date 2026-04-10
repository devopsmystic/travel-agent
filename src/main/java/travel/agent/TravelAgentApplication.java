package travel.agent;

import com.google.adk.web.AdkWebServer;

public class TravelAgentApplication {

    public static void main(String[] args) throws Exception {

        String port = System.getenv("PORT");
        if (port == null || port.isEmpty()) {
            port = "8080";
        }

        System.setProperty("server.port", port);

        System.out.println(
                "✈️  Travel Agent starting on port " + port
        );

        AdkWebServer.start(RootAgent.ROOT_AGENT);
    }
}