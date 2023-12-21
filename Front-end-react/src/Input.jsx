export default function Input(props) {
    const {label, register, name, ...inputProps} = props
    console.log(inputProps)
    return (
    <div>
    <label>{label}</label>
    <input type="text" {...register(name)}{...inputProps}/>
    </div>)
}