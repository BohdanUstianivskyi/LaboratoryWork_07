import java.util.HashMap;
import java.util.Map;

public class Exercise_02 {
    public static void main(String[] args) {
        // Створення об'єкту HashMap для зберігання прізвищ та номерів телефонів
        Map<String, String> phoneBook = new HashMap<>();

        // Додавання елементів в карту
        phoneBook.put("Карпенко", "+380951234567");
        phoneBook.put("Ткач", "+380661234567");
        phoneBook.put("Білоус", "+380631234567");
        phoneBook.put("Коваленко", "+380991234567");
        phoneBook.put("Вовк", "+380971234567");
        phoneBook.put("Ковальчук", "+380681234567");
        phoneBook.put("Мельник", "+380631234567");
        phoneBook.put("Бондаренко", "+380501234567");
        phoneBook.put("Шевченко", "+380961234567");
        phoneBook.put("Тищенко", "+380931234567");

        // Виведення інформації з книги за допомогою циклу
        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
            String lastName = entry.getKey();
            String phoneNumber = entry.getValue();
            System.out.println("Прізвище: " + lastName + ", Номер телефону: " + phoneNumber);
        }

        // Знайдення номеру за прізвищем
        String lastNameToFind = "Шевченко";
        if (phoneBook.containsKey(lastNameToFind)) {
            String phoneNumber = phoneBook.get(lastNameToFind);
            System.out.println("Номер телефону для прізвища " + lastNameToFind + ": " + phoneNumber);
        } else {
            System.out.println("У книзі відсутній абонент з прізвищем " + lastNameToFind);
        }

        // Видалення запису з книги
        String lastNameToRemove = "Мельник";
        phoneBook.remove(lastNameToRemove);
        System.out.println("Запис з прізвищем " + lastNameToRemove + " видалено.");

        // Виведення кількості записів у книзі
        int numberOfEntries = phoneBook.size();
        System.out.println("Кількість записів у книзі: " + numberOfEntries);
    }
}
