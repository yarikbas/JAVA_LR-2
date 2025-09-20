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
    private String LastName;

    /** Ім’я клієнта. */
    private String FirstName;

    /** По батькові клієнта. */
    private String MiddleName;

    /** Адреса клієнта. */
    private String Address;

    /** Номер кредитної картки клієнта. */
    private long CreditCardNumber;

    /** Баланс кредитної картки (може бути від’ємним). */
    private double CreditCardBalance;

    /**
     * Конструктор за замовчуванням.
     * Ініціалізує об’єкт "невідомими" значеннями та нульовими числами.
     */
    public Customer() {
        this.id = 0;
        this.LastName = "Unknown";
        this.FirstName = "Unknown";
        this.MiddleName = "Unknown";
        this.Address = "Unknown";
        this.CreditCardNumber = 0;
        this.CreditCardBalance = 0;
    }

    /**
     * Повний конструктор.
     *
     * @param id                ідентифікатор клієнта
     * @param LastName          прізвище
     * @param FirstName         ім’я
     * @param MiddleName        по батькові
     * @param Address           адреса
     * @param CreditCardNumber  номер кредитної картки
     * @param CreditCardBalance баланс кредитної картки
     */
    public Customer(int id, String LastName, String FirstName, String MiddleName,
                    String Address, long CreditCardNumber, double CreditCardBalance) {
        this.id = id;
        this.LastName = LastName;
        this.FirstName = FirstName;
        this.MiddleName = MiddleName;
        this.Address = Address;
        this.CreditCardNumber = CreditCardNumber;
        this.CreditCardBalance = CreditCardBalance;
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
        return LastName;
    }

    /**
     * @param LastName нове прізвище клієнта
     */
    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    /**
     * @return ім’я клієнта
     */
    public String getFirstName() {
        return FirstName;
    }

    /**
     * @param FirstName нове ім’я клієнта
     */
    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    /**
     * @return по батькові клієнта
     */
    public String getMiddleName() {
        return MiddleName;
    }

    /**
     * @param MiddleName нове по батькові клієнта
     */
    public void setMiddleName(String MiddleName) {
        this.MiddleName = MiddleName;
    }

    /**
     * @return адреса клієнта
     */
    public String getAddress() {
        return Address;
    }

    /**
     * @param Address нова адреса клієнта
     */
    public void setAddress(String Address) {
        this.Address = Address;
    }

    /**
     * @return номер кредитної картки
     */
    public long getCreditCardNumber() {
        return CreditCardNumber;
    }

    /**
     * @param CreditCardNumber новий номер кредитної картки
     */
    public void setCreditCardNumber(long CreditCardNumber) {
        this.CreditCardNumber = CreditCardNumber;
    }

    /**
     * @return баланс кредитної картки
     */
    public double getCreditCardBalance() {
        return CreditCardBalance;
    }

    /**
     * @param CreditCardBalance новий баланс кредитної картки
     */
    public void setCreditCardBalance(double CreditCardBalance) {
        this.CreditCardBalance = CreditCardBalance;
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
