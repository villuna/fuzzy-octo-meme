import processing.core.*;
import processing.sound.*;

public class Start extends PApplet {
    boolean censored = true;
    boolean mouseDown = false;
    boolean mousePressed = false;
    boolean mouseReleased = false;
    boolean keyPressed = false;
    boolean keyReleased = false;

    SoundFile startupSound;
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
        startupSound = new SoundFile(this, "wexp.mp3");

    }

    public void draw_question(String question, int r, int g, int b) {
      background(r,g,b);
      PFont f;
      f = createFont("Arial", 30, true);
      textFont(f, 30);

      // QUESTION TEXTBOX Setup

      textAlign(CENTER);
      textFont(f, 60);
      fill(0);
      text(question, 1920/5, 100, 3*(1920/5), 500);
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
                if (mouseX > x && mouseY > y) {
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
	//  Refer to /story.
        public class Yeetus extends Event {
	  boolean clicked_left = false;
	  boolean clicked_right = false;
	  public Event foo() {
	    Button left = new Button(0,0, width/2, height);
	    Button right = new Button(width/2,0, width/2, height);
	    fill(255);

	    draw_question("You meet a new friend. It is lunch time now, what do you want to talk about?\n Left: Do you want to establish World Communism with me?\n Right: Do you not want to establish World Communism with me?", 255, 255, 0);
	    println(left.clicked());
	    if (left.clicked()) {
	      clicked_left = true;
	    } else if (clicked_right) {
	      clicked_right = true;
	    }


	    if (clicked_left) {
	      // Establishing World Communism
	      background(255,255,0);
	      String response = playerName + "... You are 5 years old... Whatever.";
	      textAlign(CENTER);
	      text(response, width/2, height/2);

	      return new Communism();

	    } else if (clicked_right) {
	      // Not establishing World Communism.
	      background(255, 255,0);
	      textAlign(CENTER);
	      text("Ok.", width/2, height/2);

	      return this;
	    }

	    return this;
	  }
	}

      public class Communism extends Event {
	public Event foo() {
	    Button left = new Button(0,0, width/2, height);
	    Button right = new Button(width/2,0, width/2, height);
	    PFont f;
	    f = createFont("Arial", 16, true);
	    fill(255);

	    draw_question("Your friend aggres with your plan. He shakes you hand and utters his full name. \n Joseph Stalin. \n Obviously as a 5 year old this means nothing to you. Click on the: \n Left - Continue hanging out with Joseph \n Right - Make new friends", 255, 0 ,255);


	    return this;

	}
      }
  }
	  /*
	  boolean clicked = false;
            public Event foo() {
                background(0);
		PFont f;
		f = createFont("Arial", 16, true);
		textFont(f, 16);

		// QUESTION TEXTBOX Setup

		textAlign(CENTER);
		textFont(f, 30);
		fill(255);
		text("You meet a new friend named Jaxon. It is lunch time now, what do you want to talk about?", 1920/5, 100, 3*(1920/5), 500);

		// Question A SETUP
		Button choice_A = new Button(100,400,800,600);

		// Fix sizing, left side button not equally far to the lefthand
		// side.
		fill(255);
		rect(100,400,1600/2,600);
		fill(0);
		textAlign(CENTER);
		textFont(f, 40);
		// This took wayyyyy too long lol.
		text("Hey do you want to establish \n world communism?", 500, 700);

		// Question B SETUP
		Button choice_B = new Button(1000, 400, 1600/2, 600);
		fill(255);
		rect(1000, 400, 1600/2, 600);

		textAlign(CENTER);
		textFont(f, 40);
		fill(0);
		text("So...\n Have you heard about Fortnite?", 1400, 700);

		if (choice_A.clicked()) {
		  clicked = true;
		}

		if (clicked) {
		  textAlign(CENTER);
		  clear();
		  text("This has been clicked", width/2, height/2);
		}

                return this;
            }

        }*/

    public class J1 extends Bruh {
        // J1 Storyline:

        public class Reddit extends Event {
            public Event foo() {
                background(60, 60, 0);
                textAlign(CENTER);
                textSize(40);
                text("As you are browsing reddit, you stumble across a Dark Web link", width/2, height/10);
                text("\nDo you click it?", width/2, height/10);


                text("Yes", width/4, height/2);
                text("No", 3*width/4, height/2);

                stroke(255);
                strokeWeight(5);
                line(width/2, height/5, width/2, 4*height/5);

                if (mouseReleased) {
                    if (mouseX < width/2) {
                        return new Attacked();
                    }
                    else {
                        return new Arrest();
                    }
                }

                return this;
            }
        }

        public class Arrest extends Event {
            public Event foo() {
                background(200, 100, 0);
                textAlign(CENTER);
                textSize(40);
                text("You are currently being arrested. Do you resist? Press Y/N.", width/2, height/2);
                if (keyPressed) {
                    if (key == 'y') {
                        return new Death();
                    }
                    else if (key == 'n') {
                        return new courtCase();
                    }
                }
                return new courtCase();
            }
        }

        public class courtCase extends Event {
            private boolean success;
            public Event foo() {
                return new courtCase();
            }
        }

        public class Prison extends Event {
            public Event foo() {
                background(100, 100, 125);
                line(20, 0, 20, height);
                line(40, 0, 40, height);
                line(60, 0, 60, height);
                line(80, 0, 80, height);
                textAlign(CENTER);
                textSize(40);
                text("You have been sentenced for your crimes. Now serve two years in jail. Press Enter", width/2, height/2);
                if (keyPressed) {
                    if (key == ENTER) {
                        return new Attacked();
                    }
                }

                return this;
            }
        }

        public class Attacked extends Event {

            private int timer = 0;
            private int success = 0;

            public Event foo() {
                background(100, 100, 125);
                line(20, 0, 20, height);
                line(40, 0, 40, height);
                line(60, 0, 60, height);
                line(80, 0, 80, height);
                textAlign(CENTER);
                textSize(40);
                text("You are being attacked. Quickly mash d.", width/2, height/2);
                if (keyPressed) {
                    if (key == ENTER) {
                        success = success + 1;
                        timer = 0;
                    }
                    if (success > 4) {
                        return new Released();
                    }
                }
                timer = timer + 1;
                if (timer > 5) {
                    return new Death();
                }
                return this;
            }

        }

        public class Death extends Event {
            public Event foo() {
                exit();
                return new Death();
            }
        }

        public class Released extends Event {
            public Event foo() {
                exit();
                return new Attacked();
            }
        }


    }

    public class Boreee extends Bruh {
        // Borella story
        // Wooo

        public class FadeIn extends Event {
            int bg = 0;
            boolean debug = false;


            public Event foo() {
                if (debug == true) {
                    // jump to point in story;

                    AlStory s = new AlStory();
                    return s.new School();
                }

                background(bg);

                bg++;
                if (bg == 50) {
                    startupSound.play();
                }

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
//                   Boreee is = new Start()
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
                    } else {
                        return new Crawl();
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

                if (mouseReleased) {
                    if (mouseX < width/2) {
                        return new FourChan();
                    } else {
                        return new Crawl();
                    }
                }

                return this;
            }
        }

        // branch to is

        public class FourChan extends Event {
            public Event foo() {
                background(60, 60, 0);
                textAlign(CENTER);
                textSize(40);
                text("As you wait your infantile body grows into that of a sickly 15 year old", width/2, height/10);
                text("\nYou are left with but one question.", width/2, height/10);
                text("\n\nDo you browse 4Chan?", width/2, height/10);

                text("Yes", width/4, height/2);
                text("No", 3*width/4, height/2);

                if (mouseReleased) {
                    if (mouseX < width/2) {
                        AlStory al = new AlStory();
                        return al.new School();
                    } else {

                    }
                }
                return this;
            }
        }

        public class Crawl extends Event {
            private BackgroundGen bg;
            public Crawl() {
                bg = new BackgroundGen();
            }
            public Event foo() {
                image(bg.goal, 0, 0);
                textAlign(CENTER);
                textSize(50);
                fill(255, 255, 255);
                text("YOU ARE BORN TO LOVING PARENTS", width/2, height/5);
                text("\nUNFORTUNATELY THEY LIVE IN DARWIN", width/2, height/5);
                text("\n\nEVEN SO YOUR LIFE IS IN ALL CAPS", width/2, height/5);
                text("\n\n\nCRAWL TO THE LEFT OR TO THE RIGHT?", width/2, height/5);

                if (mouseReleased) {
                    if (mouseButton == LEFT) {
                        return new CrawlLeft();
                    } else {
			Ishy s = new Ishy();
                        return s.new Yeetus();
                    }
                }

                return this;
            }
        }

        public class CrawlLeft extends Event {
            private BackgroundGen bg;

            public CrawlLeft() {
                bg = new BackgroundGen();
                bg.newGoal(0, 57, 100);
            }

            public Event foo() {
                image(bg.goal, 0, 0);
                fill(255);
                textAlign(CENTER);
                textSize(30);

                text("You crawl left. You continue to make similar left-leaning choices\n until your early high school years, when you realise the government is not gonna pay\n for your private school education. Do you drop out of school in outrage?", width/2, height/10);
                text("Yes", width/4, height/2);
                text("No", 3*width/4, height/2);

                stroke(255);
                strokeWeight(5);
                line(width/2, height/5, width/2, 4*height/5);

                if (mousePressed) {
                    if (mouseX <= width/2) {
                        // Switch to the Joel stream
                        J0el yaboi = new J0el();
                        return yaboi.new DropOut();
                    }

                    else {
                        // Switch to the Liam stream
                        return new FinishHighSchool();
                    }
                }

                return this;
            }
        }


        public class FinishHighSchool extends Event {
            public Event foo() {
                background(200, 100, 0);
                fill(255);
                textAlign(CENTER);
                textSize(25);
                text("You may be seething with leftist rage, but you're smart. Studious.\nOne day you'll show 'em.\nYou finally graduate and now you must make the big choices in life. Here comes one right now!\nDo you:", width/2, height/10);

                stroke(255);
                strokeWeight(5);
                line(width/2, height/5, width/2, 4*height/5);

                textSize(40);
                text("Smoke Crack", width/4, height/2);
                text("Move to Ipswitch", 3*width/4, height/2);

                if (mousePressed)
                    return new Sike();

                return this;
            }
        }

        public class Sike extends Event {
            int sikeTimer = 0;

            public Event foo() {
                background(0);
                fill(255);
                textAlign(CENTER);
                textSize(50);
                text("SIKE", width/2, height/3);

                if (sikeTimer >= 60) {
                    textSize(40);
                    text("they're the same thing lol", width/2, 2*height/3);
                }

                if (sikeTimer >= 240)
                    return new Prankd();

                sikeTimer++;
                return this;
            }
        }

        public class Prankd extends Event {
            private BackgroundGen bg;
            private int timer;

            public Prankd() {
                bg = new BackgroundGen();
                bg.newPollynomial(3);
                bg.newGoal(80, 90, 30);
            }

            public Event foo() {
                image(bg.goal, 0, 0);
                textAlign(CENTER);
                textSize(30);


                text("The walls rise into the air, lights come out of nowhere, fog seeps into your room.", width/2, height/10);

                if (mousePressed && timer < 239) timer = 239;

                if (timer >= 240) {
                    text("\nThere are cameras all around you. Suddenly, you realise it. That last question was a prank.", width/2, height/10);

                    if (mousePressed && timer < 479) timer = 479;
                }

                if (timer >= 480) {
                    text("\n\nThree figures come out of the fog - a tall, handsome man flanked by two people in hoods.\nYou try to escape but it's too late - a chilling voice fills the room...", width/2, height/10);

                    if (mousePressed && timer < 799) timer = 799;
                }

                if (timer >= 800) {
                    textSize(40);
                    text("YOU JUST GOT PRANKED BY THE PRANK PATROL", width/2, height/2);

                    if (mousePressed && timer < 999) timer = 999;
                }

                if (timer >= 1000 && mousePressed)
                    return new PrankdChoice(bg);

                timer++;

                return this;
            }
        }

        public class PrankdChoice extends Event {
            private BackgroundGen bg;

            public PrankdChoice(BackgroundGen bg) {
                this.bg = bg;
            }

            public Event foo() {
                image(bg.goal, 0, 0);
                textAlign(CENTER);
                textSize(40);

                text("There are few things in this world worse than being prankd.\nYou are filled with intense shame.\nWhat do you do now?", width/2, height/10);

                stroke(255);
                strokeWeight(5);
                line(width/2, height/5, width/2, 4*height/5);

                text("Change you name and\nmove to Iceland", width/4, height/2);
                text("End it all", 3*width/4, height/2);

                return this;
            }
        }
    }

            public class AlStory extends Bruh {


                // shitty rain with lightning
                // use as background with
                //private RainField bg = new RainField(5, (float)0.2, 10);
                public class RainField {

                    boolean lightning = true;
                    private float[][] rain = new float[100][3];
                    private boolean light = false;
                    private float vel = 0;
                    private float variance = 0;
                    int colour = 0;
                    int bgColour = 0;

                    public RainField(boolean lightn, float direction, float vari, float velocity, int col_our, int bg_Colour) {
                        vel = velocity;
                        variance = vari;

                        bgColour = bg_Colour;
                        colour = col_our;

                        rain_field_init(direction);
                        lightning = lightn;
                    }

                    public RainField(float direction, float vari, float velocity) {
                        vel = velocity;
                        variance = vari;

                        bgColour = 0;
                        colour = color(0, 100, 200);


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
                            rain[x][0] = rain[x][0] + (vel * (float)0.5 * cos(direction));
                            rain[x][1] = rain[x][1] + (-1 * vel * (float)0.5 * sin(direction));
                            if (random(100) > 80) {
                                rain[x][2] += random(-1 * variance, variance);
                            }
                        }
                    }

                    public void draw() {
                        rain_field();

                        strokeWeight(4);
                        stroke(colour);
                        //background(0);
                        if (light) {
                            if (random(10) > 2) {
                                background(255);
                            }
                            if (random(10) > 8) {
                                background(0);
                                light = false;
                            }
                        } else if (random(10) > 9.8 && lightning) {
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
        //            background(background);
                    textSize(40);
                    textAlign(CENTER);
                    text(textone, width / 2, 50);
                    text(texttwo, width / 4, height/2);
                    text(textthree, (width * 3 / 4), height/2);
                }

                public void draw_context(String textone) {
                    // background
        //            background(background);
                    textSize(40);
                    textAlign(CENTER);
                    text(textone, width / 2, height/3);
                }

                public boolean dysentery() {
                    if (random(0, 500) == 1) {
                        background(0);
                        draw_context("You have died of dysentery.");
                        if (mousePressed) {
                            exit();
                        }
                    }

                    return false;
                }

                public int get_mouse() {
                    if (mousePressed && (mouseX > width / 2)) {
                        return (1);
                    }
                    if (mousePressed && (mouseX <= width / 2)) {
                        return (0);
                    }
                    return(-1);
                }

                public class School extends Event {
                    public Event foo() {
                        clear();
                        RainField rain = new RainField(5, (float)0.2, 10);
                        rain.draw();

                        draw_context("You sit at school, it is raining.\nThe state has blocked 4chan...life has no\n purpose.");
                        if (mousePressed) {
                            if (censored) {
                                return new blank_rain_1();
                            } else {
                                return new Dog();
                            }
                        }
                        return(this);
                    }
                }

                public class Dog extends Event {
                    private boolean red = false;
                    private boolean redtwo = false;
                    private int i = 0;
                    public Event foo() {
                        clear();
                        RainField rain = new RainField(5, (float)0.2, 10);
                        rain.draw();
                        draw_context("Watching the road out the window, nothing\ninterests you until you see a dog,\nit is running around in the rain. A\ncar appears from nowhere and runs over the dog.\nYou see its head explode with blood\n all over the road.\nYou feel nothing.");
                        if (i > 40) {
                            return(new blank_rain_1());
                        }

                        if (red) {
                            clear();
                            i = i + 1;
                            if (redtwo) {
                                redtwo = false;
                                background(255, 0, 0);
                            }
                            else {
                                redtwo = true;
                                background(0);
                            }
                        }

                        if (mousePressed) {
                            red = true;
                        }
                        return this;
                    }
                }

                public class blank_rain_1 extends Event {
                    public Event foo() {
                        clear();
                        RainField rain = new RainField(5, (float)0.2, 10);
                        rain.draw();
                        if (mousePressed) {
                            return new later();
                        }
                        return this;
                    }
                }

                public class later extends Event {
                    BackgroundGen bg;
                    public later() {
                        bg = new BackgroundGen();
                        bg.newPollynomial(3);
                        bg.newGoal(70, 80,40);
                    }

                public Event foo() {
                    clear();
                    image(bg.goal, 0, 0 );

                    draw_context("2 years have passed. You have now graduated high school.");
                    if (mousePressed) {
                        return new First();
                    }
                    return this;
                }

            }

            public class First extends Event {
                BackgroundGen bg;
                public First() {
                    bg = new BackgroundGen();
                    bg.newPollynomial(3);
                    bg.newGoal(70, 80,20);
                }

                public Event foo() {
                    clear();
                    image(bg.goal, 0, 0);
                    RainField rain = new RainField(5, (float)0.2, 10);
                    rain.draw();

                    draw_event("You feel a tense baseline dissatisfaction\n with your success in life so far.\n You tell yourself it's not selfhatred\nbut actually you feel undeserving of\nall you have but regretful that you don't\n have more. But life is good, or as good as\nyou make it.",
                            "Take a sabattical in the\nmountains of South America",
                            "Enrol at UQ");

                    if (get_mouse() == 0) {
                        return new Sabbat();
                    }
                    if (get_mouse() == 1) {
                        return new UQ();
                    }
                    return this;
                }
            }

            public class Sabbat extends Event {

                public Event foo() {
                    clear();
                    background(200);
                    RainField rain = new RainField(false, 5, (float)1, (float)0.001, color(255, 255, 255), color(255,255,255));
                    rain.draw();
                    draw_event("While you are in North America, on a \n stop-over before flying to Brazil,\n canada annexes the United States",
                            "Run to the Australian Embassy",
                            "Accept your fate as you are\nforced to join the Canadian Imperial Forces");

                    return this;
                }

            }


            public class UQ extends Event {
                BackgroundGen bg;

                public UQ() {
                    bg = new BackgroundGen();
                    bg.newPollynomial(3);
                    bg.newGoal(70, 80,20);
                }

                public Event foo() {
                    clear();
                    image(bg.goal, 0, 0);
                    RainField rain = new RainField(5, (float)0.2, 10);
                    draw_event("What Program do you take?", "Computer Science", "Arts");

                    if (get_mouse() == 0) {
                        return new CompSci();
                    }
                    if (get_mouse() == 1) {
                        return new Arts();
                    }

                    return this;
                }

            }

            public class Arts extends Event {
                public Event foo() {
                    clear();
                    draw_context("You grow an exorbitant beard.\nPhilosophy opens your mind to new possibilities,\ndespite gaining a deep understanding of\nethics you cannot help but use it to rationalise\nall your flaws. You become a worse person. You understand so much more\nthan when you were ba naive youth, and yet feel more\ndissatisfied than ever before.");
                    return this;
                }
            }

            public class Arts_too extends Event {
                public Event foo() {
                    clear();
                    draw_context("You grow an exorbitant beard.\nPhilosophy opens your mind to new possibilities,\ndespite gaining a deep understanding of\nethics you cannot help but use it to rationalise\nall your flaws. You become a worse person. You understand so much more\nthan when you were ba naive youth, and yet feel more\ndissatisfied than ever before.");
                    return this;
                }

            }

            public class CompSci extends Event {
                public Event foo() {
                    clear();
                    draw_context("You go bald");

                    if (mousePressed) {
                        return new CompSciYeet();
                    }
                    return this;
                }
            }

            public class CompSciYeet extends Event {
                public Event foo() {
                    clear();
                    draw_context("You have finished your degree and \nbecome a professional prgrammer.");
                    if (mousePressed) {
                        return new CompSciYeetTwo();
                    }
                    return this;
                }
            }

            public class CompSciYeetTwo extends Event {
                public Event foo() {
                    clear();
                    draw_event("You register for a hackathon, what do you make?", "An advanced dolphin-petting\nsimulator game", "A research paper on graph theory\nin financial computing.");
                    if (get_mouse() == 0) {
                        return new aDolphin();
                    }
                    if (get_mouse() == 1) {
                        return new Banking();
                    }
                    return this;
                }
            }

            public class aDolphin extends Event {

                public Event foo() {
                    clear();
                    draw_event("Your dolphin petting simulator wins second prize\nfor its highly precise modelling of the now-extinct-\ndue-to-climate-change dolphins. It sparks joy in\nchildren's eyes without the enslavement of\nhighly intelligent mammals.",
                            "Quit your job to work on\nmonetizing the project", "Open source it so the dolphins can live forever");
                    if (get_mouse() == 0) {
                        // you ruin it and it becomes an evil corporate monolith that creates extensive suffering
                        return this;
                    }
                    if (get_mouse() == 1) {
                        // the dolphins become sentient
                        return this;
                    }
                    return this;
                }
            }

            public class Banking extends Event {
                public Event foo() {
                    clear();
                    draw_event("The Australian Treasury offers you a job\nworking on the 2020 Financial Crisis\ninquiry of resoluion. So you accept?",
                            "Yes", "No");
                    if (get_mouse() == 0) {
                        return new Excel();
                    }
                    if (get_mouse() == 1) {
                        return new NZ();
                    }
                    return this;
                }
            }

            public class Excel extends Event {
                public Event foo() {
                    clear();
                    draw_event("Due to an Excel programming error\nyour study turns out to be wrong.\nThe Australian economy collapses.",
                            "Flee to New Zealand", "Die.");
                    if (get_mouse() == 0) {
                        return new NZ_too();
                    }
                    if (get_mouse() == 1) {
                        exit();
                    }
                    return this;
                }
            }


            public class NZ extends Event {
                public Event foo() {
                    clear();
                    draw_context("You move to New Zealand to pursure more\nlucrative job opportunities.");

                    if (mousePressed) {
                        return new NZ_too();
                    }
                    return this;
                }
            }

            public class NZ_too extends Event {

                public Event foo() {
                    clear();
                    draw_event("Capitalizing on the Australian financial collapse\nNew Zealand swiftly annexes it via nonviolent\ndrone warfare.",
                            "Take a public sector programming job\nin your new government.", "Move to China for\ngreater stability");

                    return this;
            }
        }

    }

    public class BackgroundGen {
        complx[] mz = new complx[5];
        PImage goal;
        float xcenter = 0;
        float ycenter = 0;
        float xradius = 2;
        float yradius = 2;

        public BackgroundGen() {
            goal = new PImage(width, height);
            newPollynomial(5);
        }

        void newGoal(int huemin, int huemax, int lightness) {
          goal.loadPixels();
            for (int i = 0; i<goal.pixels.length; i++) {
              float rin = map(i % goal.width, 0, goal.width, xcenter - xradius, xcenter + xradius);
              float iin = map(floor(i/goal.width), 0, goal.height, ycenter - yradius, ycenter + yradius);
              complx num = fz(new complx(rin, iin));
              float hue = map((atan2(num.i, num.r) + PI + 2*PI) % (2*PI), 0, 2*PI, huemin, huemax);
              float sat = sqrt(num.i * num.i + num.r * num.r)*50;
              colorMode(HSB, 100);
              goal.pixels[i] = color(hue, sat, lightness);
              colorMode(RGB, 255);
            }
          goal.updatePixels();

          image(goal, 0, 0, width, height);
        }

        float sign(float in) {
          if (in > 0) {
            return 1;
          } else {
            return -1;
          }
        }

        void newPollynomial(int order) {
          mz = new complx[order];
          for (int i = 0; i<mz.length; i++) {
            mz[i] = new complx(randomGaussian(), randomGaussian());
          }
        }

        complx fz(complx num) {
          complx out = new complx(0, 0);
          for (int i = 0; i<mz.length; i++) {
            complx temp = num;
            temp = powComplx(temp, i);
            temp = multiComplx(mz[i], temp);
            out = addComplx(temp, out);
          }
          return out;
        }

        class complx {
          float i;
          float r;
          complx(float real, float imag) {
            i = imag;
            r = real;
          }
        }

        complx powComplx(complx one, int num) {
          complx temp = new complx(1, 0);
          for (int i = 0; i<num; i++) {
            temp = multiComplx(one, temp);
          }
          return temp;
        }

        complx multiComplx(complx one, complx two) {
          float r = one.r * two.r - one.i * two.i;
          float i = one.i * two.r + one.r * two.i;
          return new complx(i, r);
        }

        complx addComplx(complx one, complx two) {
          return new complx(one.r + two.r, one.i + two.r);
        }
    }

    public class SnowField {

        private int snow_no = 0;
        private Snow[] snow;

        public class Snow {
            float x;
            float y;
            float velx;
            float vely = 10;

            float wiggle;
            float wiggle_chance;

            public Snow() {
                this.wiggle = 5; //wiggle;
                this.wiggle_chance = 10; //wiggle_chance;

                this.x = random(width);
                this.y = random(height);
            }

            public void update() {
                if (random(1) < wiggle_chance) {
                    velx += random(-wiggle, wiggle);
                }

                x += velx;
                y += vely;
            }
        }

        public SnowField(int snowNo) {
            snow = new Snow[snowNo];
            snow_no = snowNo;
        }

        public void update() {
            background(51, 51, 255);
            textAlign(CENTER);
            textSize(20);
            fill(255);

            for (int i = 0; i < snow_no; i++) {
                snow[i].update();
                float wiggle = snow[i].wiggle;
                text("*", snow[i].x + random(-1 * wiggle, wiggle), snow[i].y);
            }
        }
    }


    public class J0el extends Bruh {
        public class DropOut extends Event {
            BackgroundGen bg;
            public DropOut() {
                bg = new BackgroundGen();
                bg.newPollynomial(2);
                bg.newGoal(120, 165, 70);
            }
            public Event foo() {
                background(200, 100, 0);
                textAlign(CENTER);
                textSize(40);
                text("Fair shout. You'll show em.\nHeck the government dude.\nyoyo\nKeen to get into the good stuff tho?\n\n[y/n]", width/2, height/2);
                if (keyPressed) {
                    if (key == 'y') {
                    }
                    else if (key == 'n') {
                    }
                }
                return this;
            }
        }
    }
}
