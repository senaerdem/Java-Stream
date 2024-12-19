package javastream.javastream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LimitAndSkip{
    public static void main(String[] args) {
        // Bir sayı listesi
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // İlk 5 öğeyi al (limit)
        List<Integer> limitedNumbers = numbers.stream()
                .limit(5)
                .collect(Collectors.toList());
        System.out.println("İlk 5 sayı: " + limitedNumbers);

        // İlk 3 öğeyi atla (skip)
        List<Integer> skippedNumbers = numbers.stream()
                .skip(3)
                .collect(Collectors.toList());
        System.out.println("İlk 3 sayıyı atladıktan sonra kalanlar: " + skippedNumbers);

        // İlk 3 öğeyi atla, ardından sonraki 4 öğeyi al
        List<Integer> skippedAndLimitedNumbers = numbers.stream()
                .skip(3)
                .limit(4)
                .collect(Collectors.toList());
        System.out.println("İlk 3 sayıyı atladıktan sonra sonraki 4 sayı: " + skippedAndLimitedNumbers);
    }
}
