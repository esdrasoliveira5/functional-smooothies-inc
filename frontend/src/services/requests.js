const URL_FETCH = 'http://localhost:8080';
const APLICATION = 'application/json';

async function createOrder({ingredient}) {
  console.log(ingredient)
  try {

    const response = await fetch(`${URL_FETCH}/ingredients/create`, {
      method: 'POST',
      headers: {
        Accept: APLICATION,
        'Content-Type': APLICATION,
      },
      body: JSON.stringify({ ingredient }),
    });
    const results = await response.json();
    return results;
  } catch (error) {
    return { error };
  }
}


export default {
    createOrder
}