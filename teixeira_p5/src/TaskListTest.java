import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskListTest {

    @Test
    public void addingTaskItemsIncreasesSize(){
        TaskItem item = new TaskItem("test", "desc", "2020-11-12");
        TaskList t = new TaskList();
        t.addListItem(item);
        assertEquals(1,t.getSize());
        t.addListItem(item);
        assertEquals(2,t.getSize());
    }

    @Test
    public void completingTaskItemChangesStatus(){
        TaskItem item = new TaskItem("test", "desc", "2020-11-12", "false");
        TaskList t = new TaskList();
        t.addListItem(item);
        t.markItemCompleted(0);
        assertTrue(item.isItem_completed());
    }

    @Test
    public void completingTaskItemFailsWithInvalidIndex(){
        TaskItem item = new TaskItem("test", "desc", "2020-11-12");
        TaskList t = new TaskList();
        t.addListItem(item);
        assertThrows(IndexOutOfBoundsException.class, () -> t.markItemCompleted(10));
    }

    @Test
    public void editingTaskItemChangesValues(){
        TaskItem item = new TaskItem("test", "desc", "2020-11-12");
        TaskList t = new TaskList();
        t.addListItem(item);
        t.editItem("changed", "changed", "2000-10-10", 0);
        assertEquals("changed", item.getTitle());
        assertEquals("changed", item.getDescription());
        assertEquals("2000-10-10", item.getDue_date());
    }

    @Test
    public void editingTaskItemDueDateChangesValue(){
        TaskItem item = new TaskItem("test", "desc", "2020-11-12");
        TaskList t = new TaskList();
        t.addListItem(item);
        t.editItem("changed", "changed", "2000-10-10", 0);
        assertEquals("2000-10-10", item.getDue_date());
    }

    @Test
    public void editingTaskItemDescriptionChangesValue(){
        TaskItem item = new TaskItem("test", "desc", "2020-11-12");
        TaskList t = new TaskList();
        t.addListItem(item);
        t.editItem("changed", "changed", "2000-10-10", 0);
        assertEquals("changed", item.getDescription());
    }

    @Test
    public void editingTaskItemDescriptionFailsWithInvalidIndex(){
        TaskItem item = new TaskItem("test", "desc", "2020-11-12");
        TaskList t = new TaskList();
        t.addListItem(item);
        assertThrows(IndexOutOfBoundsException.class, () -> t.editItem("changed", "changed", "2000-10-10", 10));
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex(){
        TaskItem item = new TaskItem("test", "desc", "2020-11-12");
        TaskList t = new TaskList();
        t.addListItem(item);
        assertThrows(IndexOutOfBoundsException.class, () -> t.editItem("changed", "changed", "2000-10-10", 10));
    }

    @Test
    public void editingTaskItemTitleChangesValue(){
        TaskItem item = new TaskItem("test", "desc", "2020-11-12");
        TaskList t = new TaskList();
        t.addListItem(item);
        t.editItem("changed", "changed", "2000-10-10", 0);
        assertEquals("changed", item.getTitle());
    }

    @Test
    public void editingTaskItemTitleFailsWithInvalidIndex(){
        TaskItem item = new TaskItem("test", "desc", "2020-11-12");
        TaskList t = new TaskList();
        t.addListItem(item);
        assertThrows(IndexOutOfBoundsException.class, () -> t.editItem("changed", "changed", "2000-10-10", 10));
    }

    @Test
    public void removingTaskItemsDecreasesSize(){
        TaskItem item = new TaskItem("test", "desc", "2020-11-12");
        TaskList t = new TaskList();
        t.addListItem(item);
        t.addListItem(item);
        assertEquals(2,t.getSize());
        t.removeItem(1);
        assertEquals(1,t.getSize());
    }

    @Test
    public void removingTaskItemsFailsWithInvalidIndex(){
        TaskItem item = new TaskItem("test", "desc", "2020-11-12");
        TaskList t = new TaskList();
        t.addListItem(item);
        t.addListItem(item);
        assertThrows(IndexOutOfBoundsException.class, () -> t.removeItem(10));
    }

    @Test
    public void uncompletingTaskItemChangesStatus(){
        TaskItem item = new TaskItem("test", "desc", "2020-11-12", "false");
        TaskList t = new TaskList();
        t.addListItem(item);
        t.markItemUncompleted(0);
        assertFalse(item.isItem_completed());
    }

    @Test
    public void uncompletingTaskItemFailsWithInvalidIndex(){
        TaskItem item = new TaskItem("test", "desc", "2020-11-12");
        TaskList t = new TaskList();
        t.addListItem(item);
        assertThrows(IndexOutOfBoundsException.class, () -> t.markItemUncompleted(10));
    }
    @Test
    public void newTaskListIsEmpty(){
        TaskList t = new TaskList();
        assertTrue(t.ListIsEmpty());
    }

    @Test
    public void savedTaskListCanBeLoaded(){
        TaskList t = new TaskList();
        String filename = "task.txt"; // must have valid task.txt list file to test
        assertDoesNotThrow(() -> t.readList(filename));
    }

    @Test
    public void gettingTaskItemDescriptionSucceedsWithValidIndex() {
        TaskItem item = new TaskItem("test", "desc", "2020-11-12");
        TaskList t = new TaskList();
        t.addListItem(item);
        TaskItem item2 = new TaskItem("test", "desc2", "2020-11-12");
        t.addListItem(item2);
        assertEquals("desc", t.getItem(0).getDescription());
        assertEquals("desc2", t.getItem(1).getDescription());
    }

    @Test
    public void gettingTaskItemDueDateSucceedsWithValidIndex() {
        TaskItem item = new TaskItem("test", "desc", "2020-11-12");
        TaskList t = new TaskList();
        t.addListItem(item);
        TaskItem item2 = new TaskItem("test", "desc2", "2020-11-13");
        t.addListItem(item2);
        assertEquals("2020-11-12", t.getItem(0).getDue_date());
        assertEquals("2020-11-13", t.getItem(1).getDue_date());
    }

    @Test
    public void gettingTaskItemTitleSucceedsWithValidIndex() {
        TaskItem item = new TaskItem("test", "desc", "2020-11-12");
        TaskList t = new TaskList();
        t.addListItem(item);
        TaskItem item2 = new TaskItem("test 2", "desc2", "2020-11-12");
        t.addListItem(item2);
        assertEquals("test 2", t.getItem(1).getTitle());
    }

    @Test
    public void gettingTaskItemDescriptionFailsWithInvalidIndex(){
        TaskItem item = new TaskItem("test", "desc", "2020-11-12");
        TaskList t = new TaskList();
        t.addListItem(item);
        assertThrows(IndexOutOfBoundsException.class, () -> t.getItem(1).getDescription());
    }

    @Test
    public void gettingTaskItemDueDateFailsWithInvalidIndex(){
        TaskItem item = new TaskItem("test", "desc", "2020-11-12");
        TaskList t = new TaskList();
        t.addListItem(item);
        assertThrows(IndexOutOfBoundsException.class, () -> t.getItem(1).getDue_date());
    }

    @Test
    public void gettingTaskItemTitleFailsWithInvalidIndex(){
        TaskItem item = new TaskItem("test", "desc", "2020-11-12");
        TaskList t = new TaskList();
        t.addListItem(item);
        assertThrows(IndexOutOfBoundsException.class, () -> t.getItem(1).getTitle());
    }

    @Test
    public void clearTaskList(){
        TaskItem item = new TaskItem("test", "desc", "2020-11-12");
        TaskList t = new TaskList();
        t.addListItem(item);
        t.clearList();
        assertEquals(0, t.getSize());

    }

}