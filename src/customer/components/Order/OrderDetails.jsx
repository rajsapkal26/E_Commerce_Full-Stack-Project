import React from 'react'
import AddressCard from '../AddressCard/AddressCard'
import OrderTracker from './OrderTracker'
import { Box, Grid } from '@mui/material'
import { deepPurple } from '@mui/material/colors'
import StarBorderIcon from '@mui/icons-material/StarBorder';

const OrderDetails = () => {
  return (
    <div className='lg:px-20 px-5'>
      <div>
        <h1 className='font-bold text-xl py-7'>Delivery Address</h1>
      <AddressCard/>
      </div>

      <div className='py-20'>
        <OrderTracker activeStep={3}/>
      </div>

      <Grid container className='space-y-5'>

        {[1,1,1,1,1].map((item)=><Grid item container className='shadow-xl px-3 rounded-md border' sx={{alignItems:"center", justifyContent:"space-between"}}>

<Grid item xs={6}>
 <div className='flex items-center space-x-4'>
   <img className='w-[6rem] h-[8rem] object-cover object-top' src="https://rukminim1.flixcart.com/image/612/612/xif0q/kurta/m/e/e/s-kurta-rahul-look-original-imaga2g6qmhbywdf-bb.jpeg?q=70" alt="" />

  <div className='space-y-2 ml-5'>
    <p className='font-semibold '>title</p>
    <p className='space-x-5 opacity-50 text-xs font-semibold'><span>color: black</span>  <span>size: M</span></p>
    <p>seller : lorem</p>
    <p>$987</p>
  </div>
 </div>
</Grid>

<Grid item >
  <Box sx={{color:deepPurple[500]}}>
      <StarBorderIcon sx={{fontSize:"2rem"}} className='px-2' />
        <span>Rate & Review Product</span>

        

  </Box>
</Grid>

</Grid>)}

        

      </Grid>

    </div>
  )
}

export default OrderDetails