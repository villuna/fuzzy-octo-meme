import processing.core.*;

public class Start extends PApplet {
    boolean cencored = false;
    boolean mouseDown = false;
    boolean mousePressed = false;
    boolean mouseReleased = false;
    
    Event currentEvent;
    Boreee b;

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
        b = new Boreee();
        currentEvent = b.new Foo();
    }

    public void draw() {
        currentEvent = currentEvent.foo();
        
        mousePressed = false;
        mouseReleased = false;
    }

    public void keyReleased() {
        exit();
    }

    public void mousePressed() {
	mousePressed = true;
	mouseDown = true;
    }

    public void mouseReleased() {
	mouseReleased = true;
	mouseDown = false;
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

    public class Button {
	public int x, y, width, height;
	public Button(int x, int y, int width, int height) {
	    this.x = x;
	    this.y = y;
	    this.width = width;
	    this.height = height;
	}

	public boolean mouseOver() {
	    if ((mouseX < x + width) && (mouseY < y + height)) {
            if (mouseX > x && mouseY < y) {
                return true;
            }
	    }
	    return false;
	}

	public boolean clicked() {
	    return (mouseOver() && mouseReleased);
	}

    }

    public abstract class Event {
        // Blueprint type for the Events (things that happen lol)
        // foo() will execute the event and return the next event based on what happens
        public abstract Event foo();
    }

    public abstract class Bruh {
    }

    public class Ishy extends Bruh {
        // Ishy Storyline:
        public class Yeetus extends Event {
            public Event foo() {
                background(200, 100, 0);

                return this;
            }
        }
    }

    public class Boreee extends Bruh {
        // Borella story
        // Wooo
        
        public class Foo extends Event {
            int bg = 0;

            public Event foo() {
                background(bg);

                bg++;

                if (bg >= 255) bg = 0;

                if (mousePressed) 
                    return new Bar();

                else
                    return this;
            }
        }

        public class Bar extends Event {
            public Event foo() {
                background(0, 0, 125);

                if (mousePressed) {
                    Ishy is = new Ishy();

                    return is.new Yeetus();
                }

                else
                    return this;
            }
        }
    }
}

