import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TaskItem {

    private String title;
    private String description;
    private String due_date;
    private boolean item_completed;

    public TaskItem(String title, String description, String due_date){

        if(isTitleValid(title)) {
            this.title = title;
        }
        else {
            throw new IllegalArgumentException("Title is invalid; must be at least 1 character long");
        }
        if(isDueDateValid(due_date)){
            this.due_date=due_date;
        }
        else{
            throw new IllegalArgumentException("Date is invalid; must be YYYY-MM-DD");
        }

        this.description = description;
        this.item_completed=false;
    }

    public TaskItem(String title, String description, String due_date, String completed){

        if(isTitleValid(title)) {
            this.title = title;
        }
        else {
            throw new IllegalArgumentException("Title is invalid; must be at least 1 character long");
        }
        if(isDueDateValid(due_date)){
            this.due_date=due_date;
        }
        else{
            throw new IllegalArgumentException("Date is invalid; must be YYYY-MM-DD");
        }

        this.description = description;
        this.item_completed= Boolean.parseBoolean(completed);
    }
    public boolean isTitleValid(String title){
        return title.length() > 0;
    }

    public boolean isDueDateValid(String due_date){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date validDate = null;
        df.setLenient(false);
        try{
            validDate = df.parse(due_date);
            return true;
        }
        catch(Exception e) {
            return false;
        }
    }

    public String getTitle(){
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDue_date() {
        return due_date;
    }

    public boolean isItem_completed() {
        return item_completed;
    }

    public void setTitle(String title) {
        if(isTitleValid(title)) {
            this.title = title;
        }
        else {
            throw new IllegalArgumentException("Title is invalid; must be at least 1 character long");
        }
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDue_date(String due_date) {
        if(isDueDateValid(due_date)){
            this.due_date=due_date;
        }
        else{
            throw new IllegalArgumentException("Date is invalid; must be YYYY-MM-DD");
        }
    }

    public void setItem_completed(boolean item_completed) {
        this.item_completed = item_completed;
    }

    @Override
    public String toString() {
        return  "[" + due_date + "] " + title + " " + description + " " + "%n";
    }
}