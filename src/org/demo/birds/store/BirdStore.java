package org.demo.birds.store;

import org.demo.birds.entities.Bird;

import java.util.*;

/**
 * Отнаследоваться от AbstractBirdStore.
 *
 * Реализовать паттерн Singleton.
 */
public class BirdStore extends AbstractBirdStore {
    Map birdStore = new HashMap();

    private static BirdStore singtoneBirdStore = new BirdStore();

    private BirdStore() {
    }

    public static BirdStore getSingtoneBirdStore(){
        return singtoneBirdStore;
    }

    @Override
    public void addBird(Bird b) {
        birdStore.put(b.getName().toLowerCase(), b.getLivingArea().toLowerCase());


    }

    @Override
    public Bird searchByName(String nameToSearch) {
        Bird searchObj;
        searchObj = (Bird) birdStore.get(nameToSearch);
        return searchObj;
    }

    @Override
    public List searchByLivingArea(String livingAreaToFind) {
        List listOfBirdsByArea = new ArrayList();
        for (Object names : birdStore.keySet()) {
            if (birdStore.get(((String) names).toLowerCase()) == listOfBirdsByArea) {
                listOfBirdsByArea.add(names);
            }
        }
        return listOfBirdsByArea;
    }
}
