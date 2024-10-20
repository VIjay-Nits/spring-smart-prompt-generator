import React, { useState } from "react";

function ChatGenerator(){

    // setPrompt function is set with empty prompt
    const [prompt,setPrompt] = useState('');

    // setChatResponse function is set with empty response
    const [chatResponse, setChatResponse] = useState('');

    const askAI = async () => {
        try{
            const response = await fetch(`http://localhost:8080/chat?prompt=${prompt}`)
            
            const data = await response.text();
            console.log(data);
            setChatResponse(data);

        }catch(error){
            console.error("Error generating chat Response :", error)
        }
    }

    return(
        <div>
            <h2>Talk to AI</h2>

            <input type = "text"
                value={prompt}
                onChange={(e) => setPrompt(e.target.value)}
                placeholder="Ask your question here"
            />
            <br/>
            <button onClick={askAI}>Get Response</button>

            <div className="output">
                <pre className="chat-text">
                    {chatResponse}
                </pre>

            </div>

        </div>
       
    );
}

export default ChatGenerator;
