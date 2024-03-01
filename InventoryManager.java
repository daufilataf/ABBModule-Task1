import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class InventoryManager {
    private static final String FILE_NAME = "db.txt";
    private List<InventoryItem> items;

    public InventoryManager() {
        this.items = new ArrayList<>();
    }

    public void readInventoryItems() throws FileIOException {
        File file = new File(FILE_NAME);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] itemData = line.split(",");
                InventoryItem item = new InventoryItem(
                        Integer.parseInt(itemData[0]),
                        itemData[1],
                        Integer.parseInt(itemData[2]),
                        Double.parseDouble(itemData[3]));
                items.add(item);
            }
            br.close();

        } catch (FileNotFoundException e) {
            throw new FileIOException("File not found: " + FILE_NAME);
        } catch (IOException e) {
            throw new FileIOException("Error reading from file: " + FILE_NAME);
        }

    }

    public void writeInventoryItems(List<InventoryItem> items) throws FileIOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (InventoryItem item : items) {

                bw.write(item.getItemId() + "," + item.getName() + "," + item.getQuantity() + "," + item.getPrice());
                System.out.println("-------------------------------------------------------------------------------");
                bw.newLine();
            }
        } catch (IOException e) {
            throw new FileIOException(
                    "Error happening, believe me idk what happened, but there is an error, try to solve and return"
                            + FILE_NAME);

        }
    }

    public void addItem(InventoryItem item) throws InvalidDataException, FileIOException, ItemNotFoundException {
        try {
            findItem(item.getItemId());
            throw new InvalidDataException("An item with the same ID already exists.");
        } catch (ItemNotFoundException e) {

            if (item.getItemId() < 0 || item.getPrice() < 0 || item.getQuantity() < 0) {
                throw new InvalidDataException("Item data cannot be negative.");
            }
            items.add(item);
            writeInventoryItems(items);
        }
    }

    public InventoryItem findItem(int itemId) throws ItemNotFoundException {

        for (InventoryItem item : items) {
            if (item.getItemId() == itemId) {
                return item;
            }
        }

        throw new ItemNotFoundException("I could not find item with the provided(" + itemId + ") id :( ");

    }

    public void updateItem(InventoryItem newItem) throws InvalidDataException, ItemNotFoundException, FileIOException {
        InventoryItem item = findItem(newItem.getItemId());
        if (item != null) {
            item.setName(newItem.getName());
            item.setQuantity(newItem.getQuantity());
            item.setPrice(newItem.getPrice());
            writeInventoryItems(items);
        }
    }

    public void deleteItem(int itemId) throws ItemNotFoundException, FileIOException {
        InventoryItem item = findItem(itemId);
        items.remove(item);
        writeInventoryItems(items);
    }
}
