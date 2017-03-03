package util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anton on 03.03.2017.
 */
public class BookList implements Serializable, ContactBook {

    public List<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }

    private List<Contact> contactList = new ArrayList<>();

    @Override
    public void save(String fileName, List<Contact> list) {
        try (ObjectOutputStream s = new ObjectOutputStream(new FileOutputStream(fileName))) {
            s.writeObject(contactList);
        } catch (java.io.IOException e) {
            System.out.println("ioExeption");
        }

    }

    @Override
    public List<Contact> load(String fileName) {
        try (ObjectInputStream s = new ObjectInputStream(new FileInputStream(fileName))) {
            return (ArrayList<Contact>) s.readObject();

        } catch (java.io.FileNotFoundException e) {
            System.out.print("file not found");
            return contactList;
        }catch (java.io.IOException e){
            System.out.print("ioexeption");
            return contactList;
        }catch (java.lang.ClassNotFoundException e){
            System.out.print("class not found");
            return contactList;
        }

    }

    @Override
    public List<Contact> search(String start) {
        return null;
    }

}
