package org.example.repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Storage<T> implements Repository<T> {

    private String fileName;

    public Storage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public boolean save(T entity) {
        List<T> entities = this.load();
        if (entities == null) {
            entities = new ArrayList<>();
        }
        entities.add(entity);
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(entities);
            objectOutputStream.flush();
            return true;
        } catch (IOException e) {
            System.out.println("Ошибка сохранения: " + e.toString());
            return false;
        }
    }

    @Override
    public void saveAll(List<T> entities) {
        if (entities == null) {
            entities = new ArrayList<>();
        }
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(entities);
            objectOutputStream.flush();
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении всех объектов: " + e.toString());
        }
    }

    @Override
    public List<T> load() {
        try (FileInputStream fileInputStream = new FileInputStream(fileName);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            return (List<T>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка при загрузке: " + e.toString());
        }
        return new ArrayList<>();
    }
}
