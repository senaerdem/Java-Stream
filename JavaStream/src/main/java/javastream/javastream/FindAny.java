package javastream.javastream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FindAny {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Ali", "Ayşe", "Fatma", "Mehmet");

        // Sıralı Akış
        Optional<String> sequentialName = names.stream().findAny();
        if (sequentialName.isPresent()) {
            System.out.println("Sıralı Akışta Bulunan İsim: " + sequentialName.get());
        }

        // Paralel Akış
        Optional<String> parallelName = names.parallelStream().findAny();
        if (parallelName.isPresent()) {
            System.out.println("Paralel Akışta Bulunan İsim: " + parallelName.get());
        }
    }
}
