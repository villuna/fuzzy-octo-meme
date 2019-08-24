import processing.core.*;

public class Start extends PApplet {
    boolean cencored = false;
    boolean mouseDown = false;
    boolean mousePressed = false;
    boolean mouseReleased = false;
    boolean keyPressed = false;
    boolean keyReleased = false;

    String playerName = "";
    Event currentEvent;
    Boreee b;

    // Important function: don't delete or everything will break
    // I'm not sure why
    public static void bruh_momentum() {
        System.out.print("My name is Liam and I'm here to say ");
        Start.bruh_momentum();
    }

    public static void main(String[] args) {
        String[] appletArgs = new String[]{"Start"};
        PApplet.main(appletArgs);
    }

    public void settings() {
        fullScreen();
        b = new Boreee();
        currentEvent = b.new FadeIn();
    }

    public void draw() {
        currentEvent = currentEvent.foo();

        mousePressed = false;
        mouseReleased = false;
        keyPressed = false;
        keyReleased = false;
    }

    public void keyReleased() {
        keyReleased = true;
    }

    public void keyPressed() {
        keyPressed = true;
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
            int s = width / border;
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

        public class FadeIn extends Event {
            int bg = 0;
            boolean debug = true;


            public Event foo() {
                if (debug == true) {
                    // jump to point in story;

                    AlStory s = new AlStory();
                    return s.new First();
                }

                background(bg);

                bg++;

                if (bg >= 255) {
                    return new Birth();
                }
                else {
                    return this;
                }
            }
        }

        public class Birth extends Event {
            public Event foo() {
                background(100, 100, 125);
                textAlign(CENTER);
                textSize(40);
                text("You are born", width / 2, height / 2);

                if (mousePressed) {
//                   Boreee is = new Start();
                    return new AfterBorn();
                } else {
                    return this;
                }
            }
        }

        public class AfterBorn extends Event {
            int stillTimer = 0;

            public Event foo() {
                if (random(200) == 1) {
                    background(100, 100, 125);
                    textAlign(CENTER);
                    textSize(40);
                    text("Unfortunately, you were stillborn.", width/2, height/2);

                    if (stillTimer >= 150) {
                        textSize(20);
                        text("(Sorry about that.)", width/2, 3*height/4);
                    }

                    if (stillTimer >= 200) exit();

                    stillTimer++;
                }

                else {
                    return new NameChange();
                }

                return this;
            }
        }

        public class NameChange extends Event {
            String name = "";
            String alph = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ ";

            public Event foo() {
                background(0, 0, 125);
                textAlign(CENTER);
                textSize(40);
                text("What is your name?", width/2, height/2);

                if (keyPressed) {
                    if (key == BACKSPACE) {
                        if (name.length() > 0) {
                            name = name.substring(0, name.length()-1);
                        }
                    }

                    else if (alph.indexOf(""+key) != -1) name += key;

                    else if (key == ENTER) {
                        return new TheChristening();
                    }
                }

                text(name, width/2, 3*height/4);

                return this;
            }
        }

        public class TheChristening extends Event {
            String name = "";

            public TheChristening() {
                if (random(1) >= 0.5)
                    name = "Greggamendle";

                else
                    name = "Jaxon";

                playerName = name;
            }

            public Event foo() {
                background(0, 0, 125);
                textAlign(CENTER);
                textSize(40);
                text("Did you mean: " + name, width/2, height/2);
                textSize(20);
                text("Press ENTER to confirm", width/2, 3*height/4);

                if (keyPressed) {
                    if (key == ENTER) {
                        return new WaitYears();            
                    }
                }

                return this;
            }
        }

        public class WaitYears extends Event {
            public Event foo() {
                background(200, 60, 0);
                textAlign(CENTER);
                textSize(40);
                text("Wait 15 years?", width/2, height/10);

                text("Yes", width/4, height/2);
                text("No", 3*width/4, height/2);

                stroke(255);
                strokeWeight(5);
                line(width/2, height/5, width/2, 4*height/5);

                return this;
            }
        }

        // branch to is 


        // branch to boree


        // branch to al 


        // brnach to j0 


        // branch to j1
    }

    public class AlStory extends Bruh {

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
                    rain[x][2] = direction + random(-1 * variance, variance);
                }
            }

            private void rain_field() {
                for (int x = 0; x < 100; x++) {
                    if (rain[x][0] >= width || rain[x][1] >= height) {
                        rain[x][0] = random(width + 200) - 100;
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
                } else if (random(10) > 9.8) {
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

        public void draw_event(String textone, String texttwo, String textthree) {
            // background
            textSize(40);
            textAlign(CENTER);
            text(textone, width / 2, 50);
            textAlign(RIGHT);
            text(texttwo, width / 5, height/2);
            text(textthree, (width / 5)*3, height/2);
        }


        public class First extends Event {

            public Event foo() {
                clear();

                draw_event("You feel a tense baseline dissatisfaction with your success in life so far. You tell yourself it's not selfhatred but actually you feel undeserving of all you have but regretful that you don't have more. But life is good, or as good as you make it.",
                        "Take a sabattical in the mountains of South America",
                        "Enrol at UQ");
                text("YEET", 50, 50);

                if (mousePressed && (mouseX > width / 2)) {
                    return new Amer();
                }
                if (mousePressed && (mouseX <= width / 2)) {
                    return new CompSci();
                }

                return this;

            }
        }
    }
}

