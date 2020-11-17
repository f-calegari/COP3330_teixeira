import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    private TaskList t_List;
    private static Scanner input = new Scanner(System.in);

    public App(){
        t_List = new TaskList();
    }

    public static void main(String[] args){
        App app = new App();
        app.readInput();
    }

    private void readInput()
    {
        int opt=0;
        while(opt!=3)
        {
            printMainMenu();
            try {
                opt = input.nextInt();
                if (opt == 1) {
                    System.out.printf("%nnew task list has been created%n");
                    listMenu();

                } else if (opt == 2) {
                    input.nextLine();
                    loadTaskList();
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
        while(opt!=8)
        {
            printListMenu();
            try {
                opt = input.nextInt();
                if (opt == 1) {
                    t_List.viewList();
                } else if (opt == 2) {
                    input.nextLine();
                    getTaskItem();
                } else if (opt == 3) {
                    input.nextLine();
                    t_List.viewList();
                    getEditTaskItem();
                } else if (opt == 4) {
                    input.nextLine();
                    t_List.viewList();
                    removeTaskItem();
                    input.nextLine();
                } else if (opt == 5) {
                    input.nextLine();
                    t_List.viewUncompletedList();
                    markTaskItemCompleted();
                    input.nextLine();
                } else if (opt == 6) {
                    input.nextLine();
                    t_List.viewCompletedList();
                    unmarkTaskItemCompleted();
                    input.nextLine();
                } else if (opt == 7) {
                    input.nextLine();
                    writeTaskList();
                }
                else if (opt == 8) {
                    t_List.clearList();
                    break;
                }
            }catch (Exception e){
                System.out.printf("%nChoose an option between 1-8!%n");
                input.nextLine();
            }

        }
    }

    private void writeTaskList() {
        t_List.writeList(getTaskListNameToSave());
    }

    private void loadTaskList() {
        t_List.readList(getTaskListNameToLoad());
    }

    private void markTaskItemCompleted() {
            try {
                int index = getTaskIndextoComplete();
                t_List.markItemCompleted(index);
            } catch (IndexOutOfBoundsException ex) {
                System.out.println("Warning: Please select a valid task to mark");
            } catch (InputMismatchException ex){
                System.out.println("Warning: Please select a valid task to mark!");
            }

    }

    private void unmarkTaskItemCompleted() {
            try {
                int index = getTaskIndextoUncomplete();
                t_List.markItemUncompleted(index);
            } catch (IndexOutOfBoundsException ex) {
                System.out.println("Warning: Please select a valid task to unmark");
            } catch (InputMismatchException ex){
                System.out.println("Warning: Please select a valid task to unmark!");
            }

    }

    private void removeTaskItem() {
         try {
             if(t_List.taskListIsEmpty()) {
                 System.out.printf("%nTask list is empty, nothing to remove!");
             }else {
                 int index = getTaskIndextoRemove();
                 t_List.removeItem(index);
             }
            } catch (IndexOutOfBoundsException ex) {
                System.out.println("Warning: Please select a valid task to remove");
            } catch (InputMismatchException ex){
                System.out.println("Warning: Please select a valid task to remove!");
            }

    }

    private void getEditTaskItem() {
            try {
                int index = getTaskIndex();
                input.nextLine();
                String title = getEditTaskTitle(index);
                String description = getEditTaskDescription(index);
                String due_date = getEditTaskDueDate(index);
                t_List.editItem(title, description, due_date, index);
            } catch (IllegalArgumentException ex) {
                System.out.println("Warning: invalid name(Must be more than 1 character) or due date(YYYY-MM-DD)");

            } catch (IndexOutOfBoundsException | InputMismatchException ex) {
                System.out.println("Warning: Please select a valid task to edit");
                input.nextLine();
            }

    }

    private void getTaskItem(){

        while(true) {
            try {
                String title = getTaskTitle();
                String description = getTaskDescription();
                String due_date = getTaskDueDate();
                TaskItem taskItem = new TaskItem(title, description, due_date);
                t_List.addTaskItem(taskItem);
                break;
            } catch (IllegalArgumentException ex) {
                System.out.println("Warning: invalid name(Must be more than 1 character) or due date(YYYY-MM-DD)");
            }
        }

    }

    private String getTaskListNameToSave(){
        System.out.printf("Enter the filename to save as: ");
        return input.nextLine();
    }

    private String getTaskListNameToLoad(){
        System.out.printf("Enter the filename to load: ");
        return input.nextLine();
    }

    private String getTaskDueDate() {
        System.out.printf("Task due date (YYYY-MM-DD): ");
        return input.nextLine();
    }

    private String getTaskDescription() {
        System.out.printf("Task description: ");
        return input.nextLine();
    }

    private String getTaskTitle() {
        System.out.printf("%nTask title(Must be more than 1 character): ");
        return input.nextLine();
    }

    private int getTaskIndex() {
        System.out.printf("%nWhich task will you edit? ");
        return input.nextInt();
    }

    private int getTaskIndextoRemove() {
        System.out.printf("%nWhich task will you remove? ");
        return input.nextInt();
    }

    private int getTaskIndextoComplete() {
        System.out.printf("%nWhich task will you mark as completed? ");
        return input.nextInt();
    }

    private int getTaskIndextoUncomplete() {
        System.out.printf("%nWhich task will you unmark as completed? ");
        return input.nextInt();
    }

    private String getEditTaskDueDate(int index) {
        System.out.printf("Enter a new task due date (YYYY-MM-DD) for task " + index + ":");
        return input.nextLine();
    }

    private String getEditTaskDescription(int index) {
        System.out.printf("Enter a new description for task " + index + ":");
        return input.nextLine();
    }

    private String getEditTaskTitle(int index) {
        System.out.printf("%nEnter a new title for task " + index + ":");
        return input.nextLine();
    }

    private void printMainMenu(){
        System.out.printf("%nMain Menu%n");
        System.out.printf("---------%n%n");
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
        System.out.println("5- mark an item as completed");
        System.out.println("6- unmark an item as completed");
        System.out.println("7- save current list");
        System.out.printf("8- Quit to main menu.%n%n");
        System.out.print(".: Please select your option: ");
    }
}