import React from 'react'
import AddressCard from '../AddressCard/AddressCard'
import CartItem from '../Cart/CartItem'
import { Button } from '@mui/material'

const OrderSummary = () => {
  return (
    <div>
      <div className='p-5 shadow-lg rounded-s-md border'>

      <AddressCard/>

      </div>

      <div>
      <div className="lg:grid grid-cols-3 relative">
        <div className="col-span-2">
          {[1,1,1,1,1].map((item)=><CartItem />)}
        
        </div>

        <div className="px-5 sticky top-0 h-[100vh]  lg:mt-4">
          <div className="border p-4">

            <p className="uppercase font-bold opacity-60 pb-4">price details</p>
            <hr />
            <div className="space-y-3 font-semibold mb-10">

              <div className="flex justify-between pt-3 text-black">
                <span>Price</span>
                <span>$5363</span>
              </div>

              <div className="flex justify-between pt-3 ">
                <span>Discount</span>
                <span className="text-green-600">$5363</span>
              </div>
              
              <div className="flex justify-between pt-3 ">
                <span>Delivery Charge</span>
                <span className="text-green-600">Free</span>
              </div>

              <div className="flex justify-between pt-3  font-bold">
                <span>Total Amount</span>
                <span className="text-green-600">$5363</span>
              </div>

            </div>

            <Button variant="contained" className="w-full" sx={{px:"2.5rem", py:".7rem", bgcolor:"#9155fd"}}>
              Checkout
            </Button>

          </div>
        </div>
      </div>
    </div>
    </div>
  )
}

export default OrderSummary