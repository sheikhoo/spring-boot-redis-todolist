import Nanigator from '@/components/Nanigator';
import './globals.css';

export default function RootLayout({
  children,
}: {
  children: React.ReactNode;
}) {
  return (
    <html lang="en">
      <head />
      <body className="text-black bg-white dark:text-white dark:bg-gray-800 transition-colors duration-300">
        <Nanigator>{children}</Nanigator>
      </body>
    </html>
  );
}
