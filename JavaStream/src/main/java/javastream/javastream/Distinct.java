package javastream.javastream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Distinct {
    public static void main(String[] args) {
        // Tekrar eden öğeler içeren bir liste
        List<String> names = Arrays.asList("Ali", "Ayşe", "Ali", "Fatma", "Mehmet", "Ayşe");

        // Distinct kullanımı ile benzersiz isimleri elde edelim
        List<String> distinctNames = names.stream()
                .distinct()
                .collect(Collectors.toList());

        // Sonuçları ekrana yazdıralım
        System.out.println("Benzersiz İsimler: " + distinctNames);
    }
}
