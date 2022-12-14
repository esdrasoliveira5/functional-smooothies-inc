import styled from 'styled-components';

const FooterStyled = styled.footer`
  background-color: #219EBC;
  padding: 20px;
  color: #023047;
  display: flex;
  justify-content: space-around;
  align-items: center;
  height: 80px;
  position: absolute;
  bottom: 0;
  font-size: 18px;
  width: 100%;
  z-index: 10;
  div {
    display: flex;
    justify-content: space-around;
    a {
      text-decoration: none;
      img {
        padding: 10px;
        width: 30px;
      }
    }
  }

`;

export default FooterStyled;
