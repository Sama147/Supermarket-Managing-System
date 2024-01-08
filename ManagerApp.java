package ay_7aga;
import java.util.InputMismatchException;
import java.io.*;
import java.util.Scanner;

class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Product: " + name + " | Price: $" + price + " | Quantity: " + quantity;
    }
}

class Inventory {
    private static final String FILENAME = "products.txt";
    private Product[] products;
    private int products_in_inventory;

    public Inventory() {
        products = new Product[100];
        products_in_inventory = 0;
        loadProductsFromFile();
    }
    
    public Product[] getProducts() {
        return products;
    }
    
    public void checkStock() {
        for (int i = 0; i < products_in_inventory; i++) {
            if (products[i].getQuantity() <= 3) {
                System.out.println("Warning: Low stock for product '" + products[i].getName() + "'. Quantity: " + products[i].getQuantity());
            }
        }
    }


    private void loadProductsFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[0];
                double price = Double.parseDouble(data[1]);
                int quantity = Integer.parseInt(data[2]);
                addProduct(name, price, quantity);
            }
        } catch (FileNotFoundException e) {
            // Handle the case where the file is not found
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException | NumberFormatException e) {
            // Handle general IO errors or conversion errors
            System.out.println("Error loading products from file: " + e.getMessage());
        }
    }
    private void saveProductsToFile() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILENAME))) {
            for (int i = 0; i < products_in_inventory; i++) {
                Product product = products[i];
                pw.println(product.getName() + "," + product.getPrice() + "," + product.getQuantity());
            }
        } catch (IOException e) {
            System.out.println("Error saving products to file: " + e.getMessage());
        }
    }
    
    public void displayProducts() {
        if (products_in_inventory == 0) {
            System.out.println("No products available.");
        } else {
            System.out.println("List of Products:");
            for (int i = 0; i < products_in_inventory; i++) {
                System.out.println((i + 1) + ". " + products[i]);
            }
        }
    }
    
    public void addProduct(String name, double price, int quantity) {
        if (products_in_inventory < products.length) {
            products[products_in_inventory] = new Product(name, price, quantity);
            products_in_inventory++;
            saveProductsToFile();
            System.out.println("Product added successfully.");
        } else {
            System.out.println("Inventory is full. Cannot add more products.");
        }
    }

    public void editProduct(int index, double newPrice, int newQuantity) {
        if (index >= 0 && index < products_in_inventory) {
            Product product = products[index];
            product.setPrice(newPrice);
            product.setQuantity(newQuantity);
            saveProductsToFile();
            System.out.println("Product details updated successfully.");
        } else {
            System.out.println("Invalid product index.");
        }
    }

    public void deleteProduct(int index) {
        if (index >= 0 && index < products_in_inventory) {
            Product product = products[index];
            for (int i = index; i < products_in_inventory - 1; i++) {
                products[i] = products[i + 1];
            }
            products[products_in_inventory - 1] = null;
            products_in_inventory--;
            saveProductsToFile();
            System.out.println("Product deleted successfully: " + product.getName());
        } else {
            System.out.println("Invalid product index.");
        }
    }
}

public class ManagerApp {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Scanner scanner = new Scanner(System.in);

        while (true) {
         try{
            System.out.println("\nInventory Manager Mode");
            System.out.println("1. Display Products");
            System.out.println("2. Add Product");
            System.out.println("3. Edit Product");
            System.out.println("4. Delete Product");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
            	case 1:
            		inventory.displayProducts();
            		 inventory.checkStock();
            		break;
                case 2:
                    System.out.print("Enter product name: ");
                    scanner.nextLine(); // Consume newline character
                    String name = scanner.nextLine();
                    System.out.print("Enter product price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter product quantity: ");
                    int quantity = scanner.nextInt();
                    inventory.addProduct(name, price, quantity);
                    break;
                case 3:
                	inventory.displayProducts();
                    System.out.print("Enter the number of the product to edit : ");
                    int index = scanner.nextInt();
                    index--;
                    System.out.print("Enter new price: ");
                    double newPrice = scanner.nextDouble();
                    System.out.print("Enter new quantity: ");
                    int newQuantity = scanner.nextInt();
                    inventory.editProduct(index, newPrice, newQuantity);
                    break;
                case 4:
                	inventory.displayProducts();
                    System.out.print("Enter the number of the product to delete : ");
                    int deleteIndex = scanner.nextInt();
                    deleteIndex--;
                    inventory.deleteProduct(deleteIndex);
                    break;
                case 5:
                    System.out.println("Exiting Inventory Manager Mode. Thank you!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
         } catch (InputMismatchException e) {
             System.out.println("Invalid input. Please enter a valid number.");
             scanner.nextLine(); // Consume the invalid input
         } catch (Exception e) {
             System.out.println("An error occurred: " + e.getMessage());
             e.printStackTrace(); // Print the stack trace for debugging
         }
     }
 }
}
