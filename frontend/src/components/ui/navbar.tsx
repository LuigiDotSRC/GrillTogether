import Link from "next/link";
import { Button } from "@/components/ui/button";

export default function Navbar() {
  return (
    <div className="bg-[#EEE7E5] w-full h-14 drop-shadow-lg py-2 px-2 flex items-center">
      <div className="bg-slate-400 w-[3rem] h-[3rem] mx-12">
        logo
      </div>
      <nav className="flex space-x-8">
        <Link href="/" className="hover:underline font-bold">Home</Link>
        <Link href="/" className="hover:underline font-bold">How It Works</Link>
        <Link href="/" className="hover:underline font-bold">Community</Link>
        <Link href="/" className="hover:underline font-bold">FAQ</Link>
      </nav>
      <div className="ml-auto mr-12">
        <Button className="mx-2 font-bold drop-shadow">Log in</Button>
        <Button className="mx-2 font-bold bg-white text-black drop-shadow hover:bg-gray-300">Sign up</Button>
      </div>
    </div>
  );
}