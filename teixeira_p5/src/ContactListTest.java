import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactListTest {

    @Test
    public void addingItemsIncreasesSize(){
        ContactItem item = new ContactItem("first","last","4071234567","test@email.com");
        ContactList c = new ContactList();
        c.addListItem(item);
        assertEquals(1,c.getSize());
        c.addListItem(item);
        assertEquals(2,c.getSize());
    }

    @Test
    public void removingItemsDecreasesSize(){
        ContactItem item = new ContactItem("first","last","4071234567","test@email.com");
        ContactList c = new ContactList();
        c.addListItem(item);
        c.addListItem(item);
        assertEquals(2,c.getSize());
        c.removeItem(1);
        assertEquals(1,c.getSize());
    }

    @Test
    public void removingItemsFailsWithInvalidIndex(){
        ContactItem item = new ContactItem("first","last","4071234567","test@email.com");
        ContactList c = new ContactList();
        c.addListItem(item);
        c.addListItem(item);
        c.addListItem(item);
        assertThrows(IndexOutOfBoundsException.class, () -> c.removeItem(10));
    }

    @Test
    public void editingSucceedsWithNonBlankValues(){
        ContactItem item = new ContactItem("first","last","4071234567","test@email.com");
        ContactList c = new ContactList();
        c.addListItem(item);
        c.editItem("John","Doe","3214567845","john@gmail.com",0);
        assertEquals("John", item.getFirst_name());
        assertEquals("Doe", item.getLast_name());
        assertEquals("3214567845", item.getPhone_number());
        assertEquals("john@gmail.com", item.getEmail());
    }

    @Test
    public void editingItemsFailsWithAllBlankValues(){
        ContactItem item = new ContactItem("first","last","4071234567","test@email.com");
        ContactList  t = new ContactList();
        t.addListItem(item);
        assertThrows(IllegalArgumentException.class, () -> t.editItem("", "","","",0));
    }

    @Test
    public void editingItemsFailsWithInvalidIndex(){
        ContactItem item = new ContactItem("first","last","4071234567","test@email.com");
        ContactList  t = new ContactList();
        t.addListItem(item);
        assertThrows(IndexOutOfBoundsException.class, () -> t.editItem("", "","","",10));
    }

    @Test
    public void editingSucceedsWithBlankFirstName(){
        ContactItem item = new ContactItem("first","last","4071234567","test@email.com");
        ContactList  t = new ContactList();
        t.addListItem(item);
        assertDoesNotThrow(() -> t.editItem("", "Doe","1234567890","john@gmail.com",0));
    }

    @Test
    public void editingSucceedsWithBlankLastName(){
        ContactItem item = new ContactItem("first","last","4071234567","test@email.com");
        ContactList  t = new ContactList();
        t.addListItem(item);
        assertDoesNotThrow(() -> t.editItem("John", "","1234567890","john@gmail.com",0));
    }

    @Test
    public void editingSucceedsWithBlankPhone(){
        ContactItem item = new ContactItem("first","last","4071234567","test@email.com");
        ContactList  t = new ContactList();
        t.addListItem(item);
        assertDoesNotThrow(() -> t.editItem("John", "Doe","","john@gmail.com",0));
    }

    @Test
    public void newListIsEmpty(){
        ContactList t = new ContactList();
        assertTrue(t.ListIsEmpty());
    }

    @Test
    public void savedTaskListCanBeLoaded(){
        ContactList c = new ContactList();
        String filename = "clist.txt"; // must have valid clist.txt list file to test
        assertDoesNotThrow(() -> c.readList(filename));
    }
}