class Drop {
  float x=random(width);
  float y=random(-500,-50);
  float z=random(0,20);
  float yspeed=map(z,0,20,10,20);
  float len = map(z,0,20,10,20);
  char letter = "01234567890@#!%^*;:/<>".charAt((char)random(0,21));
  
  void fall()
  {
    float grav =map(z,0,20,0,0.2);
    y+=yspeed;
    yspeed+=grav;
    if(y>height){
      y=random(-200,-100);
      yspeed=map(z,0,20,4,10);
    }
  }
  
  void show() {
    float thick = map(z,0,20,10,15);
    fill(100,255,100);
    //line(x,y,x,y+len);
    textSize(thick);
    text(letter,x,y);
  }
}