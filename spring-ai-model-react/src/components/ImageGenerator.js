import React, { useState } from "react";

function ImageGenerator() {
    // setPrompt is set with empty prompt
    const [prompt,setPrompt] = useState('');
    // setImageUrls is set with empty urls array
    const [imageUrls,setImageUrls]=useState([]);

    const generateImage = async () =>{
        try{
            const response = await fetch(`http://localhost:8080/image?prompt=${prompt}`)
            const urls = await response.json();
            setImageUrls(urls);

        }catch(error){
            console.error("Error generating image :", error)
        }
    }

    return(
        <div className="tab-content">
        
            <h2>Generate Image</h2>
            <input type="text"
                value={prompt}
                onChange={(e) => setPrompt(e.target.value)}
                placeholder="Enter prompt for image"
            />
            <br></br>
            <button onClick={generateImage}>Generate Image</button>

            <div className="image-grid">
                {imageUrls.map((url,index) =>(
                    <img key={index} 
                        src={url} 
                        alt={`Generated ${index}`}/>
                ))}
                 {/* total 4 slot will display so..for image not genereated 
                 we create empty slots */}
                {[...Array(4-imageUrls.length)].map((_,index) =>(
                    <div key={index + imageUrls.length}
                        className="empty-image-slot"></div>
                ))}

            </div>
        </div>
    );
}

export default ImageGenerator;