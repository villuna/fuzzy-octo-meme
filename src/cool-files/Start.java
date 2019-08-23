import processing.core.*;

public class Start extends PApplet {
    public void settings() {
        size(640, 480);
    }

    public void draw() {
        background(0, 0, 128);
        ellipse(mouseX, mouseY, 50, 50);
    }

    public static void main(String[] args) {
        String[] appletArgs = new String[] { "Start" };
        PApplet.main(appletArgs);
    }
}
