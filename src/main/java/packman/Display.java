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
    private Map map;
    private Hero heroObj;

    Display() {
        frame.setTitle("Packman!");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel dip = new JPanel();

        ClassLoader classLoader = getClass().getClassLoader();
        File mapFile = new File(Objects.requireNonNull(classLoader.getResource("map_1.json")).getFile());

        try {
            JsonElement map = new JsonParser().parse(new FileReader(mapFile.getPath()));
            JsonObject jobject = map.getAsJsonObject();

            JsonObject hero = jobject.getAsJsonObject("hero");
            heroObj = GSON.fromJson(hero, Hero.class);
            heroObj.setControl(frame);
            mapObjects.add(heroObj);

            JsonArray enemiesArray = jobject.getAsJsonArray("enemiesArray");
            enemiesArray.forEach(enemy ->
            {
                Obj enemyObj = GSON.fromJson(enemy.getAsJsonObject(), Enemy.class);
                mapObjects.add(enemyObj);
            });

            JsonArray mapArray = jobject.getAsJsonArray("mapArray");
            this.map = new Map(mapArray, dip);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        timer = new javax.swing.Timer(200, e ->
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
    }

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
        for (final Obj object : objects) {
            mapBlocks[object.getY()][object.getX()].getView().setText(object.getView());
            mapBlocks[object.getY()][object.getX()].getView().setForeground(Color.white);

            if (object.getType() == GameObject.HERO) {
                mapBlocks[object.getY()][object.getX()].getView().setForeground(Color.yellow);
                if (mapBlocks[object.getY()][object.getX()].getStatus() == BlockInfo.POINT) {
                    mapBlocks[object.getY()][object.getX()].setStatus(BlockInfo.EMPTY);
                }
            }
            else if (object.getType() == GameObject.ENEMY) {
                if (object.getX() == heroObj.getX() &&
                        object.getY() == heroObj.getY()) {
                    timer.stop();
                    JOptionPane.showMessageDialog(frame, "GAME OVER!");
                }
            }
        }
        if (a == 0) {
            timer.stop();
            JOptionPane.showMessageDialog(frame, "GAME COMPLETED!");
        }
    }
}
