package javastream.javastream;
import java.util.stream.*;
public class LetterCount {

    public  static void main(String[] args) {
        // Örnek veri
        int totalLetters = getTotalNumberOfLettersOfNamesLongerThanFive("Sena", "Beyza", "Ada", "Melike", "Görkem");
        System.out.println("Toplam harf sayısı (isimler 5 harften uzun): " + totalLetters);
    }
    public static int getTotalNumberOfLettersOfNamesLongerThanFive(String... names) {
        return Stream.of(names) // İsimleri bir Stream'e dönüştürür.
                .filter(name -> name.length() > 5) // Uzunluğu 5'ten fazla olanları filtreler.
                .mapToInt(String::length) // İsimlerin uzunluklarını (harf sayısını) al.
                .sum(); // Toplam uzunluğu hesapla.
    }
}
