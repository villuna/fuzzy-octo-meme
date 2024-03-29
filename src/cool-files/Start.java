import processing.core.*;
import processing.sound.*;

public class Start extends PApplet {
    boolean censored = true;
    boolean mouseDown = false;
    boolean mousePressed = false;
    boolean mouseReleased = false;
    boolean keyPressed = false;
    boolean keyReleased = false;

    TrippyOsc saw;
    TrippyOsc sawt;
    TrippyOsc sawtt;
    SoundFile startupSound;
    SoundFile menAtWork;
    SoundFile[] greatestHits;
    String playerName = "";
    Event currentEvent;
    Boreee b;
    PFont fnt;

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

        menAtWork = new SoundFile(this, "dunder.mp3");

        greatestHits = new SoundFile[4];
        greatestHits[0] = new SoundFile(this, "hit1.mp3");
        greatestHits[1] = new SoundFile(this, "hit2.mp3");
        greatestHits[2] = new SoundFile(this, "hit3.mp3");
        greatestHits[3] = new SoundFile(this, "hit 4.mp3");

    }

    public void setup() {
        fnt = createFont("rockwen.ttf", 10);
        textFont(fnt);
    }

    public void play_hit() {
        int num = (int)random(0,4);
        greatestHits[num].play();
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

    class TrippyOsc extends Bruh {

        /*
        saw = new TrippyOsc(this);
        sawt = new TrippyOsc(this);
        sawtt = new TrippyOsc(this);
        saw.setup(20, 1000, 2, 500);
        sawt.setup(20, 1000, 2, 100);
        sawtt.setup(20, 1000, 2, 100);
        saw.play();
        sawt.play();
        sawtt.play();
         */

        // Put thises in main draw loop
        //        saw.update();
        //        sawt.update();
        //        sawtt.update();

        int fre = 100;
        float pan = 0;
        int upperBound = 2000;
        int lowerBound = 20;
        int panAmount = 0;
        int walkAmount = 0;
        SinOsc osc;

        public TrippyOsc(PApplet thingy) {
            osc = new SinOsc(thingy);
        }

        public void setup(int lowerbound, int upperbound, int panamount, int walkamount) {
            lowerBound = lowerbound;
            upperBound = upperbound;
            panAmount = panamount;
            walkAmount = walkamount;
        }

        void play() {
            osc.play();
        }

        void stop() {
            osc.stop();
        }

        void update() {
            // applies randomisation
            osc.freq(fre);
            osc.pan(0);
            if ( (int)(random(panAmount)) == 1 ){
                if (random(panAmount) > (panAmount/2)) {
                    osc.pan((float)1.0);
                } else
                    osc.pan((float)0.0);
            }
            if ((int)(random(walkAmount)) > 1) {
                fre += random(-1*walkAmount, walkAmount);
                if (fre > upperBound) {
                    fre= upperBound;
                }
                if (fre < lowerBound) {
                    fre = lowerBound;
                }
            }
            osc.freq(fre);
        }
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
                return this;
            }
        }

        public class courtCase extends Event {
            private boolean success;
            public Event foo() {
                background(200, 100, 0);
                textAlign(CENTER);
                textSize(40);
                draw_event("You are currently on trial./nWho is representing you?.",
                        "Your Friend",
                        "An Actual Lawyer");
                if (get_mouse() == 0) {
                    return new Released();
                }
                if (get_mouse() == 1) {
                    return new Prison();
                }
                return this;
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
                text("You have been sentenced for your crimes. Now serve forty-five years in jail. Press Enter", width/2, height/2);
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
                text("You are being attacked. Quickly Mash Enter.", width/2, height/2);
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
                text("You have just been released from jail/n However your long time in prison has made old and uncapable./n Thus your lose sight of your goal/n and live the rest of your miserable life with a family. /n Game Over", width/2, height/2);
                exit();
                return this;
            }
        }

        public class LinkA1 extends Event {

            public Event foo() {
                text("Having found nothing interesting on reddit. You continue your education.", width/2, height/2);
                AlStory al = new AlStory();
                return al.new School();
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

        public int get_mouse() {
            if (mousePressed && (mouseX > width / 2)) {
                return (1);
            }
            if (mousePressed && (mouseX <= width / 2)) {
                return (0);
            }
            return(-1);
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
                background(0, 0, 0);
                fill(255);
                textAlign(CENTER);
                textSize(40);
                text("You are about to be born", width / 2, height / 2);

                if (mousePressed) {
//                   Boreee is = new Start()
                    return new EndGoalYeet();
                } else {
                    return this;
                }
            }
        }

        public class EndGoalYeet extends Event {
            public Event foo() {
                background(0, 0, 0);
                textAlign(CENTER);
                textSize(40);
                text("Your goal: Establish world Communism.", width/2, height/2);

                if (mousePressed) {
                    return new AfterBorn();
                }

                return this;
            }
        }

        public class AfterBorn extends Event {
            int stillTimer = 0;

            public Event foo() {
                if (random(200) <= 1) {
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
            float timer = 0;
            float delayTimer = 0;
            float maxDelay = 30;
            float maxTime = 90;
            float enterTimer = 0;
            float enterTime = 20;

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
                fill(255);
                text("Did you mean: ", width/2, height/4);
                fill(255, 255, 255, 255f*(timer/maxTime));
                text(name + "?", width/2, height/2);
                fill(255);
                if (enterTimer >= enterTime) {
                    textSize(20);
                    text("Press ENTER to confirm", width/2, 5*height/6);
                }

                if (delayTimer < maxDelay) delayTimer++;
                else if (timer < maxTime) timer++;
                else if (enterTimer < enterTime) enterTimer++;

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
                        J1 j = new J1();
                        return j.new Reddit();
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
                bg.newGoal(0, 57, 40);
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
                line(width/2, height/4, width/2, 4*height/5);

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
                text("You may be seething with leftist rage, but you're smart. Studious.\nOne day you'll show 'em.\nYou finally graduate and now you must make the big choices in life. Here comes one right now!\nDo you:", width/2, height/12);

                stroke(255);
                strokeWeight(5);
                line(width/2, height/3.5f, width/2, 5*height/6);

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
                }

                if (timer >= 800 && mousePressed)
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
                    textSize(30);

                    text("There are few things in this world worse than being prankd.\nYou are filled with intense shame.\nWhat do you do now?", width/2, height/10);

                    stroke(255);
                    strokeWeight(5);
                    line(width/2, height/4, width/2, 4*height/5);

                    textSize(40);

                    text("Change your name and\nmove to Iceland", width/4, height/2);
                    text("End it all", 3*width/4, height/2);

                    if (mousePressed) {
                        if (mouseX < width/2) {
                            return new Iceland();
                        } else {
                            return new Seppuku();
                        }
                    }

                    return this;
                }
            }

            public class Iceland extends Event {
                private SnowField sf;

                public Iceland() {
                    sf = new SnowField(100);
                }

                public Event foo() {
                    sf.update();

                    textSize(20);
                    text("You move to a nice town called Svalbardsstrandarhreppur.\n However, upon realising you have to learn how to pronounce Icelandic you are hit with a bout of depression. Do you:", width/2, height/10);

                    textSize(40);

                    text("Take a language course", width/4, height/2);
                    text("Drown your sorrows", 3*width/4, height/2);

                    strokeWeight(5);
                    stroke(255);
                    line(width/2, height/5, width/2, 4*height/5);

                    if (mousePressed) {
                        if(mouseX < width/2) {
                            // Go to language
                        } else {
                            // DRINK
                            return new Pub();
                        }
                    }

                    return this;
                }
            }

            public class Seppuku extends Event {
                public Event foo() {
                    background(125, 0, 0);
                    fill(125);
                    textSize(30);
                    text("You try comitting seppuku. However, you named your sword git and as such\nit doesn't commit properly.\n You wake up in the hospital.", width/2, height/10);

                    textSize(40);

                    text("Yeet that life support", width/4, height/2);
                    text("No, I'm a changed man", 3*width/4, height/2);

                    strokeWeight(5);
                    stroke(125);
                    line(width/2, height/4, width/2, 5*height/6);

                    if (mousePressed) {
                        if (mouseX < width/2) {
                            return new LifeSupport();
                        } else {
                            
                        }
                    }

                    return this;
                }

            }

            public class LifeSupport extends Event {
                private float timer = 0;
                private float maxTime = 60;

                public Event foo() {
                    background(125, 0, 0);
                    fill(255);
                    textSize(50);
                    text("Everything's going black...", width/2, height/2);

                    fill(0, 0, 0, 255f*(timer/maxTime));
                    rect(0, 0, width, height);

                    if (timer >= maxTime) exit();

                    timer++;
                    return this;
                }
            }

            public class Pub extends Event {
                DrunkText drink;
                float drunkedness = 0;

                public Pub() {
                    drink = new DrunkText("Press D to drink", width/2, height/10, 0);
                }

                public Event foo() {
                    background(0, 0, 200 * (1-drunkedness));

                    if (keyPressed) {
                        if (key == 'd') {
                            drunkedness += 0.1;
                            drink = new DrunkText("Press D to drink", width/2, height/10, drunkedness);

                            filter(BLUR, 1);
                        }
                    }

                    drink.update();

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
/*NICE*/                    return new NZ_too();
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
            private BackgroundGen bg;

            public class Snow {
                float x;
                float y;
                float velx;
                float maxVelx = 3;
                float vely = 5;

                float wiggle;
                float wiggle_chance;

                public Snow() {
                    this.wiggle = 1; //wiggle;
                    this.wiggle_chance = 0.5f; //wiggle_chance;

                    this.x = random(width);
                    this.y = random(height);
                }

                public void update() {
                    if (random(1) < wiggle_chance) {
                        float velDiff = random(-wiggle, wiggle);

                        if (abs(velx+velDiff) >= maxVelx)
                            velx -= velDiff;

                        else velx += velDiff;

                    }

                    x += velx;
                    y += vely;

                    if (y > height) {
                        y = -10;
                        x = random(0, width);
                    }

                    if (x < 0 || x > width) x = random(0, width);
                }
            }

            public SnowField(int snowNo) {
                snow = new Snow[snowNo];

                for (int i = 0; i < snowNo; i++) {
                    snow[i] = new Snow();
                }

                snow_no = snowNo;

                bg = new BackgroundGen();
                bg.newPollynomial(3);
                bg.newGoal(50,70, 25);
            }

            public void update() {
                image(bg.goal, 0, 0);
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
                bg.newPollynomial(4);
                bg.newGoal(120, 165, 70);
            }
            public Event foo() {
                image(bg.goal, 0, 0);
                //background(200, 100, 0);
                textAlign(CENTER, CENTER);
                textSize(40);
                text("Fair shout. You'll show em.\nHeck the government dude.\nyoyo\nKeen to get into the good stuff tho?\n\n[y/n]", width/2, height/5);
                if (keyPressed) {
                    if (key == 'y') {
                        return new Smoke();
                    }
                    else if (key == 'n') {
                        return new Aristocracy();
                    }
                }
                return this;
            }
        }

        public class Aristocracy extends Event {
            public Event foo() {
                background(0, 0, 80);
                textAlign(CENTER, CENTER);
                textSize(40);
                text("Oh geez to posh I guess.\nIn that case you move to Adelaide\nand become part of the aristocracy", width/2, height/5);
                return this;
            }
        }

        public class Boring extends Event {
            int timer = 0;
            public Event foo() {
                background(50);
                fill(200);
                text("A fair descision.\nseeing as the tropics aren't an option,\nyou decide to become a panel beater.\nYou move to broome to enhance your job prospects", width/2,height/2);
                if (timer > 60*6) {
                    text("\n\n\n\n\nclick to beat panels", width/2, height/2);
                }
                if (mouseReleased) {
                    return new Beat();
                }
                timer++;
                return this;
            }
        }

        public class Win extends Event {
            int timer = 0;
            public Event foo() {
                background(255, 0, 0);
                textSize(80);
                fill(255, 255, 0);
                text("World Communism Established\n", width/2, height/2);
                if (timer >= 60*6) {
                    textSize(90);
                    text("\nYou Win!", width/2, height/2);
                }
                timer++;
                return this;
            }
        }

        public class TopClass extends Event {
            PImage b;
            float timer = 255;
            int count = 0;
            public TopClass() {
                b = loadImage("broome.jpg");
                menAtWork.play(1, 5);
            }
            public Event foo() {
                image(b, 0, 0, width, height);
                fill(50, 50, 50, timer);
                noStroke();
                rect(0, 0, width, height);
                fill(255);
                text("After minutes of panel beating, you ascend into the air\nYou have become the best panel beater in Broome!\n\n", width/2, height/2);
                timer /= 1.001;
                count++;
                if (count > 60*7) {
                    text("\n\nYour omnicient panel beating skills draw, and unite \n crowds of all kinds from all places", width/2, height/2);
                }
                if (count > 60*17) {
                    return new Win();
                }
                return this;
            }
        }

        public class Beat extends Event {
            int timer = 0;
            public Event foo() {
                background(50);
                fill(200);
                text("click to beat\n", width/2, height/2);
                if (timer > 5) {
                    text("\npanels beaten: " + timer, width/2, height/2);
                }
                if (timer > 50) {
                    text("\n\n\ngeez", width/2, height/2);
                }
                if (mouseReleased) {
                    play_hit();
                    background(255);
                    timer++;
                }
                if (timer > 69) {
                    return new TopClass();
                }
                return this;
            }
        }

        public class cairns extends Event {
            public Event foo() {
                background(0);
                return this;
            }
        }

        public class theNorth extends Event {
            int screen = 0;
            // RainField rain;
            public theNorth() {

            }
            public Event foo() {
                background(111, 194, 60);
                fill(255, 215, 105);
                textSize(60);
                text("The Glorious Tropics", width/2, height/4);
                textSize(40);
                switch (screen) {
                    case 0:
                        text("You land in Cairns and get off the plane.", width/2, height/2);
                        break;
                    case 1:
                        text("You are immediately immersed in\na ferral sea of muggy air\nYour skin begins to wrinkle", width/2, height/2);
                        break;
                    case 2:
                        text("you slowly begin to notice something\n...", width/2, height/2);
                        break;
                    case 3:
                        text("the flies", width/2, height/2);
                        break;
                    case 4:
                        text("the flies\nthe ederly, whose skin is practically made of melanoma", width/2, height/2);
                        break;
                    case 5:
                        text("the flies\nthe ederly, whose skin is practically made of melanoma\nThe disillusioned youth, resigned they'll never amount to anything", width/2, height/2);
                        break;
                    case 6:
                        text("The stench", width/2, height/2);
                        break;
                    case 7:
                        text("What can a man do?", width/2, height/2);
                        break;
                    default:
                        text("[F] Fight the system\n[J] Join the system", width/2, height/2);

                }
                filter(BLUR, ((float) screen)/3);



                loadPixels();
                for (int i = 0; i<pixels.length; i++) {
                    int col = pixels[i];
                    col = color(red(col) + random(-screen, -screen), green(col) + random(-screen, -screen), blue(col) + random(-screen, -screen));
                }
                updatePixels();
                if (mouseReleased) screen++;
                return this;
            }
        }

        public class Smoke extends Event {
            int timer = 0;
            public Event foo() {
                fill(0, 0, 0, 20);
                noStroke();
                rect(0, 0, width, height);
                //background(200, 100, 0);
                textAlign(CENTER, CENTER);
                textSize(40);
                fill(random(255), random(255), random(255));
                if (timer >= 15*60) {
                    if (keyPressed) {
                        if (key == 'y') {
                            return new theNorth();
                        }
                        else if (key == 'n') {
                            return new Boring();
                        }
                    }
                }
                int x = mouseX + round(randomGaussian()*5);
                int y = mouseY + round(randomGaussian()*5);
                if (timer >= 22*60) {
                    text("(that's a [y/n] situation my dude)", x, y);
                } else if (timer >= 15*60) {
                    text("How does the tropical north sound?", x, y);
                } else if (timer >= 5*60) {
                    text("Seeing as we're all one\nI think its time to move away from Darwin", x, y);
                } else {
                    text("woah dude", x, y);
                }
                timer++;
                return this;
            }
        }
    }

    public class DrunkText {
        float[] stext = new float[2];
        float[][] mtext = new float[3][2];
        float[][] ltext = new float[3][2];

        String s = "";

        public DrunkText(String s, int x, int y, float drunkedness) {
            // Drunkedness goes from 0 to 1 - 0 not very drunk, 1 extremely drunk
            float sOffs = 5;
            float mOffs = 20;
            float lOffs = 50;

            this.s = s;

            // Normal text:
            stext[0] = x+drunkedness*random(-sOffs,sOffs);
            stext[1] = y+drunkedness*random(-sOffs,sOffs);

            // Chromatically abberated text:
            for (int i = 0; i < 3; i++) {
                mtext[i][0] = x+drunkedness*random(-mOffs,mOffs);
                mtext[i][1] = y+drunkedness*random(-mOffs,mOffs);

                ltext[i][0] = x+drunkedness*random(-lOffs,lOffs);
                ltext[i][1] = y+drunkedness*random(-lOffs,lOffs);
            }
        }

        public void update() {
            // Dark chromatic text
            fill(0, 125, 125);
            text(s, ltext[0][0], ltext[0][1]);

            fill(125, 0, 125);
            text(s, ltext[1][0], ltext[1][1]);

            fill(0, 125, 125);
            text(s, ltext[2][0], ltext[2][1]);

            // Chromatic text
            fill(255, 0, 0);
            text(s, mtext[0][0], mtext[0][1]);

            fill(0, 255, 0);
            text(s, mtext[1][0], mtext[1][1]);

            fill(0, 0, 255);
            text(s, mtext[2][0], mtext[2][1]);

            // Normal text
            fill(255);
            text(s, stext[0], stext[1]);

        }
    }

}
