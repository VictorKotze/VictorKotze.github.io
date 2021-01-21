let currentPlayer="X" ;
let gameStatus="";
let numTurns=0;
 
//take player turn
function playerTakeTurn(e) {
 
    if (e.innerHTML == "") {
e.innerHTML = currentPlayer;
checkGameStatus();
} else {
    
    showLightBox("This box is already selected, please try another box.");
    
   return;
}//else
 
//game is over
if (gameStatus != ""){
    showLightBox(gameStatus, "Game Over.");
}
 
}//playerTakeTurn
 
 
//after each turns checks for a winner or tie
//or continue playing
function checkGameStatus (){
numTurns++;  //count turn
 
// check for win
if (checkWin()) {
    gameStatus = currentPlayer + " won";
    return;  // missing code
  } 
//check for tie
if (numTurns==9){
gameStatus="Tied Game";
}//numTurns
 
//switch current player
currentPlayer = (currentPlayer=="X"?"O":"X");
 
}//checkGameStatus
 
//check for a Win, there 8 win paths
function checkWin(){
    let cb=[];  //current board
    cb[0]=""//not going to use
cb[1] =document.getElementById("one").innerHTML;
cb[2] =document.getElementById("two").innerHTML;
cb[3] =document.getElementById("three").innerHTML;
cb[4] =document.getElementById("four").innerHTML;
cb[5] =document.getElementById("five").innerHTML;
cb[6] =document.getElementById("six").innerHTML;
cb[7] =document.getElementById("seven").innerHTML;
cb[8] =document.getElementById("eight").innerHTML;
cb[9] =document.getElementById("nine").innerHTML;
 
//top row
if(cb[1] !="" && cb[1] == cb[2] && cb[2] == cb[3]) {
    console.log("Win.")

return true; 
}

//middle row
if(cb[4] !="" && cb[4] == cb[5] && cb[5] == cb[6]) {
    console.log("Win.")
    return true;  
    }

    //bottom row
if(cb[7] !="" && cb[7] == cb[8] && cb[8] == cb[9]) {
    console.log("Win.")
    return true;  
    }

//left wall
if(cb[1] !="" && cb[1] == cb[4] && cb[4] == cb[7]) {
    console.log("Win.")
    return true;  
    }

    //middle wall
if(cb[2] !="" && cb[2] == cb[5] && cb[5] == cb[8]) {
    console.log("Win.")
    return true;  
    }

    //right wall
if(cb[3] !="" && cb[3] == cb[6] && cb[6] == cb[9]) {
    console.log("Win.")
    return true;  
    }

    //left slide
if(cb[1] !="" && cb[1] == cb[5] && cb[5] == cb[9]) {
    console.log("Win.")
    return true;  
    }

    //right slide
if(cb[3] !="" && cb[3] == cb[5] && cb[5] == cb[7]) {
    console.log("Win.")
    return true;  
    }

    
}//checkWin
 
 //change the visibility of divId
function changeVisibility (divId){
	let element= document.getElementById(divId);
	
	//if elem exists it is considere true
	if (element){
	element.className=(element.className =='hidden')? 'unhidden' : 'hidden';
	
}//if
}//change visibility 

//display message in lightbox
function showLightBox(message, message2){

//set messages
document.getElementById("message") .innerHTML =message;

//show lightbox
changeVisibility("lightbox");
changeVisibility("boundaryMessage");

}

//close light box
function continueGame (){
    changeVisibility("lightbox");
    changeVisibility("boundaryMessage");

    //if the game is over, show controls
}


