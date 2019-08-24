import processing.core.*;

abstract class Background {

    Background();

    draw();
}

public class al extends Start {

    public class RainField {

        private float[][] rain = new float[100][3];
        private boolean light = false;
        private float vel = 0;
        private float variance = 0;

        public RainField() {
            RainField(5, 10, 80)
        }

        public RainField(float direction, float var, float velocity) {
            vel = velocity;
            variance = var;

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

                direction = rain[x][2];
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
                float x2x = rain[x][0] + (vel * cos(direction));
                float y2x = rain[x][1] + (-1 * vel * sin(direction));
                line(rain[x][0], rain[x][1], x2x, y2x);
            }
        }
    }
}
