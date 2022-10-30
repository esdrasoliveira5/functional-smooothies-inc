import React from 'react';
import Footer from '../components/Footer';
import Header from '../components/Header';
import IngredientForm from '../components/IngredientsForm';
import BodyStyled from '../styles/BodyStyles';

function Home() {

  return (
    <BodyStyled>
      <Header />
        <IngredientForm />
      <Footer />
    </BodyStyled>
  );
}
export default Home;
