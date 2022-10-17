character ro = new character(new PVector(0,0));// all the paddles
  character ro2 = new character(new PVector(550,0));
  character ro3 = new character(new PVector(100,0));
  character ro4 = new character(new PVector(200,0));
  character ro5 = new character(new PVector(300,0));
  character ro6 = new character(new PVector(400,0));
  character ro7 = new character(new PVector(500,0));
  int pr =1;
  int i =0;
 ArrayList<bullets>  h = new ArrayList<bullets>();
 bullets v = new bullets(ro);
void setup(){
  size(600,600);
  
}
int fir =0;


  
  
void draw(){
 


 noStroke();
 
ad();

 if(ro.loc.y >= 600  || ro.loc.y <0 ){//Puts a boundary on the paddles
   pr*=-1;
  ro.update(pr*random(10));
  ro2.update(pr*random(10));
   ro3.update(pr*random(10));
   ro4.update(pr*random(10));
    ro5.update(pr*random(10));
      ro6.update(pr*random(10));
 }else{
   
   ro.update(pr*random(10));
    ro2.update(pr*random(10));
    ro3.update(pr*random(10));
    ro4.update(pr*random(10));
    ro5.update(pr*random(10));
     ro6.update(pr*random(10));
 }

   h.add(new bullets (new character(new PVector(ro.loc.x,ro.loc.y))));// spawns balls
    
   h.get(i).proje();//addes an accelerator and velocity and puts a limit on the velocity allowing the balls to mimic a bouncing state
   
 for(int k = 0; k< h.size();k++){
  noStroke();
   h.get(k).vel.x+=h.get(k).accel.x; //increases the acceleration allowing the balls to bounce
    h.get(k).loc.x += h.get(k).vel.x;// adds velocity
    
    if(h.get(k).loc.x>600){// allows the balls to reflect 
      h.get(k).vel.x*=-1;
    }
  
    fill(255,0,0);
     ellipse(h.get(k).loc.x + 45,h.get(k).loc.y+45,20,20);
 }
 
 
 i++;//increases the i
 
 }
   
  void ad(){
     background(0);
     fill(250,250,250);
 rect(ro.loc.x, ro.loc.y, 20 ,90);
 rect(ro2.loc.x,ro2.loc.y,20,90);
  rect(ro3.loc.x,ro3.loc.y,20,90);
  rect(ro4.loc.x,ro4.loc.y,20,90);
  rect(ro5.loc.x,ro5.loc.y,20,90);
    rect(ro6.loc.x,ro6.loc.y,20,90);
  }
  
 

int j =1;
class bullets{//Balls
  PVector loc;
  PVector vel;
  PVector accel;

  bullets(character c){
    loc = new PVector(c.loc.x,c.loc.y);
    vel = new PVector(2,.5);
    accel = new PVector(0,0);
  
  }

  void proje(){
  
PVector d = new PVector(random(5), random(5));
 accel = PVector.add(loc,d);
 accel.mult(2);
  vel.add(accel);
    loc.add(vel);
     vel.limit(10); 
    

 
   
  }
  
  

}
class character{//  paddles
  PVector loc = new PVector(0,0);
 character(PVector loc){
   this.loc.x = loc.x;
   this.loc.y = loc.y;
 }

 
 void update(float amount){
   this.loc.y += amount;
 }

 
  
}
