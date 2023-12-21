import { useForm } from "react-hook-form";
import Input from "./Input";

export default function TakeAway() {
  const { register, handleSubmit } = useForm();

  const onSubmit = (data) => {
    console.log(data);
  };

  return (
    <section id="takeAway-section" className="takeAway-section">
      <div className="takeAway-info">
        <h2>Grab a Bite on the Go!</h2>
        <ul>
          <li>
            Welcome to the take-away zone, where speed meets taste in a
            whirlpool of flavors!{" "}
          </li>
          <li>
            Here at Krusty Table, we understand that your time is as precious as
            a pearl, but that shouldn't mean missing out on the culinary
            treasures of Bikini Bottom.
          </li>
          <li>--</li>
        </ul>
      </div>
      <div className="takeAway-form-container">
        <form onSubmit={handleSubmit(onSubmit)}>
        <br/>
                <br/>
                <br/>
                <label for="food-choice">Choose wisely:</label>
                <select id="food-choice" name="food-choice" >
                    <option value="triple-krusty-cheese">Triple Krusty Cheese</option>
                    <option value="double-krusty-cheese">Double Krusty Cheese</option>
                    <option value="single-krusty-cheese">Single Krusty Cheese</option>
                    <option value="krusty-bacon">Krusty Bacon</option>
                    <option value="krusty-royal">Krusty Royal</option>

                </select>

        
          <Input name="firstName" label="First Name:" register={register} />
          <Input name="lastName" label="Last Name:" register={register} />
          <Input name="email" label="Email:" register={register} />
          <Input name="phone" label="Phone:" register={register} />
          <button
  className="btn-reservations"
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
  Book
</button>

        </form>
      </div>
    </section>
  );
}
