package org.demo.birds.store;

import org.demo.birds.entities.Bird;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Отнаследоваться от AbstractBirdStore.
 * <p>
 * Реализовать паттерн Singleton.
 */

public class BirdStore extends AbstractBirdStore {
     private Map birdStore = new HashMap();

    private static BirdStore singltoneBirdStore = new BirdStore();

    private BirdStore() {
    }

    public static BirdStore getSingltoneBirdStore() {
        return singltoneBirdStore;
    }

    @Override
    public void addBird(Bird b) {
        birdStore.put(b, b.getLivingArea());


    }

    @Override
    public Bird searchByName(String nameToSearch) {
        Bird searchBird = null;
        for (Object b : birdStore.keySet()) {
            if (
                    ((Bird) b).getName().equals(nameToSearch)) {
                searchBird = (Bird) b;
            }
        }
        return  searchBird;


    }

    @Override
    public List searchByLivingArea(String livingAreaToFind) {
        List listOfBirdsByArea = new ArrayList();
        for (Object obj : birdStore.keySet()) {
            if (((Bird) obj).getLivingArea().equals(livingAreaToFind)) {
                listOfBirdsByArea.add(obj);
            }
        }
        return listOfBirdsByArea;

    }
}
