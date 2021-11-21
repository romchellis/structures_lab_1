package linkedlist;

import static java.lang.Math.abs;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class CycledList implements List {

    private Node head;
    private Node tail;
    private final Set<Double> uniques = new LinkedHashSet<>();

    @Override
    public Double addElement(Double value) {
        checkExists(value);

        final var next = new Node(value);
        if (head == null) {
            head = next;
        } else {
            tail.next = next;
        }
        tail = next;
        next.next = head;
        return value;
    }

    @Override
    public List withReversedSigns() {
        final var withReversedSigns = new CycledList();
        if (head == null) {
            return withReversedSigns;
        }

        traverse(next -> withReversedSigns.addElement(-next.value));
        return withReversedSigns;
    }

    @Override
    public List withAbsValues() {
        final var withReversedSigns = new CycledList();
        if (head == null) {
            return withReversedSigns;
        }

        traverse(next -> withReversedSigns.addElement(abs(next.value)));
        return withReversedSigns;
    }

    private void traverse(Consumer<Node> extractor) {
        Node current = head;
        do {
            extractor.accept(current);
            current = current.next;
        } while (current != head);
    }

    @Override
    public List sumReversedAndAbsValuesWithoutZeros() {
        final var withReversedSigns = withReversedSigns().asArray();
        final var withAbs = withAbsValues().asArray();
        final var result = new CycledList();
        IntStream.range(0, withAbs.length).mapToDouble(i -> {
                    final var reversed = withReversedSigns[i];
                    final var abs = withAbs[i];
                    return Double.sum(reversed, abs);
                })
                .filter(it -> it != 0d)
                .forEach(result::addElement);
        return result;
    }

    @Override
    public Double[] asArray() {
        return uniques.toArray(new Double[0]);
    }

    private void checkExists(Double value) {
        if (!uniques.add(value)) {
            throw new IllegalStateException("List already contains this value");
        }
    }

    static class Node {

        private final Double value;
        private Node next;

        Node(Double value) {
            this.value = value;
        }
    }
}
