import {CREATE_ORDER_FAILURE, CREATE_ORDER_REQUEST, CREATE_ORDER_SUCCESS} from './ActionType'

const initialState={
  orders:[],
  order:null,
  loading:false,
  error:null

}


export const orderReducer=(state=initialState, action)=>{

    switch(action.type){
      case CREATE_ORDER_REQUEST:
        return{...state, loading:true, error:null}

      case CREATE_ORDER_SUCCESS:
        return{...state, loading:false, error:null, products:action.payload}

      case CREATE_ORDER_FAILURE:
        return{...state, loading:false, error:action.payload}


      default:
        return state;
    }
}