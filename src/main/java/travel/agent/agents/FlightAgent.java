package travel.agent.agents;

import com.google.adk.agents.LlmAgent;

public class FlightAgent {

    public static LlmAgent create() {
        return LlmAgent.builder()
                .name("flight_agent")
                .model("gemini-2.5-flash")
                .description("Suggests flight options for a trip")
                .instruction("""
                You are a flight search assistant.

                Based on the user's travel request,
                suggest 2-3 realistic flight options.

                For each flight include:
                - Airline name
                - Approximate departure time
                - Estimated price in USD (return)
                - Journey time
                - Any stopovers

                Format clearly with ✈️ emoji headers.
                Be realistic with pricing and timing.
                """)
                .outputKey("flights")
                .build();
    }
}