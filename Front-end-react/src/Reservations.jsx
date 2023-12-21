import './App.css';
import { useForm } from "react-hook-form";
import Input from "./Input";

export default function Reservations() {
    const {register, handleSubmit} = useForm() 
    
    const onSubmit = (data) => {
        console.log(data)
    }



  return (
    <section
      id="reservations-section"
      className="reservations-section"
    >
        <div className="reservations-info">
            <h2>Ahoy, hungry sailors!</h2>
            <ul>
                <li>Ready to anchor down at the best table in Bikini Bottom</li>
                <li>Reserve your spot now, or risk dining with the jellyfish!</li>
                <li>--</li>
            </ul>
        </div>
        <div className="form-container">
            <form >
            <br/>
                <br/>
                <br/>
                <label for="shift">Choose wisely, sea-foodie: Lunch with SpongeBob's jellyfish jam or dinner under the stars with Patrick? Either way, you're in for a whale of a time!:</label>
                <br/>
            <select {...register("shift")} >
                    <option value="lunch">Lunch</option>
                    <option value="dinner">Dinner</option>
                </select>
                
                <Input name="date" label="Choose Date:" type="date" register={register}/>
                <Input name="firstName" label="First Name:" register={register}/>
                <Input name="lastName" label="Last Name:" register={register}/>
                <Input name="email"label="Email:" register={register}/>
                <Input name="phone"label="Phone:" register={register} />
                <button
  style={{
    backgroundColor: '#FFD700',
    color: 'white',
    padding: '10px 20px',
    border: 'none',
    borderRadius: '5px',
    fontSize: '1em',
    cursor: 'pointer',
    transition: 'background-color 0.3s ease',
  }}
  onMouseOver={(e) => {
    e.target.style.backgroundColor = '#FFA500';
  }}
  onMouseOut={(e) => {
    e.target.style.backgroundColor = '#FFD700';
  }}
  type="submit"
>
Book</button>
                
            </form>
        </div>
    </section>
  );
}
