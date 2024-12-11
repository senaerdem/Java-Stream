package javastream.javastream;
import java.util.*;
import java.util.stream.Collectors;
public class Joining {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Alice", 30, "USA"),
                new Person("Bob", 25, "UK"),
                new Person("Charlie", 35, "USA"),
                new Person("Dave", 22, "Canada")
        );

        // Kişi isimlerini virgülle ayırarak birleştir
        String result = namesToString(people);
        System.out.println(result); // Sonucu yazdır

        String result2 = namesToString2(people);
        System.out.println(result2); // Sonucu yazdır
    }

    public static String namesToString2(List<Person> people) {
        return "Names: " +
                people.stream() // Listeyi bir Stream'e dönüştür
                        .map(Person::getName) // Her bir Person nesnesinin adını al
                        .collect(Collectors.joining(", ")) + // İsimleri virgülle ayırarak birleştir
                ".";
    }



    public static String namesToString(List<Person> people) {
        // Başlangıç etiketini oluşturuyoruz.
        // "Names: " ifadesi, döndürmek istediğimiz sonuçta en başta yer alacak.
        String label = "Names: ";

        // StringBuilder, metinleri verimli bir şekilde birleştirmek için kullanılır.
        // label'ı StringBuilder'a ekliyoruz.
        StringBuilder sb = new StringBuilder(label);

        // Person listesinde dolaşıyoruz.
        for (Person person : people) {
            // Eğer StringBuilder'ın uzunluğu "Names: " etiketinden uzun ise,
            // bu, önceki isimlerin sonrasına yeni bir isim ekleyeceğimiz anlamına gelir.
            // Yani ilk isimden sonra her yeni isim için bir virgül ekleyeceğiz.
            if (sb.length() > label.length()) {
                sb.append(", ");
            }

            // Kişinin ismini StringBuilder'a ekliyoruz.
            sb.append(person.getName());
        }

        // Son olarak, nokta ekliyoruz ve StringBuilder içeriğini döndürüyoruz.
        sb.append(".");
        return sb.toString();
    }

}
