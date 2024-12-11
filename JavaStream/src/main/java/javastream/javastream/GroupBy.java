package javastream.javastream;
import java.util.*;
import java.util.stream.Collectors;

public class GroupBy {
    public static void main(String[] args) {
        // Örnek veri
        List<Person> people = Arrays.asList(
                new Person("Alice", 30, "USA"),
                new Person("Bob", 25, "UK"),
                new Person("Charlie", 35, "USA"),
                new Person("Dave", 22, "Canada"),
                new Person("Eve", 29, "UK")
        );

        // Uyruklarına göre gruplandır
        Map<String, List<Person>> groupedByNationality = groupByNationality(people);

        // Sonuçları yazdır
        groupedByNationality.forEach((nationality, persons) -> {
            System.out.println(nationality + ": " + persons);
        });

        Map<String, List<Person>> groupedByNationality2 = groupByNationality2(people);
        groupedByNationality2.forEach((nationality, persons) -> {
            System.out.println(nationality + ": " + persons);
        });
    }

    public static Map<String, List<Person>> groupByNationality2(List<Person> people) {
        return people.stream() // Listeyi bir Stream'e dönüştür
                .collect(Collectors.groupingBy(Person::getNationality)); // Uyruklarına göre gruplandır
    }
    public static Map<String, List<Person>> groupByNationality(List<Person> people) {
        Map<String, List<Person>> map = new HashMap<>(); // Grupları saklamak için bir Map oluştur
        for (Person person : people) { // Listeyi dolaş
            if (!map.containsKey(person.getNationality())) { // Eğer bu uyruk daha önce eklenmediyse
                map.put(person.getNationality(), new ArrayList<>()); // Yeni bir liste oluştur
            }
            map.get(person.getNationality()).add(person); // Kişiyi ilgili listeye ekle
        }
        return map; // Gruplandırılmış Map'i döndür
    }

}
