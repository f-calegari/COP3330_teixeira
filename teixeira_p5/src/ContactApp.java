import java.util.InputMismatchException;
import java.util.Scanner;

public class ContactApp {

    private ContactList c_List;
    private static Scanner input = new Scanner(System.in);

    public ContactApp(){
        c_List = new ContactList();

    }

    void readInput()
    {
        int opt=0;
        while(opt!=3)
        {
            printMainMenu();
            try {
                opt = input.nextInt();
                if (opt == 1) {
                    System.out.printf("%nnew list has been created%n");
                    listMenu();

                } else if (opt == 2) {
                    input.nextLine();
                    loadContactList();
                    listMenu();
                }
            }catch (Exception e){
                System.out.printf("%nChoose an option between 1-3!%n");
            }
            input.nextLine();
        }

    }

    private void listMenu() {
        int opt=0;
        while(opt!=6)
        {
            printListMenu();
            try {
                opt = input.nextInt();
                if (opt == 1) {
                    c_List.viewList();
                } else if (opt == 2) {
                    input.nextLine();
                    getContactItem();
                } else if (opt == 3) {
                    input.nextLine();
                    c_List.viewList();
                    getEditContactItem();
                } else if (opt == 4) {
                    input.nextLine();
                    c_List.viewList();
                    removeContactItem();
                    input.nextLine();
                } else if (opt == 5) {
                    input.nextLine();
                    writeContactList();
                }
                else if (opt == 6) {
                    c_List.clearList();
                    break;
                }
            }catch (Exception e){
                System.out.printf("%nChoose an option between 1-6!%n");
                input.nextLine();
            }

        }
    }

    private void writeContactList() {
        c_List.writeList(getListNameToSave());
    }

    private void loadContactList() {
        c_List.readList(getListNameToLoad());
    }

    private void removeContactItem() {
        try {
            if(c_List.ListIsEmpty()) {
                System.out.printf("%nContact list is empty, nothing to remove!");
            }else {
                int index = getIndextoRemove();
                c_List.removeItem(index);
            }
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Warning: Please select a valid contact to remove");
        } catch (InputMismatchException ex){
            System.out.println("Warning: Please select a valid contact to remove!");
        }

    }

    private void getEditContactItem() {
        try {
            int index = getContactIndex();
            c_List.isIndexValid(index);
            input.nextLine();
            String first_name = getEditFirstName(index);
            String last_name = getEditLastName(index);
            String phone_number = getEditPhone(index);
            String email = getEditEmail(index);
            c_List.editItem(first_name,last_name,phone_number,email,index);
        } catch (IllegalArgumentException ex) {
            System.out.println("Invalid entry, please try again!!!");

        } catch (IndexOutOfBoundsException | InputMismatchException ex) {
            System.out.println("Warning: Please select a valid contact to edit");
            input.nextLine();
        }

    }

    private void getContactItem(){

        while(true) {
            try {
                String first_name = getContactFirstName();
                String las_name = getContactLastName();
                String phone_number = getContactPhone();
                String email = getContactEmail();
                ContactItem contactItem = new ContactItem(first_name,las_name,phone_number,email);
                c_List.addListItem(contactItem);
                break;
            }catch (InputMismatchException ex){
                System.out.println("Invalid email! Please try again");
            }catch (ContactItem.InvalidPhoneException ex){
                System.out.println("Invalid Phone number! Please try again");
            }catch (IllegalArgumentException ex) {
                System.out.println("A contact needs ate least one value entered !!");
            }
        }

    }

    private String getListNameToSave(){
        System.out.printf("Enter the filename to save as: ");
        return input.nextLine();
    }

    private String getListNameToLoad(){
        System.out.printf("Enter the filename to load: ");
        return input.nextLine();
    }

    private String getContactEmail() {
        System.out.printf("Email address (email@email.com): ");
        return input.nextLine();
    }

    private String getContactPhone() {
        System.out.printf("Phone number (xxx-xxx-xxxx or xxxxxxxxxx): ");
        return input.nextLine();
    }

    private String getContactLastName() {
        System.out.printf("Last name: ");
        return input.nextLine();
    }

    private String getContactFirstName() {
        System.out.printf("%nFirst name: ");
        return input.nextLine();
    }

    private int getContactIndex() {
        System.out.printf("%nWhich contact will you edit? ");
        return input.nextInt();
    }

    private int getIndextoRemove() {
        System.out.printf("%nWhich contact will you remove? ");
        return input.nextInt();
    }


    private String getEditEmail(int index) {
        System.out.printf("Enter a new email address (x@y.z) for contact " + index + ":");
        return input.nextLine();
    }

    private String getEditPhone(int index) {
        System.out.printf("Enter a new phone number (xxx-xxx-xxxx or xxxxxxxxxx) for contact " + index + ":");
        return input.nextLine();
    }

    private String getEditLastName(int index) {
        System.out.printf("Enter a new last name for contact " + index + ":");
        return input.nextLine();
    }

    private String getEditFirstName(int index) {
        System.out.printf("%nEnter a new first name for contact " + index + ":");
        return input.nextLine();
    }

    private void printMainMenu(){
        System.out.printf("%nContact List Menu%n");
        System.out.printf("-----------------%n%n");
        System.out.println("1- Create a new list");
        System.out.println("2- Load an existing list");
        System.out.printf("3- Quit.%n%n");
        System.out.print(".: Please select your option: ");
    }

    private void printListMenu(){
        System.out.printf("%nList Operation Menu%n");
        System.out.printf("--------------------%n%n");
        System.out.println("1- view list");
        System.out.println("2- add an item");
        System.out.println("3- edit an item");
        System.out.println("4- remove an item");
        System.out.println("5- save current list");
        System.out.printf("6- Quit to main menu.%n%n");
        System.out.print(".: Please select your option: ");
    }
}