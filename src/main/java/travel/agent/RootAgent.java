package travel.agent;

import com.google.adk.agents.BaseAgent;
import com.google.adk.agents.LlmAgent;
import com.google.adk.agents.SequentialAgent;
import travel.agent.agents.FlightAgent;
import travel.agent.agents.HotelAgent;
import travel.agent.agents.ItineraryAgent;
import java.util.List;

public class RootAgent {

    public static BaseAgent ROOT_AGENT = create();

    public static BaseAgent create() {

        SequentialAgent travelWorkflow =
                SequentialAgent.builder()
                        .name("travel_workflow")
                        .description("Full travel planning workflow")
                        .subAgents(List.of(
                                FlightAgent.create(),
                                HotelAgent.create(),
                                ItineraryAgent.create()
                        ))
                        .build();

        return LlmAgent.builder()
                .name("travel_assistant")
                .model("gemini-2.5-flash")
                .description("AI-powered travel planning assistant")
                .instruction("""
                You are a friendly travel planning
                assistant.

                When a user describes a trip:
                1. Greet them warmly
                2. Confirm the destination and dates
                3. Immediately start the travel_workflow
                   which will find flights, hotels,
                   and build a full itinerary

                Do not ask unnecessary questions.
                If destination and rough duration
                are mentioned, start planning!
                """)
                .subAgents(List.of(travelWorkflow))
                .build();
    }
}