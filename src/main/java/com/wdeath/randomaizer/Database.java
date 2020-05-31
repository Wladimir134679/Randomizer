package com.wdeath.randomaizer;

import javax.xml.crypto.Data;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Database {

    private static Database database;

    public static Database getInstance(){
        if(database == null)
            database = new Database();
        return database;
    }

    private List<String> list;

    public Database(){
        list = new ArrayList<>();
    }

    public void addAction(String action){
        list.add(action);
    }

    public List<String> getList() {
        return list;
    }

    public void save() {
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(new File("save.txt")));

            for(String str : list){
                try {
                    dataOutputStream.writeUTF(str+"\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void load(){
        try {
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(new File("save.txt")));
            list.clear();
            while (true){
                try {
                    String str = dataInputStream.readUTF();
                    list.add(str);
                } catch (IOException e) {
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void remove(String text) {
        list.remove(text);
    }
}
