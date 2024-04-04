import { Button, Grid, Typography } from '@mui/material'
import React from 'react'

const Footer = () => {
  return (
    <div>

    <Grid className='bg-black text-white text-center mt-10'
    container
    sx={{bgcolor:'black', color:'white', py:3}} >


      <Grid item xs={12} sm={6} md={3}>

        <Typography className='pb-5' variant='h6' > Company </Typography>

        <div>
        <Button className='pb-5' variant='h6' gutterButton > About </Button>
        </div>
        <div>
        <Button className='pb-5' variant='h6' gutterButton > Blogs </Button>
        </div>
        <div>
        <Button className='pb-5' variant='h6' gutterButton > Jobs </Button>
        </div>
        <div>
        <Button className='pb-5' variant='h6' gutterButton > Partners </Button>
        </div>

      </Grid>

      <Grid item xs={12} sm={6} md={3}>

        <Typography className='pb-5' variant='h6' > Company </Typography>

        <div>
        <Button className='pb-5' variant='h6' gutterButton > About </Button>
        </div>
        <div>
        <Button className='pb-5' variant='h6' gutterButton > Blogs </Button>
        </div>
        <div>
        <Button className='pb-5' variant='h6' gutterButton > Jobs </Button>
        </div>
        <div>
        <Button className='pb-5' variant='h6' gutterButton > Partners </Button>
        </div>

      </Grid>

      <Grid item xs={12} sm={6} md={3}>

        <Typography className='pb-5' variant='h6' > Company </Typography>

        <div>
        <Button className='pb-5' variant='h6' gutterButton > About </Button>
        </div>
        <div>
        <Button className='pb-5' variant='h6' gutterButton > Blogs </Button>
        </div>
        <div>
        <Button className='pb-5' variant='h6' gutterButton > Jobs </Button>
        </div>
        <div>
        <Button className='pb-5' variant='h6' gutterButton > Partners </Button>
        </div>

      </Grid>

      <Grid item xs={12} sm={6} md={3}>

        <Typography className='pb-5' variant='h6' > Company </Typography>

        <div>
        <Button className='pb-5' variant='h6' gutterButton > About </Button>
        </div>
        <div>
        <Button className='pb-5' variant='h6' gutterButton > Blogs </Button>
        </div>
        <div>
        <Button className='pb-5' variant='h6' gutterButton > Jobs </Button>
        </div>
        <div>
        <Button className='pb-5' variant='h6' gutterButton > Partners </Button>
        </div>

      </Grid>

      

      <Grid className='pt-20' item xs={12}>

      <Typography variant='body2' component="p" align='center'> &copy; 2024 e_commerce. All Rights Reserved. </Typography>
      <Typography variant='body2' component="p" align='center'> Made with love by me. </Typography>


      </Grid>

      

    </Grid>

    </div>
  )
}

export default Footer