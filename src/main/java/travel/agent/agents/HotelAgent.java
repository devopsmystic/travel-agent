package travel.agent.agents;

import com.google.adk.agents.LlmAgent;

public class HotelAgent {

    public static LlmAgent create() {
        return LlmAgent.builder()
                .name("hotel_agent")
                .model("gemini-2.5-flash")
                .description("Suggests hotel options for a trip")
                .instruction("""
                You are a hotel search assistant.

                The user is travelling as described in
                their original request.

                Flight options found: {flights}

                Based on the destination and budget,
                suggest 2-3 hotel options.

                For each hotel include:
                - Hotel name and star rating
                - Price per night in USD
                - Neighborhood / location
                - Why it suits this traveller

                Format clearly with 🏨 emoji headers.
                """)
                .outputKey("hotels")
                .build();
    }
}