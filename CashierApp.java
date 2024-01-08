package ay_7aga;
import java.util.InputMismatchException;
import java.util.Scanner;

class Cart {
    private Product[] products;
    private Product[] cart;
    private int products_in_cart;

    public Cart(Product[] products) {
        this.products = products;
        cart = new Product[products.length];
        products_in_cart = 0;
    }
    
    public void displayProducts() {
        if (products.length == 0) {
            System.out.println("No products available.");
        } else {
            System.out.println("List of Products:");
            for (int i = 0; i <= products_in_cart; i++) {
                System.out.println((i+1) + ". " + products[i]);
            }
        }
    }

    public void addToCart(int index, int quantity) {
        if (index >= 0 && index < products.length) {
            Product selectedProduct = products[index];
            if (selectedProduct.getQuantity() >= quantity) {
                Product cartProduct = new Product(selectedProduct.getName(), selectedProduct.getPrice(), quantity);
                cart[products_in_cart++] = cartProduct;
                selectedProduct.setQuantity(selectedProduct.getQuantity() - quantity);
                System.out.println("Product added to cart successfully.");
            } else {
                System.out.println("Insufficient quantity available.");
            }
        } else {
            System.out.println("Invalid product index.");
        }
    }

    public void displayCart() {
        if (products_in_cart == 0) {
            System.out.println("Your cart is empty.");
        } else {
            System.out.println("Your Cart:");
            for (int i = 0; i < products_in_cart; i++) {
                System.out.println((i+1) + ". " + cart[i]);
            }
        }
    }

    public void deleteFromCart(int index) {
        if (index >= 0 && index < products_in_cart) {
            Product removedProduct = cart[index];
            for (int i = index; i < products_in_cart - 1; i++) {
                cart[i] = cart[i + 1];
            }
            products_in_cart--;
            for (int i = 0; i < products.length; i++) {
                Product product = products[i];
                if (product.getName().equals(removedProduct.getName())) {
                    product.setQuantity(product.getQuantity() + removedProduct.getQuantity());
                    break;
                }
            }
            System.out.println("Product removed from cart.");
        } else {
            System.out.println("Invalid product index.");
        }
    }

    public void endShopping() {
        double totalAmount = 0.0;
        if (products_in_cart != 0) {
            System.out.println("Invoice:");
            for (int i = 0; i < products_in_cart; i++) {
                System.out.println(cart[i].getName() + " - $" + cart[i].getPrice() + " x " + cart[i].getQuantity());
                totalAmount += cart[i].getPrice() * cart[i].getQuantity();
            }
            System.out.println("Total Amount: $" + totalAmount);
            products_in_cart = 0;
        } else {
            System.out.println("Your cart is empty.");
        }
    }
}

public class CashierApp {
    public static void main(String[] args) {
        /*Product[] productsList;
        Scanner scanner = new Scanner(System.in);

        Cart cashier = new Cart(productsList);*/
    	Scanner scanner = new Scanner(System.in);
    	  try {	
    	Inventory inventory = new Inventory(); // Create an instance of Inventory
        Product[] productsList = inventory.getProducts(); // Get the available products

       
        Cart cashier = new Cart(productsList); // Pass the products to the Cart constructor

        while (true) {
            System.out.println("\nCashier Mode");
            System.out.println("1. Add to Cart");
            System.out.println("2. View Cart");
            System.out.println("3. Delete from Cart");
            System.out.println("4. End Shopping & Print Invoice");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                	 cashier.displayProducts();
                     System.out.print("Enter the number to the coressponding product to add to cart : ");
                     int productIndex = scanner.nextInt();
                     productIndex--;
                     System.out.print("Enter quantity: ");
                     int qty = scanner.nextInt();
                     cashier.addToCart(productIndex, qty);
                     break;
                case 2:
                	cashier.displayCart();
                    break;
                case 3:
                	cashier.displayCart();
                    System.out.print("Enter the index of the product to delete from cart:");
                    int deleteIndex = scanner.nextInt();
                    deleteIndex--;
                    cashier.deleteFromCart(deleteIndex);
                    break;
                case 4:
                	cashier.endShopping();
                	break;
                case 5:
                	 System.out.println("Exiting Cashier Mode. Thank you!");
                     scanner.close();
                     System.exit(0);
                     break;    
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;   }
                           }
                        } 
    	  
                      catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a valid number.");
                        scanner.nextLine(); // Consume the invalid input
                    } catch (Exception e) {
                        System.out.println("An error occurred in CashierApp: " + e.getMessage());
                        e.printStackTrace(); // Print the stack trace for debugging
                    } finally {
                        scanner.close(); // Always close the scanner in a finally block to avoid resource leaks
                    }
                }
            }