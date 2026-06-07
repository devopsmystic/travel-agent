# ✈️ Travel Agent Assistant

An AI-powered travel planning assistant built with Java, Spring Boot. It orchestrates a sequential multi-agent workflow to search for flights, recommend hotels, and construct a complete day-by-day itinerary.

---

## 🛠️ Google Cloud Platform (GCP) Setup

To use the underlying Gemini model (via Vertex AI), you need to set up a GCP project, configure your local authentication, and enable the Agent Platform API.

### 1. Create a GCP Project
You can create a new GCP project using either the Google Cloud Console

1. Visit the [Google Cloud Console](https://console.cloud.google.com/).
2. Click the project dropdown in the top navigation bar and select **New Project**.
3. Enter your project name/ID and click **Create**.

---

### 2. Connect with `gcloud` CLI
Once your project is created, configure your local environment to connect to it.

1. **Set your active project:**
   ```bash
   gcloud config set project YOUR_PROJECT_ID
   ```

2. **Authenticate Application Default Credentials (ADC):**
   This enables Vertex AI clients running on your local machine to authenticate automatically.
   ```bash
   gcloud auth application-default login
   ```

3. **Set the billing/quota project:**
   This prevents API quota errors by linking calls to your billing account project.
   ```bash
   gcloud auth application-default set-quota-project YOUR_PROJECT_ID
   ```

---

### 3. Enable the Agent Platform API (Vertex AI)
The SDK utilizes the Gemini model through the Vertex AI APIs (`aiplatform.googleapis.com`).

1. Navigate directly to the [Vertex AI API Overview](https://console.developers.google.com/apis/api/aiplatform.googleapis.com/overview?project=YOUR_PROJECT_ID) (replace `YOUR_PROJECT_ID` in the URL).
2. Click the **Enable** button.

---

## 🚀 Building and Running Locally

Once GCP is set up, follow these steps to build and run the application.

### Prerequisites
* Java 17 or higher
* Docker (optional)

### Build the Application
Compile the source code and package it into an executable JAR:
```bash
./gradlew build -x test
```

### Run the Server
Start the application with standard local configurations:
```bash
./gradlew bootRun
```

The server will start, by default listening on port `8080`.

### Test the Agent
Open your web browser and navigate to:
```
http://localhost:8080
```
This opens the built-in interactive web UI where you can chat with the travel agent.
