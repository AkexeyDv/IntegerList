package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ServiceIntegerTest {
    ServiceInteger out = new ServiceInteger();

    @BeforeEach
    void setUp() {
        out.add(1);
        out.add(2);
        out.add(3);
        out.add(4);
        out.add(5);

    }

    public static Stream<Arguments> createValueForIntegerList() {
        return Stream.of(
                Arguments.of(6),
                Arguments.of(7),
                Arguments.of(8),
                Arguments.of(9),
                Arguments.of(10)
        );
    }

    public static Stream<Arguments> createValueForIntegerListWithIndex() {
        return Stream.of(
                Arguments.of(0, 6),
                Arguments.of(1, 7),
                Arguments.of(2, 8),
                Arguments.of(3, 9),
                Arguments.of(4, 10)
        );
    }

    public static Stream<Arguments> createValueForSet() {
        return Stream.of(
                Arguments.of(0, 6),
                Arguments.of(3, 9),
                Arguments.of(4, 10)
        );
    }

    public static Stream<Arguments> createValueForRemoveItem() {
        return Stream.of(
                Arguments.of(2),
                Arguments.of(1),
                Arguments.of(5)
        );
    }

    public static Stream<Arguments> createValueForRemoveIndex() {
        return Stream.of(
                Arguments.of(0, 1),
                Arguments.of(3, 4),
                Arguments.of(1, 2)
        );
    }

    public static Stream<Arguments> createValueForContain() {
        return Stream.of(
                Arguments.of(1, true),
                Arguments.of(4, true),
                Arguments.of(18, false)
        );
    }

    public static Stream<Arguments> createValueIndexOf() {
        return Stream.of(
                Arguments.of(1, 0),
                Arguments.of(4, 3),
                Arguments.of(18, -1)
        );
    }

    public static Stream<Arguments> createValueGet() {
        return Stream.of(
                Arguments.of(0, 1),
                Arguments.of(1, 2),
                Arguments.of(2, 3),
                Arguments.of(3, 4),
                Arguments.of(4, 5)
        );
    }

    @MethodSource("createValueForIntegerList")
    @ParameterizedTest
    void add(Integer arg) {
        Assertions.assertEquals(arg, out.add(arg));
    }

    @MethodSource("createValueForIntegerListWithIndex")
    @ParameterizedTest
    void add(int idx, Integer arg) {
        Assertions.assertEquals(arg, out.add(idx, arg));
    }

    @Test
    void addThrow() {
        Assertions.assertThrows(ExceptionArray.class, () -> out.add(null));
    }

    @Test
    void addIndexThrow() {
        Assertions.assertThrows(ExceptionArray.class, () -> out.add(out.size(), 8));
        Assertions.assertThrows(ExceptionArray.class, () -> out.add(-5, 8));

    }


    @MethodSource("createValueForSet")
    @ParameterizedTest
    void set(int idx, Integer arg) {
        Assertions.assertEquals(arg, out.set(idx, arg));
    }

    @Test
    void setThrow() {
        Assertions.assertThrows(ExceptionArray.class, () -> out.add(out.set(-1, 8)));
        Assertions.assertThrows(ExceptionArray.class, () -> out.add(out.size(), 8));
        Assertions.assertThrows(ExceptionArray.class, () -> out.add(out.size(), null));
    }

    @MethodSource("createValueForRemoveItem")
    @ParameterizedTest
    void remove(Integer arg) {
        Assertions.assertEquals(arg, out.remove(arg));

    }

    @MethodSource("createValueForRemoveIndex")
    @ParameterizedTest
    void testRemove(int idx, Integer arg) {
        Assertions.assertEquals(arg, out.remove(idx));
    }

    @Test
    void deleteThrow() {
        Assertions.assertThrows(ExceptionArray.class, () -> out.remove((Integer) 128));
        Assertions.assertThrows(ExceptionArray.class, () -> out.remove(out.size()));
        Assertions.assertThrows(ExceptionArray.class, () -> out.remove(out.size()));
    }

    @MethodSource("createValueForContain")
    @ParameterizedTest
    void contains(Integer item, Boolean result) {
        Assertions.assertEquals(result, out.contains(item));
    }

    @MethodSource("createValueIndexOf")
    @ParameterizedTest
    void indexOf(Integer arg, Integer result) {
        Assertions.assertEquals(result, out.indexOf(arg));
    }

    @MethodSource("createValueIndexOf")
    @ParameterizedTest
    void lastIndexOf(Integer arg, Integer result) {
        Assertions.assertEquals(result, out.indexOf(arg));
    }

    @MethodSource("createValueGet")
    @ParameterizedTest
    void get(Integer arg, Integer result) {
        Assertions.assertEquals(result, out.get(arg));

    }

    @Test
    void getThrow() {
        Assertions.assertThrows(ExceptionArray.class, () -> out.get(-1));
        Assertions.assertThrows(ExceptionArray.class, () -> out.get(out.size()));
    }


    @Test
    void testEquals() {
        ServiceInteger outTrue = new ServiceInteger();
        outTrue.add(1);
        outTrue.add(2);
        outTrue.add(3);
        outTrue.add(4);
        outTrue.add(5);
        ServiceInteger outFalse = new ServiceInteger();
        outFalse.add(1);
        outFalse.add(2);
        outFalse.add(3);
        outFalse.add(0);
        outFalse.add(5);
        Assertions.assertEquals(true, out.equals(outTrue));
        Assertions.assertEquals(false, out.equals(outFalse));
    }

    @Test
    void equalsTrow() {
        Assertions.assertThrows(ExceptionArray.class, () -> out.equals(null));
    }

    @Test
    void size() {
        Assertions.assertEquals(5, out.size());
    }

    @Test
    void isEmptyAndCleare() {
        Assertions.assertEquals(false, out.isEmpty());
        out.clear();
        Assertions.assertEquals(true, out.isEmpty());
    }


    @Test
    void toArray() {
        Integer[] inArray = {1, 2, 3, 4, 5};
        Assertions.assertArrayEquals(inArray, out.toArray());
    }
}
//\ No newline at end of file