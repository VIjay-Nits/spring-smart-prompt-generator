
# Spring Smart Prompt Generator
A Spring Boot-powered AI application that leverages OpenAI API to generate text, images, and respond to dynamic prompts. It intelligently processes user inputs, 
transforming them into creative and meaningful outputs through advanced AI models.


<p align="center">
    <img src="Screenshots/1.png" alt="User Interface" width="700" height="400">
    
</p>

<table style="width:100%">
  <tr>
      <th>Method</th>
      <th>Url</th>
      <th>Description</th>
  </tr>
  <tr>
      <td>GET</td>
      <td>http://localhost:8080/chat</td>
      <td>Provide prompt in input & it will generate text response</td>
  <tr>
  <tr>
      <td>GET</td>
      <td>http://localhost:8080/image</td>
      <td>Provide prompt in input & Generate image in response</td>
  <tr>
  <tr>
      <td>GET</td>
      <td>http://localhost:8080/recipe</td>
      <td>Provide prompts in input like ingredients, cuisine & dietaryRestriction(Optional Field) & it will generate complete recipe to prepare a cuision in response</td>
  <tr>
  
  
</table>

### Purpose of this application -
  
- Backend-Frontend Integration: The application connects a React frontend with a Spring Boot backend, ensuring smooth interaction between the user interface and the AI-powered backend logic. This enables real-time input processing and dynamic prompt generation.

- AI and OpenAI API Utilization: By incorporating Spring AI and OpenAI API, the application provides enhanced natural language processing and content generation, capable of interpreting user queries and returning meaningful, context-aware responses in both text and image formats.
  
- AI-Powered Prompt Generation: The primary purpose of the spring-smart-prompt-generator application is to leverage advanced AI models via the OpenAI API to generate dynamic and creative text and image outputs based on user inputs, offering intelligent prompt responses.



### Technologies

---
- Java 21
- Spring Boot 3.0
- Restful API
- Spring Al
- Postman
- Open AI
- React JS
- HTML
- CSS
- Javascript

### Postman

```
Import postman collection Spring AI Model.postman_collection.json file

```


### Prerequisites
  - Define api key in application.properties file 

### How to Run 
---
1. Set the api key in application.properties file
2. Run from springAIModel for backend
3. Run from spring-ai-model-react for frontend


### Screenshots

<details>
<summary>Click here to show the screenshots of project</summary>
    <p> Figure 1 </p>
    <img src ="Screenshots/1.png">
    <p> Figure 2 </p>
    <img src ="Screenshots/2.png">
    <p> Figure 3 </p>
    <img src ="Screenshots/3.png">
    <p> Figure 4 </p>
    <img src ="Screenshots/4.png">
    <p> Figure 5 </p>
    <img src ="Screenshots/5.png">
    <p> Figure 6 </p>
    <img src ="Screenshots/6.png">
    <p> Figure 7 </p>
    <img src ="Screenshots/7.png">
    <p> Figure 8 </p>
    <img src ="Screenshots/8.png">
    <p> Figure 9 </p>
    <img src ="Screenshots/9.png">
    <p> Figure 10 </p>
    <img src ="Screenshots/99.png">
</details>


### Build this with the help of EmbarkX - Special Thanks to Embarx.

