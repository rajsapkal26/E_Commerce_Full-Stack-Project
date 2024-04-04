import React from 'react'
import Navigation from '../customer/components/navigation/Navigation';
import { Route, Routes } from 'react-router-dom';
import HomePage from '../customer/pages/HomePage/HomePage';
import Cart from '../customer/components/Cart/Cart';
import Footer from '../customer/components/Footer/Footer';
import Product from '../customer/components/Products/Product';
import ProductDetails from '../customer/components/ProductDetails/ProductDetails';
import Checkout from '../customer/components/CheckoutPage/Checkout';
import Order from '../customer/components/Order/Order';
import OrderDetails from '../customer/components/Order/OrderDetails';


const CustomerRoutes = () => {
  return (
    <div>
      <div>
        <Navigation/>
      </div>

      <Routes>
      <Route path='/login' element={<HomePage/>} />
      <Route path='/register' element={<HomePage/>} />

        <Route path='/' element={<HomePage/>} />
        <Route path='/cart' element={<Cart/>} />
        <Route path='/:lavelOne/:lavelTwo/:levelThre' element={<Product/>} />
        <Route path='/product/:productId' element={<ProductDetails/>} />
        <Route path='/account/order/:orderId' element={<OrderDetails/>} /> 
        <Route path='/checkout' element={<Checkout/>}/>
        <Route path='/account/order' element={<Order/>}/>
  

      </Routes>

      <div>
        <Footer/>
      </div>
    </div>
  )
}

export default CustomerRoutes