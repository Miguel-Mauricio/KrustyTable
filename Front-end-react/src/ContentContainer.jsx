export default function ContentContainer() {
    return (
        <div className="content-container">
        <div className="text-content" onclick="scrollDown()">
            <h2>Ahoy mateys!</h2>
            <p>Don't just float there...</p>
            <p>press the button belowfor a treasure</p>
            <p>trove of tastes at Krusty Table!</p>

            <button><a href="#about-section">Let's Take a Ride!</a></button>
        </div>
        <div className="image-content">
            <img src="https://e0.pxfuel.com/wallpapers/230/149/desktop-wallpaper-krusty-krab.jpg" alt="Interior"/>
        </div>
    </div>
    )
}