package linkedlist;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final var scanner = new Scanner(System.in);
        final var list = new CycledList();
        System.out.println("Type your double values");
        while (scanner.hasNext()) {
            var next = scanner.next();
            double v = 0d;
            try {
                v = Double.parseDouble(next);
            } catch (Exception e) {
                scanner.close();
                break;
            }
            list.addElement(v);
        }
        scanner.close();
        System.out.println("Your input -> " + Arrays.toString(list.asArray()));
        System.out.println("With reversed signs input -> " + Arrays.toString(list.withReversedSigns().asArray()));
        System.out.println("With absolute values input -> " + Arrays.toString(list.withAbsValues().asArray()));
        System.out.println("Summed both -> " + Arrays.toString(list.sumReversedAndAbsValuesWithoutZeros().asArray()));

    }

}
