import org.junit.Assert;
import org.junit.Test;
import util.BookList;
import util.Contact;
import util.ContactBook;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anton on 03.03.2017.
 */
public class ContactTest extends Assert {

    @Test
    public  void testWrite() throws Exception {
        Contact contact1 = new Contact("Anton", "iphone", "samsung", "nokia");
        Contact contact2 = new Contact("Anton", "iphone", "samsung", "nokia");
        Contact contact3 = new Contact("Anton", "iphone", "samsung", "nokia");
        BookList bookList = new BookList();
        bookList.getContactList().add(contact1);
        bookList.getContactList().add(contact2);
        bookList.getContactList().add(contact3);



        bookList.save("result.txt", bookList.getContactList());
    }

    @Test
    public void testRead() throws Exception{
        BookList bookList = new BookList();
        bookList.load("result.txt");
        System.out.println(bookList.getContactList().get(1).getName());
        //List<Contact> contactList
    }
}
