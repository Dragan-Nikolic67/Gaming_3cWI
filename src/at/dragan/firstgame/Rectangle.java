package at.dragan.firstgame;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import java.util.Random;

public class Rectangle implements Actor {
    private float x;
    private float y;
    private int speed;
    Random random = new Random();

    public Rectangle(float x, float y) {
        this.x = x;
        this.y = y;
        this.speed = random.nextInt(50) - 100;

        }


    public void render(Graphics graphics) {
        graphics.drawRect(this.x, this.y, 60, 30);
    }

    public void update(GameContainer gameContainer, int delta) {
        this.y -= (float) delta / this.speed;

    }}
