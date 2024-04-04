import React from 'react'
import MainCarousel from '../../components/HomeCarousel/MainCarousel'
import CardCarousel from '../../components/HomeSectionCardCarousel/CardCarousel'
import { mens_kurta } from '../../../data/mens_kurta'

const HomePage = () => {
  return (

    <>
    <div>
      <MainCarousel/>

    </div>

    <div className='space-y-10 py-20 flex flex-col px-5 lg:px-10'> 
      <CardCarousel data={mens_kurta} Section_name={"Men's_Kurta"}/>
    </div>

    </>
  )
}

export default HomePage