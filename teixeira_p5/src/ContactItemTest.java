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
        assertThrows(IllegalArgumentException.class, () -> c.setFirstName(""));
        ContactList cc = new ContactList();
        cc.addListItem(c);
        assertThrows(IllegalArgumentException.class, () -> cc.editItem("","",
                "", "",0));
    }

    @Test
    public void editingSucceedsWithBlankEmail() {
        ContactItem c = new ContactItem("first","last","4073215478", "test@test.com");
        assertDoesNotThrow(() -> c.setEmail(""));
    }

    @Test
    public void editingSucceedsWithBlankFirstName() {
        ContactItem c = new ContactItem("first","last","4073215478", "test@test.com");
        assertDoesNotThrow(() -> c.setFirstName(""));
    }

    @Test
    public void editingSucceedsWithBlankLastName() {
        ContactItem c = new ContactItem("first","last","4073215478", "test@test.com");
        assertDoesNotThrow(() -> c.setLastName(""));
    }

    @Test
    public void editingSucceedsWithBlankPhone() {
        ContactItem c = new ContactItem("first","last","4073215478", "test@test.com");
        assertDoesNotThrow(() -> c.setPhoneNumber(""));
    }

    @Test
    public void editingSucceedsWithNonBlankValues() {
        ContactItem item = new ContactItem("first","last","4073215478", "test@test.com");
        ContactList c = new ContactList();
        c.addListItem(item);
        assertDoesNotThrow(() -> c.editItem("Changed","Changed","321-123-1452", "changed@newmail.com",0));
    }

    @Test
    public void testToString(){
        ContactItem c = new ContactItem("first","last","4073215478", "test@test.com");
        assertEquals("Name: first last%n" +
                "Phone: 4073215478%n" +
                "Email: test@test.com", c.toString());
    }

}