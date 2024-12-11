package javastream.javastream;
import java.util.*;
import java.util.stream.Collectors;
public class UnderAge {

    public static void main(String[] args) {
        // Örnek veri
        List<Person> people = Arrays.asList(
                new Person("Alice", 17, "USA"),
                new Person("Bob", 20, "UK"),
                new Person("Charlie", 15, "Canada"),
                new Person("Dave", 22, "Australia"),
                new Person("Eve", 12, "Germany")
        );

        Set<String> kids = getKidNames(people);
        System.out.println("Çocuklar: " + kids);

        Set<String> kids2 = getKidNames2(people);
        System.out.println("Çocuklar: " + kids2);
    }

    public static Set<String> getKidNames2(List<Person> people) {
        return people.stream() // Listeyi Stream'e dönüştür
                .filter(person -> person.getAge() < 18) // Yaşı 18'den küçük olanları seç
                .map(Person::getName) // Her bir kişinin adını al
                .collect(Collectors.toSet()); // Sonuçları bir Set'e topla
    }
    public static Set<String> getKidNames(List<Person> people) {
        Set<String> kids = new HashSet<>(); // Sonuçları tutacak bir Set
        for (Person person : people) { // Listeyi döngüyle dolaş
            if (person.getAge() < 18) { // Eğer yaş 18'den küçükse
                kids.add(person.getName()); // Kişinin ismini Set'e ekle
            }
        }
        return kids; // Tüm isimleri döndür
    }

}
