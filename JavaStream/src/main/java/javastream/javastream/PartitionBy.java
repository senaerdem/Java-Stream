package javastream.javastream;
import java.util.*;
import java.util.stream.Collectors;

public class PartitionBy {
    public static void main(String[] args) {
        // Örnek veri
        List<Person> people = Arrays.asList(
                new Person("Alice", 30, "USA"),
                new Person("Bob", 15, "UK"),
                new Person("Charlie", 35, "USA"),
                new Person("Dave", 17, "Canada"),
                new Person("Eve", 29, "UK")
        );

        // Fonksiyonu çağır ve sonucu yazdır
        Map<Boolean, List<Person>> partitioned = partitionAdults(people);

        // Sonuçları yazdır
        System.out.println("Adults: " + partitioned.get(true));
        System.out.println("Kids: " + partitioned.get(false));

        // Fonksiyonu çağır ve sonucu yazdır stream ile
        Map<Boolean, List<Person>> partitioned2 = partitionAdults(people);
        System.out.println("Adults: " + partitioned2.get(true));
        System.out.println("Kids: " + partitioned2.get(false));
    }

    // Stream ile çözüm
    public static Map<Boolean, List<Person>> partitionAdults2(List<Person> people) {
        return people.stream() // Listeyi bir Stream'e dönüştür
                .collect(Collectors.partitioningBy(person -> person.getAge() >= 18)); // Şarta göre gruplandır
    }

    public static Map<Boolean, List<Person>> partitionAdults(List<Person> people) {
        Map<Boolean, List<Person>> map = new HashMap<>();
        map.put(true, new ArrayList<>());
        map.put(false, new ArrayList<>());
        for (Person person : people) {
            map.get(person.getAge() >= 18).add(person);
        }
        return map;
    }
}