import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {
	PImage imgbackground;
  PImage imgmaincharacter;

  float imgmaincharacterX = 500;
  float imgmaincharacterY = 500;
  float speedX = 5;

  float circleX = 0;
  float circleY = 600;
  float circleSpeed = 5;
  float parabola;
	

  public void settings() {
	// put your size call here
    size(1000, 600);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    imgbackground = loadImage("Background.jpg");
    imgmaincharacter  = loadImage("character.png");
    imgmaincharacter.resize(imgmaincharacter.width/20,imgmaincharacter.height/20);


  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
	  image(imgbackground, 0, 0);

    image(imgmaincharacter, imgmaincharacterX, imgmaincharacterY);

      imgmaincharacterX += speedX;
    
    if(imgmaincharacterX > width-100){
      speedX *= -1;
      System.out.println("Speed: " + speedX);
      System.out.println(imgmaincharacterX);
    }

    if(imgmaincharacterX < 0){
      speedX *= -1;
    }

    ellipse(circleX, circleY, 50, 50);
    
    parabola = (float) Math.pow(circleX - 500, 2);
    //System.out.println(parabola);
    circleY = parabola/250;


    circleX += circleSpeed;

    if(circleX > 0 && circleX < width){
      circleSpeed *= 1;
    }

     if(circleX > 950){
      circleSpeed *= -1;
   }
    //System.out.println(circleX);
    //System.out.println(circleY);

    if(circleX < 0){
      circleSpeed *= -1;
    }


  }
  
  // define other methods down here.
}