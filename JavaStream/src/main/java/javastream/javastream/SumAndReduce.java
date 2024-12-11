package javastream.javastream;
import java.util.*;

public class SumAndReduce {

    public static void main(String[] args) {
        // Örnek veri
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        int total = calculate(numbers);
        System.out.println("Toplam: " + total);

        int total2 = calculate(numbers);
        System.out.println("Toplam: " + total2);
    }

    // Stream ile çözüm
    public static int calculate2(List<Integer> numbers) {
        return numbers.stream() // Listeyi bir Stream'e dönüştür
                .reduce(0, Integer::sum); // Başlangıç değeri 0 ile topla
    }
    public static int calculate(List<Integer> numbers) {
        int total = 0; // Toplamı tutacak değişken
        for (int number : numbers) { // Her bir elemanı dolaş
            total += number; // Elemanı toplam değişkenine ekle
        }
        return total; // Toplamı döndür
    }

}