import styled from 'styled-components';

const FormStyled = styled.form`
  display: flex;
  flex-direction: column;
  background-color: #F8961E;
  padding: 15px;
  color: #FFFFFF;
  min-width: 300px;
  width: 100%;
  input {
    outline: 0;
    background: #f2f2f2;
    width: 100%;
    border: 0;
    border-radius: 5px;
    margin: 0 0 15px;
    padding: 15px;
    box-sizing: border-box;
    font-size: 14px;
  }
  input:focus {
    background: #DEE2E6;
  }

`;

export default FormStyled;
