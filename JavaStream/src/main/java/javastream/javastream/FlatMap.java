package javastream.javastream;

import java.util.*;

import static java.util.stream.Collectors.*;

public class FlatMap {
    public  static void main(String[] args) {
        // Örnek veri
        List<List<String>> nestedList = Arrays.asList(
                Arrays.asList("a", "b", "c"),
                Arrays.asList("d", "e"),
                Arrays.asList("f", "g", "h")
        );

        List<String> result = transform(nestedList);
        System.out.println("Sonuç 1: " + result);

        List<String> result2 = transform2(nestedList);
        System.out.println("Sonuç 2: " + result2);
    }
    public static List<String> transform(List<List<String>> collection) {
        List<String> newCollection = new ArrayList<>();
        for (List<String> subCollection : collection) { // Ana listeyi dolaşır
            for (String value : subCollection) { // Her bir alt listeyi dolaşır
                newCollection.add(value); // Alt listedeki her öğeyi yeni listeye ekler
            }
        }
        return newCollection; // Düzleştirilmiş listeyi döndür
    }

    //Stream ile çözüm
    public static List<String> transform2(List<List<String>> collection) {
        return collection.stream() // Ana listeyi bir streame dönüştürür
                .flatMap(List::stream) // İç içe listeleri düz bir streame dönüştürür
                .collect(toList()); // Düzleştirilmiş streami bir listeye toplar
    }
}