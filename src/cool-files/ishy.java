import processing.core.*;

public class ishy extends PApplet {
  PFont f;

  public static void main(String[] args) {
    String[] appleArgs = new String[] { "ishy" };
    PApplet.main(appleArgs);
  }

  public void settings() {
    size(1620, 900);
  }

  public void setup() {
    f = createFont("Arial", 16, true);
  }
  public void draw() {
    background(255);
    textFont(f, 16);
    fill(0);
    text("Hello Strings!", 10, 100);
  }
}
