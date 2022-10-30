import React from 'react';
import FooterStyled from '../styles/FooterStyles';

function Footer() {
  return (
    <FooterStyled>
      <p>©Functional Smoothies by Esdras Oliveira</p>
      <div>
        <a
          href="https://linkedin.com/in/esdrasmoliveira"
          target="blank"
          rel="noreferrer"
        >
          <img
            align="center"
            src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/linked-in-alt.svg"
            alt="esdrasmoliveira"
          />
        </a>
        <a
          href="https://github.com/esdrasoliveira5"
          target="blank"
          rel="noreferrer"
        >
          <img
            align="center"
            src="https://cdn-icons-png.flaticon.com/512/25/25231.png"
            alt="esdrasm.oliveira"
          />
        </a>
      </div>
    </FooterStyled>
  );
}

export default Footer;
