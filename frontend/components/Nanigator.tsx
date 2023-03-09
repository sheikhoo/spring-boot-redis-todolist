'use client';
import { cva } from 'class-variance-authority';
import React, { useEffect, useMemo, useState } from 'react';
import { usePathname } from 'next/navigation';
import { _nav } from '@/constants/nav';
import Header from './Header';

interface Props {
  children: React.ReactNode;
}

const Nanigator: React.FC<Props> = ({ children }) => {
  const pathname = usePathname();
  const [active, setActive] = useState<boolean>(false);

  const toggleSidebar = () => {
    setActive((x) => !x);
  };

  const nav = useMemo(() => {
    return _nav.find((item) => item.link === pathname) || null;
  }, [pathname]);

  useEffect(() => {
    toggleSidebar;
  }, [pathname]);

  return (
    <main className="relative min-h-screen overflow-x-hidden flex w-full">
      <div className={sidebar({ active })}>sidebar</div>
      <div className={content({ active })}>
        <Header isActiveNav={active} onButtonClick={toggleSidebar} />
      </div>
    </main>
  );
};

export default Nanigator;

const sidebar = cva(
  [
    'bg-[#ccc] dark:bg-[#111] absolute top-0 w-3/4 h-full transition-all duration-300',
  ],
  {
    variants: {
      active: {
        true: ['left-0'],
        false: ['left-3/4'],
      },
    },
    defaultVariants: {
      active: false,
    },
  }
);

const content = cva(
  [
    'absolute top-0 flex flex-col w-full h-screen p-4 transition-all duration-300',
  ],
  {
    variants: {
      active: {
        true: ['left-3/4'],
        false: ['left-0'],
      },
    },
    defaultVariants: {
      active: false,
    },
  }
);
