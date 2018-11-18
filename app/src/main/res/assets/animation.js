let human = document.querySelector(".human");
let head = document.querySelector(".head");
let ring = document.querySelector(".ring");
let box1 = document.querySelector(".box1");
let box2 = document.querySelector(".box2");
let box3 = document.querySelector(".box3");

// alert("connected");
human.addEventListener("click", function() {
    human.classList.add("scaled");
});

let clickedHead = 0;
head.addEventListener("click", function(){
    if(clickedHead == 0){
        ring.classList.add("appear");
    } else if(clickedHead == 1){
        box1.classList.add("appear");
    } else if(clickedHead == 2){
        box2.classList.add("appear");
    } else if(clickedHead == 3){
        box2.classList.remove("appear");
        box2.classList.add("disappear");
        box1.classList.add("darker");
    } else if(clickedHead == 4){
        box1.classList.remove("appear");
        box1.classList.add("disappear");
    } else if(clickedHead == 5){
        box3.classList.add("appear");
    }
    clickedHead++;
});