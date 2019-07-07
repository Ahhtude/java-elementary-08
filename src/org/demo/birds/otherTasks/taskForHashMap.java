package org.demo.birds.otherTasks;

import java.util.HashMap;
import java.util.Map;

public class taskForHashMap {
    public static int INITIAL_SIZE= 10;

    public static Map<String,String> taskForHashMap(){
        Map<String,String> map = new HashMap<>();
        for (int i = 0; i < INITIAL_SIZE ; i++){
            map.put("Key text"+i,"Value text"+i);
        }
        return map;
    }
    public static void entrySetfromMAP(){
        for (Map.Entry entry : taskForHashMap().entrySet()){
            System.out.println("Key is - " + entry.getKey() + " , Value is - " + entry.getValue());
        }
    }
    public static void keySetFromMAP(){
        for (String keys : taskForHashMap().keySet()){
            System.out.println("Key is - "+ keys);
        }
    }

    public static void main(String[] args) {
        keySetFromMAP();
        entrySetfromMAP();
    }


}
