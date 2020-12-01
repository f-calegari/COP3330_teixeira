import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactItemTest {

    @Test
    public void creationFailsWithAllBlankValues() {
        assertThrows(IllegalArgumentException.class, () -> new ContactItem("", "", "", ""));
    }

    @Test
    public void creationSucceedsWithBlankEmail() {
        assertDoesNotThrow(() -> new ContactItem("first","last","4073215478", ""));
    }

    @Test
    public void creationSucceedsWithBlankFirstName() {
        assertDoesNotThrow(() -> new ContactItem("","last","4073215478", "test@test.com"));
    }

    @Test
    public void creationSucceedsWithBlankLastName() {
        assertDoesNotThrow(() -> new ContactItem("first","","4073215478", "test@test.com"));
    }

    @Test
    public void creationSucceedsWithBlankPhone() {
        assertDoesNotThrow(() -> new ContactItem("first","last","", "test@test.com"));
    }

    @Test
    public void creationSucceedsWithNonBlankValues() {
        assertDoesNotThrow(() -> new ContactItem("first","last","4073215478", "test@test.com"));
    }

    @Test
    public void editingFailsWithAllBlankValues(){
        ContactItem c = new ContactItem("first","","", "");
        assertThrows(IllegalArgumentException.class, () -> c.Edit("", "", "", ""));
        ContactList cc = new ContactList();
        cc.addListItem(c);
        assertThrows(IllegalArgumentException.class, () -> cc.editItem("","",
                "", "",0));
    }

    @Test
    public void editingSucceedsWithBlankEmail() {
        ContactItem c = new ContactItem("first","last","4073215478", "test@test.com");
        assertDoesNotThrow(() -> c.Edit("first","last","4073215478", ""));
    }

    @Test
    public void editingSucceedsWithBlankFirstName() {
        ContactItem c = new ContactItem("first","last","4073215478", "test@test.com");
        assertDoesNotThrow(() -> c.Edit("","last","4073215478", "test@test.com"));
    }

    @Test
    public void editingSucceedsWithBlankLastName() {
        ContactItem c = new ContactItem("first","last","4073215478", "test@test.com");
        assertDoesNotThrow(() -> c.Edit("first","","4073215478", "test@test.com"));
    }

    @Test
    public void editingSucceedsWithBlankPhone() {
        ContactItem c = new ContactItem("first","last","4073215478", "test@test.com");
        assertDoesNotThrow(() -> c.Edit("first","last","", "test@test.com"));
    }

    @Test
    public void editingSucceedsWithNonBlankValues() {
        ContactItem item = new ContactItem("first","last","4073215478", "test@test.com");
        ContactList c = new ContactList();
        assertDoesNotThrow(() -> item.Edit("John","Doe","407-123-1245", "email@email.com"));
        c.addListItem(item);
        assertDoesNotThrow(() -> c.editItem("Changed","Changed","321-123-1452", "changed@newmail.com",0));
    }

    @Test
    public void editingSucceedsWithOnlyPhone() {
        ContactItem item = new ContactItem("first","last","4073215478", "test@test.com");
        ContactList c = new ContactList();
        c.addListItem(item);
        assertDoesNotThrow(() -> c.editItem("","","321-123-1452", "",0));
    }

    @Test
    public void editingSucceedsWithOnlyEmail() {
        ContactItem item = new ContactItem("first","last","4073215478", "test@test.com");
        ContactList c = new ContactList();
        c.addListItem(item);
        assertDoesNotThrow(() -> c.editItem("","","", "changed@newmail.com",0));
    }

    @Test
    public void testToString(){
        ContactItem c = new ContactItem("first","last","4073215478", "test@test.com");
        assertEquals("Name: first last%n" +
                "Phone: 4073215478%n" +
                "Email: test@test.com", c.toString());
    }

}