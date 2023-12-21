import { useForm } from "react-hook-form";
import Input from "./Input";

export default function Contact() {
  const { register, handleSubmit } = useForm();
  const onSubmit = (data) => {
    console.log(data);
  };

  return (
    <section id="contact-section" className="ccontact-section">
     <div className="form-container-parent" style={{ display: 'flex', justifyContent: 'center', alignItems: 'center', width: 1000}}>
  <div className="form-container">
    <form onSubmit={handleSubmit(onSubmit)}>
      <div className="pageTitle title">Drop Us a Bottle, Matey!</div>
      <Input name="firstName" label="First Name:" register={register} />
      <Input name="lastName" label="Last Name:" register={register} />
      <textarea
        className="message formEntry"
        placeholder="Spill yer secrets or sing a sea shanty (Leave a message)"
      ></textarea>
      {/* ... Other form elements ... */}
      <button
        className="submit"
        style={{
          width: '200px',
          color: 'white',
          backgroundColor: '#0e3721',
          fontSize: '20px',
          margin: '10px auto',  // Centering the button vertically with margin
          transition: 'width 0.3s ease, box-shadow 0.3s ease, border-top 0.3s ease, border-radius 0.3s ease, transform 0.3s ease',
        }}
        onMouseOver={(e) => {
          e.target.style.boxShadow = '15px 15px 15px 5px rgba(78, 72, 77, 0.219)';
          e.target.style.transform = 'translateY(-3px)';
          e.target.style.width = '300px';
          e.target.style.borderTop = '5px solid #0e3750';
          e.target.style.borderRadius = '0';
        }}
        onMouseOut={(e) => {
          e.target.style.boxShadow = 'none';
          e.target.style.transform = 'none';
          e.target.style.width = '200px';
          e.target.style.borderTop = 'none';
          e.target.style.borderRadius = 'none';
        }}
        type="submit"
      >
        Send to the Depths!"
      </button>
    </form>
  </div>
</div>

    </section>
  );
}
