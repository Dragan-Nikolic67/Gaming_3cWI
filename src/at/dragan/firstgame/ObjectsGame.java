package at.dragan.firstgame;

import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ObjectsGame extends BasicGame {
    private List<Actor> actors;
    private Damien damien;


    public ObjectsGame(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.actors = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            Rectangle rectangle = new Rectangle(random.nextInt(600), random.nextInt(600), "Left");
            this.actors.add(rectangle);


        }
        for (int i = 0; i < 10; i++) {
            Circle circle = new Circle();
            this.actors.add(circle);


        }
        for (int i = 0; i < 10; i++) {
            Ellipse ellipse = new Ellipse(random.nextInt(600), random.nextInt(600));
            this.actors.add(ellipse);
        }
        Damien damien = new Damien(10, 2, 2);
        this.damien = damien;
        this.actors.add(damien);

    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        for (Actor actor : this.actors) {
            actor.update(gameContainer, delta);
        }
    }

    @Override
    public void keyPressed(int key, char c) {
        if (key == Input.KEY_SPACE) {
            System.out.println("Shoot");
            Cannonball cb = new Cannonball(this.damien.getX(), this.damien.getY());
            this.actors.add(cb);
        }
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        for (Actor actor : this.actors) {
            actor.render(graphics);
        }
    }

    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new ObjectsGame("Rectangle"));
            container.setDisplayMode(800, 600, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
