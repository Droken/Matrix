Drop drops[] = new Drop[1000];

void setup()
{
  for(int i=0;i<drops.length;++i)
    drops[i] = new Drop();
  fullScreen();
  background(0);
}

void draw() {
  background(0);
  for(int i=0;i<drops.length;++i) {
    drops[i].fall();
    drops[i].show(); 
  }
}