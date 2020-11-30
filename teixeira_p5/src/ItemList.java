import java.util.ArrayList;
import java.util.InputMismatchException;

public class ItemList {
    protected ArrayList<Item> itemList = new ArrayList<Item>();

    public void addListItem(Item item) {
        this.itemList.add(item);
    }

    public void removeItem(int index) {
        try {
            this.itemList.remove(index);
        }catch (IndexOutOfBoundsException ex) {
            throw new IndexOutOfBoundsException("Please select a valid item to remove");
        } catch (InputMismatchException ex) {
            throw new InputMismatchException("Please select a valid item to remove!");
        }
    }

    public int getSize() {
        return this.itemList.size();
    }

    public void isIndexValid(int index){
        if(index >= this.itemList.size()){
            throw new IndexOutOfBoundsException("Please select a valid item!");
        }
    }

    public boolean ListIsEmpty() {
        return this.itemList.size() == 0;
    }

    public void clearList() {
        this.itemList.clear();
    }

}