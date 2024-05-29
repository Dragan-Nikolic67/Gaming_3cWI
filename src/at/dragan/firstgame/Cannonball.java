package at.dragan.firstgame;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class Cannonball implements Actor {
    private int x, y;

    public Cannonball(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.fillOval(this.x, this.y, 10, 10);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        this.y--;
    }
}
