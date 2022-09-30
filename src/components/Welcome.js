import React from 'react'

const Welcome = (props) => {
    console.log(props)
    return (
        <div>
           <h1> Welcome to the Customer Management System </h1>
           {/* <h2> hi {props.}</h2> */}
        </div>
    )
}

// export const Greet = (props) => {
//     console.log(props)
//     return <h1>Hello there {props.name} loves {props.anime} </h1>
// }

export default Welcome
