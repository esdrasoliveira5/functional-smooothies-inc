import React, { useState } from 'react';
import requests from '../services/requests';
import BoxStyled from '../styles/BoxStyles';
import { ButtonGreen } from '../styles/ButtonsStyles';
import FormStyled from '../styles/FormStyles';


function IngredientForm() {
    const [ingredients, setIngredients] = useState(null)
    const [data, setdata] = useState({
        ingredient: '',
    })

    const handleFormData = ({ target }) => {
        const { name, value } = target;
        setdata({
            ...data,
            [name]: value,
        });
    };

    const submitForm = async () => {
        const response = await requests.createOrder(data)
        if(response.error) {
            window.alert(response.error)
        } else {
            setIngredients(response.ingredient)
        }
    };

    const handleSubmit = event => {
        event.preventDefault();
        submitForm()
      };

    return (
        <div>
        <FormStyled onSubmit={handleSubmit}>
                    <h1>Select the Smoothie</h1>
                    <h3>Menu</h3>
                        <li>Classic: strawberry, banana, pineapple, mango, peach, honey</li>
                        <li>Freezie: blackberry, blueberry, black currant, grape juice, frozen yogurt</li>
                        <li>Greenie: green apple, lime, avocado, spinach, ice, apple juice</li>
                        <li>Just Desserts: banana, ice cream, chocolate, peanut, cherry</li>
                    <h3>Instructions</h3>
                    <p>Enter the name of the Selected Smoothie followed by the ingredients to be removed separated by a comma.</p>
                    <p> The ingredient must be preceded by the symbol "-".</p>
                    <p ><b> Ex: Classic,-strawberry,-banana</b></p>
                    <p></p>
                    <label htmlFor="latitude">
                        <input
                            type="text"
                            value={data.ingredient}
                            name="ingredient"
                            placeholder="Ingredients"
                            onChange={(event) => handleFormData(event)}
                        />
                    </label>
                    <ButtonGreen>
                        <button
                            type="button"
                            onClick={submitForm}
                        >
                            Submit
                        </button>
                    </ButtonGreen>
        </FormStyled>
        { ingredients == null ? "" :         
            <BoxStyled>
                <h3>Ingredients List</h3>
                <p>{ingredients}</p>
            </BoxStyled>
        }
        </div>
    );
}

export default IngredientForm;
