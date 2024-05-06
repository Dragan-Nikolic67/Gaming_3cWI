package at.dragan.firstgame;

import org.newdawn.slick.Graphics;

import java.util.Random;

public class Rectangle implements Actor {
    private float x;
    private float y;
    private int speed;
    Random random = new Random();

    public Rectangle (float x, float y, String direction) {
        this.x = x;
        this.y = y;
        if (direction.equals("Right")){
            this.speed = random.nextInt(50 + 10);
        } else if (direction.equals("Left")) {
            this.speed = random.nextInt(50) - 100;

        }
    }

    public void render(Graphics graphics) {
        graphics.drawRect(this.x, this.y, 20, 10);
    }

    public void update(int delta) {
        this.x += (float) delta / this.speed;
        if (this.x > 800) {
            this.x = 0;
        }
        if (this.x < 0) {
            this.x = 800;

        }
    }
}
