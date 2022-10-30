import styled from 'styled-components';
import img from '../assets/img.jpg';

const BodyStyled = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  position: relative;
  min-height: 100vh;
  font-family: Verdana, Geneva, Tahoma, sans-serif;
  background-image: url(${img});
  padding: 80px;
  `;

export default BodyStyled;
