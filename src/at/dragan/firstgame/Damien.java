package at.dragan.firstgame;


import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Damien implements Actor {
    private Image damienImage;
    private int x, y;

    private double speed;

    public Damien(int x, int y, double speed) throws SlickException {
        Image tep =new Image("testdata/deml.png");
        this.damienImage = tep.getScaledCopy(50, 50);
        this.x = x;
        this.y = y;
        this.speed = speed;
    }


    @Override
    public void render(Graphics graphics) {
       damienImage.draw(this.x, this.y);
    }

    @Override
    public void update(int delta) {
        this.x += (double)delta / this.speed;
        if (this.x > 800) {
            this.x = 0;
        }
        if (this.x < 0) {
            this.x = 800;

        }
    }

    }
