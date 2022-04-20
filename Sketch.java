import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {
  // Stating and giving values to variables
	PImage imgbackground;
  PImage imgmaincharacter;
  PImage imgpinkamong;

  float imgmaincharacterX = 500;
  float imgmaincharacterY = 450;
  float speedX = 5;

  float circleX = 0;
  float circleY = 600;
  float circleSpeed = 5;
  float parabola;

  float pinkamongX = 0;
  float pinkamongY = 600;
  float pinkamongSpeed = 5;
  float parabola2;

  public void settings() {
	// Size of screen
    size(1000, 600);
  }

  public void setup() {
    // Loading in images and resizing
    imgbackground = loadImage("Background.jpg");
    imgmaincharacter  = loadImage("character.png");
    imgpinkamong = loadImage("Pink.png");

    imgmaincharacter.resize(imgmaincharacter.width/15,imgmaincharacter.height/15);
    imgpinkamong.resize(imgpinkamong.width/10, imgpinkamong.height/10);


  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
    // Drawing the background at (0,0)
	  image(imgbackground, 0, 0);
    
    // Drawing the main red among us character
    image(imgmaincharacter, imgmaincharacterX, imgmaincharacterY);

    // Red among us' character movement and edge detection
    imgmaincharacterX += speedX;
    
    if(imgmaincharacterX > width-120){
      speedX *= -1;
      System.out.println("Speed: " + speedX);
      System.out.println(imgmaincharacterX);
    }

    if(imgmaincharacterX < -20){
      speedX *= -1;
    }

    // Drawing the Circle
    ellipse(circleX, circleY, 50, 50);
    
    // Animating the white circle's parabolic path
    parabola = (float) Math.pow(circleX - 500, 2);

    circleY = parabola/250;
    circleX += circleSpeed;

    if(circleX > 0 && circleX < width){
      circleSpeed *= 1;
    }
    if(circleX > 900){
      circleSpeed *= -1;
   }
    if(circleX < 0){
      circleSpeed *= -1;
    }

    // Drawing the pink among us character
    image(imgpinkamong, pinkamongX, pinkamongY);

    // Animating the pink among us character to follow with the white circle's parabolic path
    parabola2 = (float) Math.pow(pinkamongX - 500, 2);
    
    pinkamongY = parabola2/250;
    pinkamongX += pinkamongSpeed;

    if(pinkamongX > 0 && pinkamongX < width){
      pinkamongSpeed *= 1;
    }
    if(pinkamongX > 900){
      pinkamongSpeed *= -1;
    }
    if(pinkamongX < 0){
      pinkamongSpeed *= -1;
    }
  }
  
  // define other methods down here.
}