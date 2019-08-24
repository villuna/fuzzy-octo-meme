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

	Screen srn = new Screen();
        srn.drawScreen();

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

        public Screen(int bg, int fg) {
            int colA = color(bg);
            int colB = color(fg);

        }

        public void drawScreen() {
            background(colA);
            bg.draw();
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

    // shitty rain with lightning
    // use as background with
    //private RainField bg = new RainField(5, (float)0.2, 10);
    public class RainField {

        private float[][] rain = new float[100][3];
        private boolean light = false;
        private float vel = 0;
        private float variance = 0;


        public RainField(float direction, float vari, float velocity) {
            vel = velocity;
            variance = vari;

            rain_field_init(direction);
        }

        private void rain_field_init(float direction) {
            for (int x = 0; x < 100; x++) {
                rain[x][0] = random(0, width);
                rain[x][1] = random(0, height);
                rain[x][2] = direction + random(-1*variance, variance);
            }
        }

        private void rain_field() {
            for (int x = 0; x < 100; x++) {
                if (rain[x][0] >= width || rain[x][1] >= height) {
                    rain[x][0] = random(width + 200) -100;
                    continue;
                }

                float direction = rain[x][2];
                rain[x][0] = rain[x][0] + (vel * cos(direction)) + random(-20, 20);
                rain[x][1] = rain[x][1] + (-1 * vel * sin(direction)) + random(-20, 20);
                if (random(100) > 80) {
                    rain[x][2] += random(-1 * variance, variance);
                }
            }
        }

        public void draw() {
            rain_field();

            strokeWeight(4);
            stroke(0, 100, 200);
            background(0);
            if (light) {
                if (random(10) > 2) {
                    background(255);
                }
                if (random(10) > 8) {
                    background(0);
                    light = false;
                }
            } else
            if (random(10) > 9.8) {
                background(255);
                light = true;
            }

            for (int x = 0; x < 100; x++) {
                float direction = rain[x][2];
                float x2x = rain[x][0] + (vel * cos(direction));
                float y2x = rain[x][1] + (-1 * vel * sin(direction));
                line(rain[x][0], rain[x][1], x2x, y2x);
            }
        }
    }
}

