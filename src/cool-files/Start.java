import processing.core.*;

public class Start extends PApplet {
    // Important function: don't delete or everything will break
    // I'm not sure why
    public static void bruh_momentum() {
        System.out.print("My name is Liam and I'm here to say ");
        Start.bruh_momentum();
    }

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

    public abstract class Bruh {
        
    }

    public abstract class Event {
        // Blueprint type for the Events (things that happen lol)
        // foo() will execute the event and return the next event based on what happens
        public abstract Event foo();
    }
}
