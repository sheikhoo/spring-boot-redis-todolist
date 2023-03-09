import React from 'react';
import { FaTimes, FaBars } from 'react-icons/fa';

interface Props {
  isActiveNav: boolean;
  onButtonClick: () => void;
}

const Header: React.FC<Props> = ({ isActiveNav, onButtonClick }) => {
  return (
    <header className="flex h-10 justify-between items-center ">
      <button
        type="button"
        title="Menu"
        onClick={onButtonClick}
        className="text-3xl"
      >
        {isActiveNav ? <FaTimes /> : <FaBars />}
      </button>
      <button>theme toggle</button>
    </header>
  );
};

export default Header;
