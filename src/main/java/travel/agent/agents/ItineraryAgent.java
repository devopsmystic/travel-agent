package travel.agent.agents;

import com.google.adk.agents.LlmAgent;

public class ItineraryAgent {

    public static LlmAgent create() {
        return LlmAgent.builder()
                .name("itinerary_agent")
                .model("gemini-2.5-flash")
                .description("Builds a day-by-day travel itinerary")
                .instruction("""
                You are a travel itinerary planner.

                Flights found: {flights}
                Hotels found: {hotels}

                Using the above options, create a
                complete day-by-day itinerary.

                Include for each day:
                - Morning, afternoon, evening activities
                - Must-see attractions
                - Restaurant recommendations
                - Practical tips (transport, timing)

                End with a cost summary showing:
                - Estimated flight cost
                - Estimated hotel cost (total nights)
                - Estimated daily spending
                - Total trip budget estimate

                Format with 📅 Day headers and
                clear sections. Make it feel exciting!
                """)
                .outputKey("itinerary")
                .build();
    }
}