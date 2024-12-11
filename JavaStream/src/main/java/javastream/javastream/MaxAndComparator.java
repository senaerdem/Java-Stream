package javastream.javastream;
import java.util.*;
public class MaxAndComparator {
    public static void main(String[] args) {
        // Örnek veri
        List<Person> people = Arrays.asList(
                new Person("Alice", 30, "USA"),
                new Person("Bob", 25, "UK"),
                new Person("Charlie", 35, "Canada")
        );

        // En yaşlı kişiyi bul
        Person oldest = getOldestPerson(people);
        if (oldest != null) {
            System.out.println("En yaşlı kişi: " + oldest.getName() + ", Yaşı: " + oldest.getAge());
        } else {
            System.out.println("Liste boş.");
        }

        // En yaşlı kişiyi bul stream ile
        Person oldest2 = getOldestPerson2(people);
        if (oldest2 != null) {
            System.out.println("En yaşlı kişi: " + oldest2.getName() + ", Yaşı: " + oldest2.getAge());
        } else {
            System.out.println("Liste boş.");
        }
    }

    // Stream ile çözüm
    public static Person getOldestPerson2(List<Person> people) {
        return people.stream() // Listeyi bir Stream'e dönüştür
                .max(Comparator.comparingInt(Person::getAge)) // Yaşa göre en büyüğünü bul
                .orElse(null); // Eğer liste boşsa null döndür
    }
    public static Person getOldestPerson(List<Person> people) {
        Person oldestPerson = new Person("", 0);
        for (Person person : people) {
            if (person.getAge() > oldestPerson.getAge()) { // Eğer daha yaşlı bir kişi bulunursa, onu en yaşlı olarak günceller
                oldestPerson = person;
            }
        }
        return oldestPerson;
    }
}
