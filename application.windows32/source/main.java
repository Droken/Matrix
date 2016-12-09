import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class main extends PApplet {

Drop drops[] = new Drop[1000];

public void setup()
{
  for(int i=0;i<drops.length;++i)
    drops[i] = new Drop();
  
  background(0);
}

public void draw() {
  background(0);
  for(int i=0;i<drops.length;++i) {
    drops[i].fall();
    drops[i].show(); 
  }
}
class Drop {
  float x=random(width);
  float y=random(-500,-50);
  float z=random(0,20);
  float yspeed=map(z,0,20,10,20);
  float len = map(z,0,20,10,20);
  char letter = "01234567890@#!%^*;:/<>".charAt((char)random(0,21));
  
  public void fall()
  {
    float grav =map(z,0,20,0,0.2f);
    y+=yspeed;
    yspeed+=grav;
    if(y>height){
      y=random(-200,-100);
      yspeed=map(z,0,20,4,10);
    }
  }
  
  public void show() {
    float thick = map(z,0,20,10,15);
    fill(100,255,100);
    //line(x,y,x,y+len);
    textSize(thick);
    text(letter,x,y);
  }
}
  public void settings() {  fullScreen(); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--stop-color=#155203", "main" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
