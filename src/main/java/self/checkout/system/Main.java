package self.checkout.system;

import self.checkout.system.appl.facade.customer.CustomerFacade;
import self.checkout.system.appl.facade.customer.Impl.CustomerFacadeImpl;
import self.checkout.system.appl.facade.item.Impl.ItemFacadeImpl;
import self.checkout.system.appl.facade.item.ItemFacade;
import self.checkout.system.appl.facade.transaction.Impl.TransactionFacadeImpl;
import self.checkout.system.appl.facade.transaction.TransactionFacade;
import self.checkout.system.appl.model.item.Item;
import self.checkout.system.appl.model.transaction.Transaction;
import self.checkout.system.data.customer.CustomerDao;
import self.checkout.system.data.customer.Impl.CustomerDaoImpl;
import self.checkout.system.data.item.Impl.ItemDaoImpl;
import self.checkout.system.data.item.ItemDao;
import self.checkout.system.data.transaction.Impl.TransactionDaoImpl;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    private static CustomerFacade customerFacade = new CustomerFacadeImpl(new CustomerDaoImpl());

    private static ItemFacade itemFacade = new ItemFacadeImpl(new ItemDaoImpl());

    private static final TransactionFacade transactionFacade = new TransactionFacadeImpl(new TransactionDaoImpl());


    public static void main(String[] args) {

        CustomerDao customerDao = new CustomerDaoImpl();
        customerFacade = new CustomerFacadeImpl(customerDao);

        ItemDao itemDao = new ItemDaoImpl();
        itemFacade = new ItemFacadeImpl(itemDao);

        Transaction transactionDao






        displayMenu();

        int option = sc.nextInt();
        sc.nextLine();

        switch (option) {
            case 1:
                viewAllItems(studentFacade);
                break;
            case 2:
                addStudent(studentFacade, sc);
                break;
            case 3:
                updateStudentById(studentFacade, sc);
                break;
            case 4:
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid option. Please choose a valid option.");
        }
    }

    private static void displayMenu() {
        System.out.println("----- Student Management System Menu -----");
        System.out.println("1. View All Item");
        System.out.println("2. Add Item");
        System.out.println("3. Update Transaction");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
    }






}
