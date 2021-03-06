const levels= [ 
    //level 0
    ["flag", "rock", "", "", "", 
"fenceside", "rock", "", "", "rider", 
"", "tree", "animate", "animate", "animate",
"", "water", "", "", "",
"", "fence", "", "horseup", ""],
 
//level 1
 
["flag", "water", "", "", "", 
"fenceside", "water", "", "", "rider", 
"animate", "bridge animate", "animate", "animate", "animate",
"", "water", "", "", "",
"", "water", "", "horseup", "" ],
 
//level 2
 
["tree", "tree", "flag", "tree", "tree", 
"animate", "animate", "animate", "animate", "animate", 
"water", "bridge", "water", "water", "water",
"", "", "", "fence", "",
"rider", "rock", "", "", "horseup"],

//level 4
 
["tree", "tree", "flag", "", "", 
"animate", "animate", "animate", "animate", "animate", 
"", "", "", "", "",
"rider", "", "tree", "rock", "tree",
"", "", "horseup", "tree", "tree"],

//Game end (level 4)
["rock", "", "", "", "rock", 
"", "", "", "tree", "", 
"", "tree", "statue", "tree", "",
"", "", "", "", "",
"", "", "horseup", "rider", ""]


 
];//end of levels
 
const gridBoxes = document.querySelectorAll("#gameBoard div");
const noPassObstacles = ["rock", "tree", "water", "statue" ];
var currentLevel = 0;  //starting level
var riderOn = false; //is the rider on
var currentLocationOfHorse= 0; 
var currentAnimation; // allows 1 animation per level
var widthOfBoard=5;
var startGame="";

 
 
//start game
window.addEventListener("load", function () { 
    loadLevel();
});
 
//move horse
window.addEventListener("keydown", function (e) { 

    switch(e.keyCode) {
        case 37: //left arrow
        if (currentLocationOfHorse % widthOfBoard !== 0) {
            tryToMove("left");
        }
        break;
        case 38: //up arrow
        if (currentLocationOfHorse - widthOfBoard >=0) {
            tryToMove("up");
        }
        break;
        case 39: //right arrow
        if (currentLocationOfHorse % widthOfBoard < widthOfBoard-1) {
            tryToMove("right");
        }
        break;
        case 40: //down arrow
        if (currentLocationOfHorse + widthOfBoard < widthOfBoard * widthOfBoard) {
            tryToMove("down");
        }
        break;
} //switch
}); //key event listener

