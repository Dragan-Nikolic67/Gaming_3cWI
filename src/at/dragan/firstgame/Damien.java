package at.dragan.firstgame;


import org.newdawn.slick.*;

public class Damien implements Actor {
    private Image damienImage;
    private int x, y;

    private double speed;

    public Damien(int x, int y, double speed) throws SlickException {
        Image tep = new Image("testdata/deml.png");
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
    public void update(GameContainer gameContainer, int delta) {

        if (gameContainer.getInput().isKeyDown(Input.KEY_D)) {
            this.x++;

        }
        if (gameContainer.getInput().isKeyDown(Input.KEY_A)) {
            this.x--;

        }
        if (gameContainer.getInput().isKeyDown(Input.KEY_W)) {
            this.y--;

        }
        if (gameContainer.getInput().isKeyDown(Input.KEY_S)) {
            this.y++;

        }


    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
