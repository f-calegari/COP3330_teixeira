import java.util.Scanner;

public class App {

    private static Scanner input = new Scanner(System.in);

    public App(){

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
                    TaskApp task_app = new TaskApp();
                    task_app.readInput();


                } else if (opt == 2) {
                    ContactApp contact_app = new ContactApp();
                    contact_app.readInput();
                }
            }catch (Exception e){
                System.out.printf("%nChoose an option between 1-3!%n");
            }
            input.nextLine();
        }

    }

    private void printMainMenu(){
        System.out.printf("%nMain Menu%n");
        System.out.printf("---------%n%n");
        System.out.println("1- Task List");
        System.out.println("2- Contact List");
        System.out.printf("3- Quit.%n%n");
        System.out.print(".: Please select your option: ");
    }
}