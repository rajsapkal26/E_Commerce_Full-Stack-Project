import React from 'react';
import AliceCarousel from 'react-alice-carousel';
import 'react-alice-carousel/lib/alice-carousel.css';
import { CarouselImagesPath } from './CarouselImagesPath';

const MainCarousel = () => {

const items = CarouselImagesPath.map((item)=>
    <img src={item.path} className='cursor-pointer' role='presentation' alt="" />
)

  return (
<>



    <AliceCarousel
        items={items}
        disableButtonsControls
        autoPlay
        autoPlayInterval={1500}
        infinite
        // disableDotsControls
        touchTracking={true}
        animationType="fadeout"

   />

</>
)
  };

export default MainCarousel;