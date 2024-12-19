package javastream.javastream;
import java.util.Arrays;
import java.util.List;

public class AnyMatch{
    public static void main(String[] args) {
        // Bir isim listesi
        List<String> names = Arrays.asList("Ali", "Ayşe", "Fatma", "Mehmet", "Ada");

        // Koşul: İsmi 'Ali' olan biri var mı?
        boolean hasAli = names.stream().anyMatch(name -> name.equals("Ali"));
        System.out.println("Listede 'Ali' var mı? " + hasAli);

        // Koşul: İsmi 'Ahmet' olan biri var mı?
        boolean hasAhmet = names.stream().anyMatch(name -> name.equals("Ahmet"));
        System.out.println("Listede 'Ahmet' var mı? " + hasAhmet);

        // Koşul: İsmi 'Ali' ve uzunluğu 3 olan biri var mı?
        boolean hasAliWithLength3 = names.stream().anyMatch(name -> name.equals("Ali") && name.length() == 3);
        System.out.println("Listede ismi 'Ali' ve uzunluğu 3 olan biri var mı? " + hasAliWithLength3);

        
        // Bir sayı listesi
        List<Integer> numbers = Arrays.asList(10, 15, 20, 25, 30);

        // Koşul: Listede 20'den büyük bir sayı var mı?
        boolean hasGreaterThan20 = numbers.stream().anyMatch(num -> num > 20);
        System.out.println("Listede 20'den büyük bir sayı var mı? " + hasGreaterThan20);

        // Koşul: Listede 50'den büyük bir sayı var mı?
        boolean hasGreaterThan50 = numbers.stream().anyMatch(num -> num > 50);
        System.out.println("Listede 50'den büyük bir sayı var mı? " + hasGreaterThan50);
    }
}

