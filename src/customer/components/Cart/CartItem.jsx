import { Button, IconButton } from '@mui/material'
import React from 'react'
import RemoveCircleOutlineIcon from '@mui/icons-material/RemoveCircleOutline';
import AddCircleOutlineIcon from '@mui/icons-material/AddCircleOutline';

const CartItem = () => {
  return (
    <div className='p-5 shadow-lg border rounded-md mt-4'>

      <div className='flex items-center'>

        <div className='w-[5rem] h-[5rem] lg:w-[9rem] lg:h-[9rem]'>
          <img className='w-full h-full object-cover object-top' src="https://rukminim1.flixcart.com/image/612/612/xif0q/kurta/g/6/k/m-sksh-dt1105-pcbl-fubar-original-imafux247zhqym2z-bb.jpeg?q=70" alt="" />
        </div>

        <div className='ml-5 space-y-1'>
            <p className='font-semibold'>title</p>
            <p className='opacity-70'>size: L</p>
            <p className='opacity-70 mt-2'>seller: brand name</p>

            <div className='flex space-x-5 items-center text-gray-900 pt-4'>
                <p className='font-semibold'>price</p>
                <p className='opacity-50 line-through'>real price</p>
                <p className='text-green-600 font-semibold'>percent off</p>
            </div>
        </div>

       

      </div>

      <div className='lg:flex items-center lg:space-x-10 pt-4'>

<div className='flex items-center space-x-2'>
  <IconButton >
    <RemoveCircleOutlineIcon/>
  </IconButton>
  <span className='py-1 px-7 border rounded-sm'>
    1
  </span>
  <IconButton sx={{color:"rgb(145 85 253)"}}>
    <AddCircleOutlineIcon/>
  </IconButton>
</div>

<div>
  <Button sx={{color:"rgb(145 85 253)"}}>
    Remove
  </Button>
</div>

</div>

    </div>
  )
}

export default CartItem