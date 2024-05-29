package at.dragan.firstgame;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import java.util.Random;

public class Ellipse implements Actor {
    private float x;
    private float y;
    private float speed;

    public Ellipse(float x, float y) {
        this.x = x;
        this.y = y;
        this.speed = 5;
    }

    public void render(Graphics graphics) {
        graphics.drawOval(this.x, this.y, 50, 10);
    }

    public void update(GameContainer gameContainer, int delta) {
        Random random = new Random();
        if (this.x >= 800 || this.y >= 600) {
            this.x = random.nextInt(600);
            this.y = random.nextInt(600);
        }
        this.y += (float) delta / this.speed;
        this.x += (float) delta / this.speed;
    }
}
