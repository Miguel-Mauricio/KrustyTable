import { useState } from 'react'
import './App.css'
import ContentContainer from './ContentContainer'
import NavBar from './navbar'
import Reservations from './Reservations'
import About from './About'
import TakeAway from './TakeAway'
import Neighborhodd from './Neighborhood'
import Contact from './Contact'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <NavBar/>
      <ContentContainer/>
      <About/>
      <Neighborhodd/>
      <Reservations/>
      <TakeAway/> 
      <Contact/>
    </>
  )
}

export default App
