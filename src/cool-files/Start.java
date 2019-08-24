import processing.core.*;

public class Start extends PApplet {
    public static void main(String[] args) {
        String[] appletArgs = new String[] { "Start" };
        PApplet.main(appletArgs);
    }

    public void settings() {
        fullScreen();
    }

    public void draw() {
        Screen srn = new Screen();
        srn.drawScreen();
        fill(random(255), random(255), random(255));
        ellipse(mouseX, mouseY, 50, 50);
    }

    public void keyReleased() {
        exit();
    }

    public class Screen {
        int border = 32;
        int colA = color(0);
        int colB = color(255);
        public Screen() {

        }
        public void drawScreen() {
            background(colA);
            int s = width/border;
            fill(colB);
            noStroke();
            rect(s, s, width - s * 2, height - s * 2);
        }
    }
}
