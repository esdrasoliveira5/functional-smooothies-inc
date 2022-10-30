import React, { useState } from 'react';
import requests from '../services/requests';
import BoxStyled from '../styles/BoxStyles';
import { ButtonGreen } from '../styles/ButtonsStyles';
import FormStyled from '../styles/FormStyles';


function IngredientForm() {
    const [ingredients, setIngredients] = useState('')
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
        console.log(data)
        const response = await requests.createOrder(data)
        if(response.error) {
            window.alert(response.error)
        } else {
            setIngredients(response.ingredient)
        }
    };
    
    return (
        <div>
        <FormStyled>
                    <h3>Ingredients</h3>
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
                <BoxStyled>
                    <p>{ingredients}</p>
                </BoxStyled>
        </div>
    );
}

export default IngredientForm;
