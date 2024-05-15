package at.dragan.SnowWorld;
import org.newdawn.slick.Graphics;

import java.util.Random;
public class Snowflake implements Actor {
    public enum SIZE {Large, Medium, Small};
    private int x,y,size;
    private double speed;
    private Random random;
    public Snowflake (SIZE size){
        this.random = new Random();

        if (size == SIZE.Large){
            this.size = 13;
            this.speed =1.5;
        }
        if (size == SIZE.Medium){
            this.size = 8;
            this.speed = 1;
        }
        if (size == SIZE.Small){
            this.size = 4;
            this.speed = 0.5;
        }

        setRandomPosition();
    }

    private void setRandomPosition(){
        this.x = this.random.nextInt(800);
        this.y = this.random.nextInt(600) - 900;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.fillOval(this.x, this.y, this.size, this.size);
    }
    public void update (int delta){
        this.y += (double) delta/this.speed;
        if (this.y>600){
            setRandomPosition();
        }
    }
}
