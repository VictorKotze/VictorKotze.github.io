const levels= [ 
    //level 0
    ["flag", "rock", "", "", "", 
"fenceside", "rock", "", "", "rider", 
"", "tree", "animate", "animate", "animate",
"", "water", "", "", "",
"", "fence", "", "horseup", ""],

//level 1

["flag", "water", "", "", "", 
"fenceside", "waterk", "", "", "rider", 
"animate", "bridge animate", "animate", "animate", "animate",
"", "water", "", "", "",
"", "water", "", "horseup", "" ],

//level 2

["tree", "tree", "flag", "tree", "tree", 
"animate", "animate", "animate", "animate", "animate", 
"water", "bridge", "water", "ater", "water",
"", "", "", "fence", "",
"rider", "rock", "", "", "horseup"],

];//end of levels

const gridBoxes = document.querySelectorAll("#gameBoard div");
var currentLevel = 0;  //starting level
var riderOn = false; //is the rider on
var currentLocationOfHorse= 0; 
var currentAnimation; // allows 1 animation per level


//start game
window.addEventListener("load", function () {
    loadLevel();
});



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

//animate enemy left and right (add up or down)
//boxes-array of grid boxes that inclue animation
//index- current location of animation
//direction- current direction of the animation

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

