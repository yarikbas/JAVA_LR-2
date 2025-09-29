package com.customer.model.Customer;

/**
 * Модель сутності {@code Customer}, що представляє клієнта банку/системи.
 * <p>
 * Клас містить базові дані про клієнта:
 * <ul>
 *     <li>Ідентифікатор;</li>
 *     <li>ПІБ (прізвище, ім’я, по батькові);</li>
 *     <li>адресу;</li>
 *     <li>Номер кредитної картки;</li>
 *     <li>Баланс кредитної картки.</li>
 * </ul>
 *
 * Використовується у програмі для зчитування та відображення інформації
 * про клієнтів, а також для фільтрації за різними критеріями.
 *
 * @author Basarab Yaroslav
 * @version 1.0
 * @since 1.0
 */
public class Customer {
    /** Унікальний ідентифікатор клієнта. */
    private int id;

    /** Прізвище клієнта. */
    private String lastName;

    /** Ім’я клієнта. */
    private String firstName;

    /** По батькові клієнта. */
    private String middleName;

    /** Адреса клієнта. */
    private String address;

    /** Номер кредитної картки клієнта. */
    private long creditCardNumber;

    /** Баланс кредитної картки (може бути від’ємним). */
    private double creditCardBalance;

    /**
     * Конструктор за замовчуванням.
     * Ініціалізує об’єкт "невідомими" значеннями та нульовими числами.
     */
    public Customer() {
        this.id = 0;
        this.lastName = "Unknown";
        this.firstName = "Unknown";
        this.middleName = "Unknown";
        this.address = "Unknown";
        this.creditCardNumber = 0;
        this.creditCardBalance = 0;
    }

    /**
     * Повний конструктор.
     *
     * @param id                ідентифікатор клієнта
     * @param lastName          прізвище
     * @param firstName         ім’я
     * @param middleName        по батькові
     * @param address           адреса
     * @param creditCardNumber  номер кредитної картки
     * @param creditCardBalance баланс кредитної картки
     */
    public Customer(int id, String lastName, String firstName, String middleName,
                    String address, long creditCardNumber, double creditCardBalance) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.address = address;
        this.creditCardNumber = creditCardNumber;
        this.creditCardBalance = creditCardBalance;
    }

    /**
     * @return ідентифікатор клієнта
     */
    public int getId() {
        return id;
    }

    /**
     * @param id новий ідентифікатор клієнта
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return прізвище клієнта
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName нове прізвище клієнта
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return ім’я клієнта
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName нове ім’я клієнта
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return по батькові клієнта
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * @param middleName нове по батькові клієнта
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**
     * @return адреса клієнта
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address нова адреса клієнта
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return номер кредитної картки
     */
    public long getCreditCardNumber() {
        return creditCardNumber;
    }

    /**
     * @param creditCardNumber новий номер кредитної картки
     */
    public void setCreditCardNumber(long creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    /**
     * @return баланс кредитної картки
     */
    public double getCreditCardBalance() {
        return creditCardBalance;
    }

    /**
     * @param creditCardBalance новий баланс кредитної картки
     */
    public void setCreditCardBalance(double creditCardBalance) {
        this.creditCardBalance = creditCardBalance;
    }

    /**
     * Повертає рядкове представлення клієнта у форматі,
     * зручному для виводу у консоль.
     *
     * @return відформатований рядок із даними клієнта
     */
    @Override
    public String toString() {
        return "Customer" + "\n ------------------------------------------\n" +
                "id=" + getId() +
                ",\n lastName='" + getLastName() +
                ",\n firstName='" + getFirstName() +
                ",\n middleName='" + getMiddleName() +
                ",\n address='" + getAddress() +
                ",\n creditCardNumber='" + getCreditCardNumber() +
                ",\n creditCardBalance=" + getCreditCardBalance() +
                "\n ------------------------------------------";
    }
}
