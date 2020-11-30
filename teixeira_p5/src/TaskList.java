import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TaskList extends ItemList{

    public TaskList() {
        super();
    }

    public void viewList() {
        int i;
        System.out.printf("%nCurrent Tasks%n");
        System.out.printf("-------------%n%n");
        if (this.ListIsEmpty()) {
            System.out.printf("empty list%n%n");
        } else {
            for (i = 0; i < this.itemList.size(); i++) {
                System.out.printf(i + " - " + printMarkedCompleted(this.getItem(i).isItem_completed()) + this.itemList.get(i));
            }
            System.out.printf("%n");
        }
    }

    public void viewUncompletedList() {
        int i;
        System.out.printf("%nUncompleted Tasks%n");
        System.out.printf("-----------------%n%n");
        if (this.ListIsEmpty()) {
            System.out.printf("empty list%n%n");
        } else {
            for (i = 0; i < this.itemList.size(); i++) {
                if (!this.getItem(i).isItem_completed()) {
                    System.out.printf(i + " - " + printMarkedCompleted(this.getItem(i).isItem_completed()) + this.itemList.get(i));
                }
            }
            System.out.printf("%n");
        }
    }

    public void viewCompletedList() {
        int i;
        System.out.printf("%nCompleted Tasks%n");
        System.out.printf("---------------%n%n");
        if (this.ListIsEmpty()) {
            System.out.printf("empty list%n%n");
        } else {
            for (i = 0; i < this.itemList.size(); i++) {
                if (this.getItem(i).isItem_completed()) {
                    System.out.printf(i + " - " + printMarkedCompleted((Boolean) this.getItem(i).isItem_completed()) + this.itemList.get(i));
                }
            }
            System.out.printf("%n");
        }
    }

    public void editItem(String title, String description, String due_date, int index) {
        try {
            this.getItem(index).setTitle(title);
            this.getItem(index).setDescription(description);
            this.getItem(index).setDue_date(due_date);
            }catch (IndexOutOfBoundsException ex) {
                throw new IndexOutOfBoundsException("Please select a valid task to edit");
            }catch (InputMismatchException ex) {
                throw new InputMismatchException("Please select a valid task to edit!");
        }
    }

    public TaskItem getItem(int index) {
            try {
                return (TaskItem) this.itemList.get(index);
            } catch (IndexOutOfBoundsException ex) {
                throw new IndexOutOfBoundsException("Please select a valid item!");
            }
    }

    public String printMarkedCompleted(boolean item_completed) {
        if (item_completed) {
            return "*** ";
        } else
            return "";
    }

    public void markItemCompleted(int index) {
       try {
                this.getItem(index).setItem_completed(true);
            } catch (IndexOutOfBoundsException ex) {
                throw new IndexOutOfBoundsException("Please select a valid task to mark as completed");
            } catch (InputMismatchException ex) {
                throw new InputMismatchException("Please select a valid task to mark as completed!");
            }
    }

    public void markItemUncompleted(int index) {
            try {
                this.getItem(index).setItem_completed(false);
                }catch(IndexOutOfBoundsException ex){
            throw new IndexOutOfBoundsException("Please select a valid task to mark as completed");
            }catch(InputMismatchException ex){
            throw new InputMismatchException("Please select a valid task to mark as completed!");
        }
    }

    public void writeList(String filename) {
        try(Formatter output = new Formatter(filename)) {
            for(int i = 0; i < this.itemList.size(); i++) {
                TaskItem item = (TaskItem) this.itemList.get(i);
                output.format("%s;%s;%s;%s;", item.getTitle(), item.getDescription(), item.getDue_date(), item.isItem_completed());
            }
            System.out.printf("%nTask list has been saved.%n");

        } catch (FileNotFoundException ex) {
            System.out.printf("%nFile not found!%n");
        } catch (Exception ex) {
            System.out.printf("%nError saving file, please try again!%n");
        }
    }

    public void readList(String filename){
        try {
            Scanner scanner = new Scanner(Paths.get(filename));
            scanner.useDelimiter(";|\n");
            while (scanner.hasNext()) {
                String title = scanner.next();
                String description = scanner.next();
                String due_date = scanner.next();
                String completed = scanner.next();
                TaskItem Item = new TaskItem(title, description, due_date, completed);
                this.itemList.add(Item);
            }
        } catch (FileNotFoundException e) {
            System.out.printf("%nFile not found, please try again!%n");
        } catch (Exception e) {
            System.out.printf("%nError loading file, please try again!%n");
        }

    }
}