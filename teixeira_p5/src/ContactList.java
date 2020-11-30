import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ContactList extends ItemList {

    public ContactList() {
       super();
    }

    public void viewList() {
        int i;
        System.out.printf("%nCurrent Contacts%n");
        System.out.printf("----------------%n%n");
        if (this.ListIsEmpty()) {
            System.out.printf("empty list%n%n");
        } else {
            for (i = 0; i < this.itemList.size(); i++) {
                System.out.printf(i + " - " + this.itemList.get(i) + "%n");
            }
            System.out.printf("%n");
        }
    }

    public void editItem(String first_name, String last_name, String phone_number, String email, int index) {
        try {
            this.getItem(index).setFirstName(first_name);
            this.getItem(index).setLastName(last_name);
            this.getItem(index).setPhoneNumber(phone_number);
            this.getItem(index).setEmail(email);
        }catch (IndexOutOfBoundsException ex) {
            throw new IndexOutOfBoundsException("Please select a valid contact to edit");
        }catch (InputMismatchException ex) {
            throw new InputMismatchException("Please select a valid contact to edit!");
        }
    }

    public ContactItem getItem(int index) {
        try {
            return (ContactItem) this.itemList.get(index);
        } catch (IndexOutOfBoundsException ex) {
            throw new IndexOutOfBoundsException("Please select a valid item!");
        }
    }

    public void writeList(String filename) {
        try(Formatter output = new Formatter(filename)) {
            for(int i = 0; i < this.itemList.size(); i++) {
                ContactItem item = (ContactItem) this.itemList.get(i);
                output.format("%s;%s;%s;%s;", item.getFirst_name(), item.getLast_name(), item.getPhone_number(), item.getEmail());
            }
            System.out.printf("%nList has been saved.%n");

        } catch (FileNotFoundException ex) {
            System.out.printf("%nFile not found!%n");
        } catch (Exception ex) {
            System.out.printf("%nError saving file, please try again!%n");
        }
    }

    public void readList(String filename) {
        try {
            Scanner scanner = new Scanner(Paths.get(filename));
            scanner.useDelimiter(";|\n");
            while (scanner.hasNext()) {
                String first_name = scanner.next();
                String last_name = scanner.next();
                String phone_number = scanner.next();
                String email = scanner.next();
                ContactItem Item = new ContactItem(first_name, last_name, phone_number, email);
                this.itemList.add(Item);
            }
        } catch (FileNotFoundException e) {
            System.out.printf("%nFile not found, please try again!%n");
        } catch (Exception e) {
            System.out.printf("%nError loading file, please try again!%n");
        }
    }

}