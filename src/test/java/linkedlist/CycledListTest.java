package linkedlist;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Stream;

public class CycledListTest {

    private CycledList list;

    @BeforeEach
    void setUp() {
        list = new CycledList();
    }

    @Test
    void built_list_with_addValue_as_expected() {
        Stream.of(1d, 2d, 3d, 4d, 5d).forEach(list::addElement);

        assertThat(list.asArray()).containsExactly(1d, 2d, 3d, 4d, 5d);
    }

    @Test
    void should_return_list_with_reversed_signs() {
        var reversedList = CycledListBuilder.fromGivenNumbers(10D, 20D, -50.2D)
                .withReversedSigns()
                .asArray();

        assertThat(reversedList).containsExactly(-10D, -20D, 50.2D);
    }

    @Test
    void should_return_list_with_abs_values() {
        var reversedList = CycledListBuilder.fromGivenNumbers(1D, 2D, -3D, -4D, 5D)
                .withAbsValues()
                .asArray();

        assertThat(reversedList).containsExactly(1D, 2D, 3D, 4D, 5D);
    }

    @Test
    void should_sum_return_list_with_abs_values() {
        var summed = CycledListBuilder.fromGivenNumbers(1D, 2D, -3D, -4D, 5D)
                .sumReversedAndAbsValuesWithoutZeros()
                .asArray();

        assertThat(summed).containsExactly(6D, 8D);
    }


    private static class CycledListBuilder {

        public static CycledList fromGivenNumbers(Double... v) {
            var list = new CycledList();
            Arrays.stream(v).forEach(list::addElement);
            return list;
        }

    }

}