//try to move horse
function tryToMove(direction) {

    //location before move
    let oldLocation= currentLocationOfHorse;

    //class of location before move
    let oldClassName = gridBoxes[oldLocation].className;

    let nextLocation=0;  //location we wish to move to
    let nextClass="";  //class of location we wish to move to

    let nextLocation2=0;
    let nextClass2="";

    let newClass=""; //new class to switch to if move succesful

    switch (direction) {
        case "left": 
        nextLocation = currentLocationOfHorse-1;
        break;
        case "right": 
        nextLocation = currentLocationOfHorse+1;
        break;
        case "up": 
        nextLocation = currentLocationOfHorse- widthOfBoard;
        break;
        case "down": 
        nextLocation = currentLocationOfHorse+ widthOfBoard;
        break;
    }//switch

    nextClass = gridBoxes[nextLocation].className;

    //if the obstacle is not passable, don't move
    if (noPassObstacles.includes(nextClass)) {return;}

    //if it's a fence, and there is no rider, don't move
    if (!riderOn && nextClass.includes("fence")) {return;}

    //if there is a fence, move two spaces with animation
    if (nextClass.includes("fence")) {

        //rider must be on to jump
        if (riderOn) {
            gridBoxes[currentLocationOfHorse].className="";
            oldClassName = gridBoxes[nextLocation].className;

            //set values according to direction
            if (direction == "left") {
                nextClass="jumpleft";
                nextClass2="horserideleft";
                nextLocation2=nextLocation-1;
            } else if (direction == "right"){
                nextClass="jumpright";
                nextClass2="horserideright";
                nextLocation2=nextLocation+1;
            } else if (direction == "up"){
                nextClass="jumpup";
                nextClass2="horseriderup";
                nextLocation2=nextLocation - widthOfBoard;
            }  else if (direction == "down"){
                nextClass="jumpdown";
                nextClass2="horseriderdown";
                nextLocation2=nextLocation + widthOfBoard;
            }
            //show horse jumping
            gridBoxes[nextLocation].className=nextClass;

            setTimeout(function() {

                //set jump back to just a fence
                gridBoxes[nextLocation].className = oldClassName;

                //update current location of horse to be 2 spaces past take off
                currentLocationOfHorse=nextLocation2;

                //get class of box after jump
                nextClass= gridBoxes[currentLocationOfHorse].className;

                //show horse and rider after landing
                gridBoxes[currentLocationOfHorse].className=nextClass2;

                //if next box is a flag
                levelUp(nextClass);
            },350);
            return;
      
        }//if riderOn
    }//if class has a fence


    //if there is a rider, add rider
    if (nextClass == "rider") {
        riderOn=true;
    }

    //if there is a bridge in the old location keep it
    if (oldClassName.includes("bridge")) {
        gridBoxes[oldLocation].className="bridge";
    } else{
        gridBoxes[oldLocation].className="";
    }

    //build name of new class
    newClass= (riderOn) ?"horseride" : "horse";
    newClass += direction;

    //if there is a bridge in the next location keep it
    if (gridBoxes[nextLocation].classList.contains("bridge")) {
        newClass += "bridge";
    }

    //move 1 space
    currentLocationOfHorse = nextLocation;
    gridBoxes[currentLocationOfHorse].className = newClass;

    //if it is an enemy
    if (nextClass.includes("enemy")) {
        document.getElementById("lose").style.display ="block";
        
        return;
    }

    function restartGame() {
        currentlevel=0;

    }

    //move up to the next level if needed
    levelUp(nextClass);

}//tryToMove

//move up a level
function levelUp(nextClass){
    if(nextClass == "flag" && riderOn){
        document.getElementById("levelup").style.display="block";
        clearTimeout(currentAnimation);
        setTimeout (function() {
            document.getElementById("levelup").style.display="none";
            currentLevel++;
            loadLevel();

        },1000);
    }
}//levelUp


 
//load level 0- maxlevel
function loadLevel(){
    let levelMap= levels [currentLevel];
    let animateBoxes;
    riderOn=false;
 
    //load board
    for(i=0; i < gridBoxes.length; i++) {
        gridBoxes[i].className= levelMap[i];
        if (levelMap[i].includes("horse")) currentLocationOfHorse =i; 
 
 
    }//for
 
    animateBoxes= document.querySelectorAll(".animate");
   /* console.log(" animateboxes is " +  animateboxes.length);
    console.log ( animateboxes);*/
    animateEnemy(animateBoxes, 0, "right");
 
}//loadlevel
 

 
function animateEnemy(boxes, index, direction ) {
   /* console.log("boxes is " + boxes.length);
    console.log (boxes); */
    if(boxes.length <=0) {return;}
//update images
 
if (direction == "right"){
    boxes[index].classList.add("enemyright");
}else{
    boxes[index].classList.add("enemyleft");
    }
 
    //remove images from other boxes
    for (i=0; i< boxes.length; i++){
        if(i !=index){
            boxes[i].classList.remove("enemyright");
            boxes[i].classList.remove("enemyleft");
        }
    }//for
 
    //moving right
    if (direction =="right") {
 
        //turn around if hit right side
        if (index == boxes.length-1) {
            index--;
            direction="left";
        } else{
            index++;
        }
 
        //moving left
    }else{
        //turn around if hit left side
        if (index == 0) {
            index++;
            direction="right";
        } else {
            index--;
        }
    }//else
 
 
    currentAnimation = setTimeout(function() {
        animateEnemy(boxes, index, direction);
 
    }, 750);
}//animateEnemy

