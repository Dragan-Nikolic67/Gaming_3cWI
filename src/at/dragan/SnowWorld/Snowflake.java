package at.dragan.SnowWorld;
import org.newdawn.slick.Graphics;

import java.util.Random;
public class Snowflake implements Actor {
    public enum SIZE {Large, Medium, Small};
    private int x,y,speed,size;
    private Random random;
    public Snowflake (SIZE size){
        this.random = new Random();

        if (size == SIZE.Large){
            this.size = 12;
            this.speed = 2;
        }
        if (size == SIZE.Medium){
            this.size = 8;
            this.speed = 5;
        }
        if (size == SIZE.Small){
            this.size = 4;
            this.speed = 8;
        }

        setRandomPosition();
    }

    private void setRandomPosition(){
        this.x = this.random.nextInt(800);
        this.y = this.random.nextInt(600) - 600;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.fillOval(this.x, this.y, this.size, this.size);
    }
    public void update (int delta){
        this.y += delta/this.speed;
        if (this.y>600){
            setRandomPosition();
        }
    }
}
