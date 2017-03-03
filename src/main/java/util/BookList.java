package util;

import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anton on 03.03.2017.
 */
public class BookList implements Serializable, ContactBook {

    private List<Contact> contactList = new ArrayList<>();

    public List<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }

    @Override
    public void save(String fileName, List<Contact> list) {
        try (ObjectOutputStream s = new ObjectOutputStream(new FileOutputStream(fileName))) {
            s.writeObject(contactList);
        } catch (java.io.IOException e) {
            e.printStackTrace();
            System.out.println("ioExeption");
        }

    }

    public void saveToJson(String fileName, List<Contact> list) {
        Gson gson = new Gson();
        String s = gson.toJson(contactList);
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(s);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Contact> load(String fileName) {
        try (ObjectInputStream s = new ObjectInputStream(new FileInputStream(fileName))) {
            contactList = (ArrayList<Contact>) s.readObject();
            return contactList;

        } catch (java.io.FileNotFoundException e) {
            System.out.print("file not found");
            return contactList;
        } catch (java.io.IOException e) {
            System.out.print("ioexeption");
            return contactList;
        } catch (java.lang.ClassNotFoundException e) {
            System.out.print("class not found");
            return contactList;
        }
    }

    public List<Contact> loadFromJson(String fileName) {

    }

    @Override
    public List<Contact> search(String start) {
        return null;
    }

}
