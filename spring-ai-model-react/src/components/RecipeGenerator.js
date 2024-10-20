import React, { useState } from "react";

function RecipeGenerator(){

    const [ingredients,setIngredients] = useState('');
    const [cuisine,setCuisine] = useState('');
    const [dietaryRestriction,setDietaryRestriction]=useState('');
    const [recipe,setRecipe] = useState('');

    const createRecipe = async () => {
        try{
            const response = await fetch(`http://localhost:8080/recipe?ingredients=${ingredients}&dietaryRestriction=${dietaryRestriction}&cuisine=${cuisine}`)
            
            const data = await response.text();
            console.log(data);
            setRecipe(data);

        }catch(error){
            console.error("Error generating chat Response :", error)
        }
    }

    return(
        <div>
            <h2>Create Your Recipe</h2>
            <input type="text"
                value={ingredients}
                onChange={(e) => setIngredients(e.target.value)}
                placeholder="Enter ingredients for Recipe"
            />

            <input type="text"
                value={cuisine}
                onChange={(e) => setCuisine(e.target.value)}
                placeholder="(Optional) Enter Cuision Type (Ex - Indian veg, Chinese)"
            />

            <input type="text"
                value={dietaryRestriction}
                onChange={(e) => setDietaryRestriction(e.target.value)}
                placeholder="(Optional) Enter Dietary Restriction (Ex - Vegan, No garlic)"
            />

            <button onClick={createRecipe}>Create Recipe</button>

            <div className="output">
                <pre className="recipe-text">
                    {recipe}
                </pre>

            </div>





        </div>
        
    );
}

export default RecipeGenerator;