import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskItemTest {



    @Test
    public void creatingTaskItemFailsWithInvalidDueDate() {
        assertThrows(IllegalArgumentException.class, () -> {
            TaskItem t = new TaskItem("test","test","11-12-2020");
        } );
    }

    @Test
    public void creatingTaskItemSucceedsWithValidDueDate(){
         assertDoesNotThrow(() -> new TaskItem("test","test description","2020-11-12"));
    }

    @Test
    public void creatingTaskItemFailsWithInvalidTitle(){
        assertThrows(IllegalArgumentException.class, () -> {
            TaskItem t = new TaskItem("","test","2020-11-12");
        } );
    }

    @Test
    public void creatingTaskItemSucceedsWithValidTitle(){
        assertDoesNotThrow(() -> new TaskItem("test","test description","2020-11-12"));
  }

    @Test
    public void settingTaskItemDueDateFailsWithInvalidDate(){
        TaskItem t = new TaskItem("test","test description","2020-11-12");
        assertThrows(IllegalArgumentException.class, () -> t.setDue_date("11-12-2020"));
    }

    @Test
    public void settingTaskItemDueDateSucceedsWithValidDate(){
        TaskItem t = new TaskItem("test","test description","2020-11-12");
        t.setDue_date("2020-11-12");
        assertEquals("2020-11-12", t.getDue_date());
    }

    @Test
    public void settingTaskItemTitleFailsWithInvalidTitle(){
        TaskItem t = new TaskItem("test","test description","2020-11-12");
        assertThrows(IllegalArgumentException.class, () -> t.setTitle(""));
    }

    @Test
    public void settingTaskItemTitleSucceedsWithValidTitle(){
        TaskItem t = new TaskItem("test","test description","2020-11-12");
        t.setTitle("test");
        assertEquals("test", t.getTitle());
    }
}