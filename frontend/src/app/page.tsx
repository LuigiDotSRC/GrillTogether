import { Button } from '@/components/ui/button'

export default function Home() {
  return (
    <div className="flex flex-row">
      <div className="flex-[0_0_30%]">
        <div className="relative my-2">
          <h1 className="text-[4rem] font-bold text-transparent bg-gradient-to-r from-[#EE0979] to-[#FF6A00] bg-clip-text">
            GrillTogether
          </h1>
        </div>
        <p className="text-2xl font-bold my-2">
          Turn cooking into a social experience. Meet, cook, and share meals with new friends!
        </p>
        <Button className="font-bold bg-gradient-to-r from-[#EE0979] to-[#FF6A00] hover:scale-105 transition-transform duration-[2000ms]">
          Join Now
        </Button>

      </div>
      <div className="flex-[0_0_70%]">
        <p>test</p>
      </div>
    </div>
  );
}

