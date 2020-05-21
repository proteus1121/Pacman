/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package packman;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Артем
 */
class Display {
    public static final List<Obj> mapObjects = new ArrayList<>();
    public static final Gson GSON = new Gson();
    private Timer timer;
    private JFrame frame = new JFrame();
    private Map map = new Map();

    Display() {
        frame.setTitle("Packman!");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel dip = new JPanel();

        ClassLoader classLoader = getClass().getClassLoader();
        File mapFile = new File(Objects.requireNonNull(classLoader.getResource("map_1.json")).getFile());
//    setMap(mapFile, dip);

        try {
            JsonElement map = new JsonParser().parse(new FileReader(mapFile.getPath()));
            JsonObject jobject = map.getAsJsonObject();

            JsonObject hero = jobject.getAsJsonObject("hero");
            Hero heroObj = GSON.fromJson(hero, Hero.class);
            heroObj.setControl(frame);
            mapObjects.add(heroObj);

            JsonArray enemiesArray = jobject.getAsJsonArray("enemiesArray");
            enemiesArray.forEach(enemy ->
            {
                Obj enemyObj = GSON.fromJson(enemy.getAsJsonObject(), Enemy.class);
                mapObjects.add(enemyObj);
            });

            JsonArray mapArray = jobject.getAsJsonArray("mapArray");
            this.map.readMap(mapArray, dip);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
//    setMap(dip);

//    setMapObjects(mapObjects);

        timer = new javax.swing.Timer(800, e ->
        {
            nextStep();
            repaint(mapObjects);
        });
        timer.start();
        frame.setVisible(true);
        frame.setLayout(new GridLayout(1, 1));
        frame.add(dip);

    }

    private void nextStep() {
        mapObjects.forEach(obj -> obj.generateNextStep(map, mapObjects));

//        if (blocks[object.getX() + x][object.getY() + y].passable && !blocks[object.getX() + x][object.getY() + y].getText().equals("♕"))
//        {
//          blocks[object.getX()][object.getY()].setText("");
//          blocks[object.getX()][object.getY()].setForeground(Color.white);
//          blocks[object.getX() + x][object.getY() + y].setText("♕");
//
//          object.setX(object.getX() + x);
//          object.setY(object.getY() + y);
//        }
//        else
//        {
//          blocks[object.getX()][object.getY()].setText("");
//          blocks[object.getX()][object.getY()].setForeground(Color.white);
//          blocks[object.getX()][object.getY()].setText("♕");
//
//          object.setX(object.getX());
//          object.setY(object.getY());
//        }
    }

//  private void setMap(JPanel dip)
//  {
//    this.map.readMap(map, dip);
//  }

//  private void setMapObjects(List<Obj> mapObjects)
//  {
//    Hero hero = new Hero(1, 1);
//    hero.setControl(frame);
//    mapObjects.add(hero);
//    Obj e1 = new Enemy(7, 9);
//    mapObjects.add(e1);
//    Obj e2 = new Enemy(9, 10);
//    mapObjects.add(e2);
//    Obj e3 = new Enemy(10, 10);
//    mapObjects.add(e3);
//    Obj e4 = new Enemy(9, 9);
//    mapObjects.add(e4);
//  }

    public void repaint(List<Obj> objects) {
        int a = 0;
        Block[][] mapBlocks = map.getBlocks();
        for (int y = 0; y < 20; y++) {
            for (int i = 0; i < 20; i++) {
                if (mapBlocks[i][y].getStatus() == BlockInfo.POINT) {
                    mapBlocks[i][y].getView().setText("*");
                    a = 1;
                    mapBlocks[i][y].getView().setForeground(Color.white);
                }

                if (mapBlocks[i][y].getStatus() == BlockInfo.EMPTY) {
                    mapBlocks[i][y].getView().setText("");
                }
            }
        }
        if (a == 0) {
            timer.stop();
            JOptionPane.showMessageDialog(frame, "Игра пройдена!");
        }
        for (final Obj object : objects) {
            mapBlocks[object.getY()][object.getX()].getView().setText(object.getView());
            mapBlocks[object.getY()][object.getX()].getView().setForeground(Color.white);

            if (object.getName() == GameObject.HERO) {
                mapBlocks[object.getY()][object.getX()].getView().setForeground(Color.yellow);
            }
        }
    }
}
