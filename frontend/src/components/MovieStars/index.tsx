import {ReactComponent as StarFull} from "assets/img/vectstar-full.svg";
import {ReactComponent as StarHalf} from "assets/img/vectstar-half.svg";
import {ReactComponent as StarEmpty} from "assets/img/vectstar-empty.svg";
import './styles.css';

function MovieStars(){
    return(
        <div className="dsmovie-stars-container">
            <StarFull/>
            <StarFull/>
            <StarFull/>
            <StarHalf/>
            <StarEmpty/>
        </div>
    );
}

export default MovieStars;