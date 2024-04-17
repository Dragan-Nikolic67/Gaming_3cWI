package at.dragan.firstgame;

import org.newdawn.slick.*;
import org.newdawn.slick.tests.AnimationTest;

public class Rectangle extends BasicGame {
    private float circle_y;
    private float oval_x;
    private float rec_x;
    private float rec_y;

    private boolean circleGoingDown;
    private boolean ovalGoingRight;

    private boolean recGoingRight;

    private boolean recGoingDown;

    private Boolean recGoingLeft;

    private Boolean recGoingUp;


    public Rectangle(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.recGoingRight = true;
        this.circleGoingDown = true;
        this.ovalGoingRight = true;
        this.rec_y = 120;



    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        float lowerBorder = 500;
        float upperBorder = 0;
        float leftBorder = 0;
        float rightBorder = 600;
        if (circleGoingDown) {
            this.circle_y++;
            if (this.circle_y >= lowerBorder) {
                circleGoingDown = false;
            }
        } else {
            this.circle_y--;
            if (this.circle_y <= upperBorder) {
                circleGoingDown = true;
            }
        }
        if (ovalGoingRight) {
            this.oval_x++;
            if (this.oval_x >= rightBorder) {
                ovalGoingRight = false;
            }
        } else {
            this.oval_x--;
            if (this.oval_x <= leftBorder) {
                ovalGoingRight = true;
            }
        }
        if (recGoingRight) {
            this.rec_x++;
            if (this.rec_x >= rightBorder) {
                recGoingRight = false;
                recGoingDown = true;
            }
        } else if (recGoingDown) {
            this.rec_y++;
            if (this.rec_y >= lowerBorder - 100) {
                recGoingDown = false;
                recGoingLeft = true;
            }

            } else if (recGoingLeft){
            this.rec_x--;
            if(this.rec_x<=leftBorder + 100){
                recGoingLeft = false;
                recGoingUp = true;
            }
        } else if (recGoingUp){
            this.rec_y--;
            if(this.rec_y<=upperBorder + 120){
                recGoingUp = false;
                recGoingRight = true;
            }
        }
        }



//für nächstes mal, x = 120, 600  y=120, 400
            @Override
            public void render (GameContainer gameContainer, Graphics graphics) throws SlickException {
                graphics.drawRect(this.rec_x, this.rec_y, 100, 100);
                graphics.drawOval(oval_x, 0, 200, 100);
                graphics.drawOval(0, this.circle_y, 100, 100);

            }

            public static void main (String[]argv){
                try {
                    AppGameContainer container = new AppGameContainer(new Rectangle("Rectangle"));
                    container.setDisplayMode(800, 600, false);
                    container.start();
                } catch (SlickException e) {
                    e.printStackTrace();
                }
            }
        }
