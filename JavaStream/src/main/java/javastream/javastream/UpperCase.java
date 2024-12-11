package javastream.javastream;
import java.util.*;
import java.util.stream.*;

public class UpperCase {
    public  static void main(String[] args) {
        // İlk yöntem
        Collection<String> result1 = mapToUppercase("A", "b", "c");
        System.out.println("mapToUppercase sonucu: " + result1);

        // İkinci yöntem(stream ile çözüm)
        Collection<String> result2 = mapToUppercase2("A", "b", "c");
        System.out.println("mapToUppercase2 sonucu: " + result2);
    }
    public static Collection<String> mapToUppercase(String... names) {
        Collection<String> uppercaseNames = new ArrayList<>(); // Büyük harfli isimleri tutmak için bir ArrayList oluşturulur.
        for(String name : names) { // names dizisinin her elemanını dolaşır.
            uppercaseNames.add(name.toUpperCase()); // String'i büyük harfe çevirir. Büyük harfe dönüştürülmüş string'i listeye ekler.
        }
        return uppercaseNames; // Büyük harfli isimlerin listesini döndürür.
    }

    // Array elemanlarının tamamını al => stream()
    // Büyük harflere çevir => map()
    // Liste olarak geri dön => collect()

    //Stream ile çözüm
    public static Collection<String> mapToUppercase2(String... names) {
        return Arrays.asList(names).stream().map(name -> name.toUpperCase()).collect(Collectors.toList());
    }
}
