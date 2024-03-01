import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class InventoryManager {
    private static final String FINAL_NAME = "db.txt";
    private List<InventoryItem> items;

    public InventoryManager() {
        this.items = new ArrayList<>();
    }

    public void readInventoryItems() throws FileIOException {
        // I will add functionalities here;
    }

    public void writeInventoryItems(List<InventoryItem> items) throws FileIOException {
        // I will add writing functionalities here;
    }

    public void addItem(InventoryItem item) throws InvalidDataException, FileIOException {
        // I will add functionality functionalities here;

    }

    // public InventoryItem findItem(int itemId) throws ItemNotFoundException {

    // return item;

    // }

    public void updateItem(InventoryItem newItem) throws InvalidDataException, ItemNotFoundException, FileIOException {

    }

    public void deleteItem(int itemId) throws ItemNotFoundException, FileIOException {

    }
}
