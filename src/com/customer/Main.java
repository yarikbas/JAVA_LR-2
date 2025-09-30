package com.customer;

import com.customer.model.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Точка входу до консольної утиліти для роботи зі списком клієнтів.
 * <p>
 * Програма:
 * <ol>
 *   <li>Зчитує клієнтів із текстового файлу (шлях до файлу вказано всередині методу {@link #readFromFile(List)}).</li>
 *   <li>Виводить усіх клієнтів у консоль.</li>
 *   <li>Запитує ім’я користувача та виводить усіх клієнтів з таким ім’ям ({@link #withName(String, List)}).</li>
 *   <li>Запитує інтервал номерів карт та виводить клієнтів, чиї картки потрапляють у цей діапазон
 *       ({@link #creditCardNumberInRange(long, long, List)}).</li>
 *   <li>Виводить клієнтів із заборгованістю (від’ємний баланс) ({@link #withArrears(List)}).</li>
 * </ol>
 *
 * <p><strong>Примітка:</strong> шлях до файлу у {@code readFromFile} жорстко задано.
 * За потреби змініть його під свою систему або додайте зчитування шляху з консолі.</p>
 *
 * @author  Basarab_Yaroslav
 * @version 1.13
 * @since   1.0
 */
public class Main {

    /**
     * Запускає застосунок у консольному режимі.
     * <p>
     * Виконує зчитування даних, виведення списків та діалог із користувачем через {@link Scanner}.
     * </p>
     *
     * @param args не використовується
     */
    public static void main(String[] args) {
        Scanner scannerIn = new Scanner(System.in);

        List<Customer> customers = new ArrayList<>();
        readFromFile(customers);

        System.out.println("Всі користувачі:\n");
        for (Customer c : customers) {
            System.out.println(c);
        }

        System.out.println("Введіть ім'я користувача: ");
        String name = scannerIn.next();

        List<Customer> customersWithName = withName(name, customers);
        if (customersWithName.isEmpty()) {
            System.out.printf("Немає користувачів з іменем %s:\n", name);
        } else {
            System.out.println("Всі користувачі з іменем:\n");

            for (Customer c : customersWithName) {
                System.out.println(c);
            }
        }

        System.out.println("Введіть інтервал номерів карт користувачів: ");
        long start = scannerIn.nextLong();
        long end = scannerIn.nextLong();

        List<Customer> customersCreditCardNumberInRange = creditCardNumberInRange(start, end, customers);
        if (customersCreditCardNumberInRange.isEmpty()) {
            System.out.printf("Немає користувачів з номерами карт від %d до %d.\n", start, end);
        } else {
            System.out.printf("Всі користувачі з номерами карт від %d до %d:\n", start, end);
            for (Customer c : customersCreditCardNumberInRange) {
                System.out.println(c);
            }
        }

        List<Customer> customersWithArrears = withArrears(customers);
        if (customersCreditCardNumberInRange.isEmpty()) { // ймовірно, тут хотіли перевіряти customersWithArrears.isEmpty()
            System.out.println("Немає користувачів із заборгованістю.");
        } else {
            System.out.println("Всі користувачі із заборгованістю: ");
            for (Customer c : customersWithArrears) {
                System.out.println(c);
            }
            System.out.printf("\nЗагальна кількість людей з заборгованістю: %d", customersWithArrears.size());
        }
        scannerIn.close();
    }

    /**
     * Зчитує клієнтів із текстового файлу та додає їх у переданий список.
     * <p>
     * Очікуваний формат рядка у файлі:
     * <pre>
     *     id(int) lastName(String) firstName(String) middleName(String) address(String) creditCardNumber(long) balance(double)
     * </pre>
     * Поля відокремлені пробілами або переведеннями рядка.
     * </p>
     *
     * @param customers список, у який буде додано зчитаних клієнтів; не {@code null}
     * @return той самий список {@code customers} із доданими елементами
     * @implNote Метод обробляє {@link FileNotFoundException} локально та друкує стек викликів у разі помилки.
     */
    public static List<Customer> readFromFile(List<Customer> customers) {
        try (Scanner scannerFile = new Scanner(new File("C:/Users/user/IdeaProjects/LR2/дані_лр-2.txt"))) {
            while (scannerFile.hasNext()) {
                int id = scannerFile.nextInt();
                String lastName = scannerFile.next();
                String firstName = scannerFile.next();
                String middleName = scannerFile.next();
                String address = scannerFile.next();
                long creditCardNumber = scannerFile.nextLong();
                double balance = scannerFile.nextDouble();

                Customer customer = new Customer(id, lastName, firstName, middleName,
                        address, creditCardNumber, balance);
                customers.add(customer);
            }
        } catch (FileNotFoundException exception) {
            System.out.println("Файл не знайдено!");
            exception.printStackTrace();
        }
        return customers;
    }

    /**
     * Повертає список клієнтів, чиє ім’я (firstName) точно збігається з переданим значенням.
     *
     * @param name     ім’я для пошуку (регістрозалежний точний збіг); не {@code null}
     * @param fullList повний список клієнтів для фільтрації; не {@code null}
     * @return новий список клієнтів з відповідним іменем; якщо збігів немає — порожній список
     */
    public static List<Customer> withName(String name, List<Customer> fullList) {
        List<Customer> customersWithName = new ArrayList<>();
        for (Customer customer : fullList) {
            if (customer.getFirstName().equals(name)) {
                customersWithName.add(customer);
            }
        }
        return customersWithName;
    }

    /**
     * Повертає список клієнтів, у яких номер кредитної картки належить заданому інтервалу.
     * <p>
     * Якщо {@code start} &gt; {@code end}, межі буде автоматично поміняно місцями.
     * Межі інтервалу включні.
     * </p>
     *
     * @param start   ліва межа інтервалу номерів карт (включно)
     * @param end     права межа інтервалу номерів карт (включно)
     * @param fullList повний список клієнтів для фільтрації; не {@code null}
     * @return новий список клієнтів із номерами карт у межах інтервалу; якщо збігів немає — порожній список
     */
    public static List<Customer> creditCardNumberInRange(long start, long end, List<Customer> fullList) {
        List<Customer> customersInRange = new ArrayList<>();
        if (start > end) {
            long temp = start;
            start = end;
            end = temp;
        }
        for (Customer customer : fullList) {
            if (customer.getCreditCardNumber() >= start && customer.getCreditCardNumber() <= end) {
                customersInRange.add(customer);
            }
        }
        return customersInRange;
    }

    /**
     * Повертає список клієнтів із заборгованістю, тобто тих, у кого баланс кредитної картки менший за нуль.
     *
     * @param fullList повний список клієнтів для фільтрації; не {@code null}
     * @return новий список клієнтів із від’ємним балансом; якщо таких немає — порожній список
     */
    public static List<Customer> withArrears(List<Customer> fullList) {
        List<Customer> customersWithArrears = new ArrayList<>();
        for (Customer customer : fullList) {
            if (customer.getCreditCardBalance() < 0) {
                customersWithArrears.add(customer);
            }
        }
        return customersWithArrears;
    }
}
