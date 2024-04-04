import React from 'react'

const AddressCard = () => {
  return (
    <div>
      <div className='space-y-3'>
        <p className='font-semibold'>firstname lastname</p>
        <p>address city state zipcode</p>
        <div className='space-y-1'>
          <p className='font-semibold'>phone number</p>
          <p>9989878765</p>
        </div>
      </div>
    </div>
  )
}

export default AddressCard