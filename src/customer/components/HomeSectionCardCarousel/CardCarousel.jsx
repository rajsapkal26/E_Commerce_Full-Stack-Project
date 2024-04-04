import React, { useState } from "react";
import HomeSectionCard from "../HomeSectionCard/HomeSectionCard";
import AliceCarousel from "react-alice-carousel";
import "react-alice-carousel/lib/alice-carousel.css";
import ArrowLeftIcon from "@mui/icons-material/ArrowLeft";
import { Button } from "@mui/material";

const CardCarousel = ({data, Section_name}) => {
  const [activeIndex, setActiveIndex] = useState(0);

  const responsive = {
    0: { items: 1 },
    768: { items: 3 },
    1024: { items: 4 },
  };

  const slidePrev=()=>setActiveIndex(activeIndex-1);
  const slideNext=()=>setActiveIndex(activeIndex+1)

  const syncActiveIndex = ({item}) => setActiveIndex(item)
//  const syncActiveIndex = (item) => setActiveIndex(item);

  
  const items = data.slice(0,10).map((item) => <HomeSectionCard product={item} />);

  return (
    <div className="border">
      <h2 className="text-2xl font-extrabold text-gray-800 py-5 ">{Section_name}</h2>
      <div className="relative p-5">
        <AliceCarousel
          items={items}
          disableButtonsControls
          responsive={responsive}
          disableDotsControls
          onSlideChanged={syncActiveIndex}
          activeIndex={activeIndex}
        />


         {activeIndex !== items.length-4 &&  
          <Button
            className="z-50 bg-white"
            variant="contained"
            onClick={slideNext}
            sx={{
              position: "absolute",
              top: "8rem",
              right: "0rem",
              transform: "translateX(50%) rotate(90deg)",
              bgcolor: "white",
            }}
            aria-label="next"
          >
            <ArrowLeftIcon
              sx={{ transform: "rotate(90deg)", color: "black" }}
            />
          </Button>
          } 

         {activeIndex !== 0 &&  
         <Button
          onClick={slidePrev}
          className="z-50 bg-white"
          variant="contained"
          sx={{
            position: "absolute",
            top: "8rem",
            left: "0rem",
            transform: "translateX(-50%) rotate(90deg)",
            bgcolor: "white",
          }}
          aria-label="next"
          >
          <ArrowLeftIcon sx={{ transform: "rotate(-90deg)", color: "black" }} />
        </Button>
        }
      </div>
    </div>
  );
};

export default CardCarousel;
