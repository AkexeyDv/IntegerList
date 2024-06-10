package org.example;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Vector;
import java.util.stream.Stream;

public class ServiceInteger implements IntegerList {
    private Integer[] integers;

    public ServiceInteger() {
        this.integers = new Integer[0];
    }

    @Override
    public Integer[] getIntegerList() {
        return integers;
    }

    @Override
    public Integer add(Integer item) {
        if (item == null) {
            throw new ExceptionArray("Пустое значение элемента массива");
        }
        Integer[] copyArray = new Integer[integers.length + 1];
        System.arraycopy(integers, 0, copyArray, 0, integers.length);
        integers = copyArray;
        integers[integers.length - 1] = item;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        if (index < 0 || index >= integers.length) {
            throw new ExceptionArray("Указанный в параметре индекс вне массива");
        }
        if (item == null) {
            throw new ExceptionArray("Пустое значение элемента массива");
        }
        Integer[] copyArray = new Integer[integers.length + 1];
        for (int i = 0; i < integers.length; i++) {
            if (i < index) {
                copyArray[i] = integers[i];
            }
            if (i >= index) {
                copyArray[i + 1] = integers[i];
            }

        }
        copyArray[index] = item;
        integers = copyArray;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        if (index < 0 || index >= integers.length) {
            throw new ExceptionArray("Указанный в параметре индекс вне массива");
        }
        if (item == null) {
            throw new ExceptionArray("Пустое значение элемента массива");
        }
        integers[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        int index = indexOf(item);
        if (item == null) {
            throw new ExceptionArray("Пустое значение параметра");
        }
        if (index == -1) {
            throw new ExceptionArray("Указанный для удаления элемент не найден");
        }
        Integer[] copyArray = new Integer[integers.length - 1];
        for (int i = 0; i < integers.length; i++) {
            if (i < index) {
                copyArray[i] = integers[i];
            }
            if (i > index) {
                copyArray[i - 1] = integers[i];
            }
        }
        integers = copyArray;
        return item;
    }

    @Override
    public Integer remove(int index) {
        if (index < 0 || index >= integers.length) {
            throw new ExceptionArray("Несуществующий индекс");
        }
        Integer item = integers[index];
        Integer[] copyArray = new Integer[integers.length - 1];
        for (int i = 0; i < integers.length; i++) {
            if (i < index) {
                copyArray[i] = integers[i];
            }
            if (i > index) {
                copyArray[i - 1] = integers[i];
            }
        }
        integers = copyArray;
        return item;
    }

    @Override
    public boolean contains(Integer item) {
        if (indexOf(item) != -1) {
            return true;
        }
        return false;
    }

    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < integers.length; i++) {
            if (item == integers[i]) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = integers.length - 1; i >= 0; i--) {
            if (item == integers[i]) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        if (index < 0 || index >= integers.length) {
            throw new ExceptionArray("Несуществующий индекс");
        }
        return integers[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        if (otherList == null) {
            throw new ExceptionArray("Передан пустой лист");
        }
        if (otherList.getClass() != ServiceInteger.class || otherList.size() != integers.length) {
            return false;
        }
        for (int i = 0; i < integers.length; i++) {
            if (otherList.getIntegerList()[i] != integers[i]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return integers.length;
    }

    @Override
    public boolean isEmpty() {
        if (integers.length == 0) {
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        integers = new Integer[0];

    }

    @Override
    public Integer[] toArray() {
        Integer[] newArray = new Integer[integers.length];
        System.arraycopy(integers, 0, newArray, 0, integers.length);
        return newArray;
    }

    public Integer[] sort() {
        long time1;
        long time2;
        long time3;
        Integer[] copyArray1 = integers;
        Integer[] copyArray2 = integers;
        Integer[] copyArray3 = integers;
        long start = System.currentTimeMillis();
        System.out.println(start);
        int tmp;
        for (int i = 0; i < copyArray1.length; i++) {
            for (int j = 0; j < copyArray1.length - 1 - i; j++) {
                if (copyArray1[j] > copyArray1[j + 1]) {
                    tmp = copyArray1[j];
                    copyArray1[j] = copyArray1[j + 1];
                    copyArray1[j + 1] = tmp;

                }

            }


        }
        time1 = System.currentTimeMillis() - start;

        start = System.currentTimeMillis();
        for (int i = 0; i < copyArray2.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < copyArray2.length; j++) {
                if (copyArray2[j] < copyArray2[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            tmp = copyArray2[i];
            copyArray2[i] = copyArray2[minElementIndex];
            copyArray2[minElementIndex] = tmp;
        }
        time2 = System.currentTimeMillis() - start;

        start = System.currentTimeMillis();
        for (int i = 1; i < copyArray3.length; i++) {
            int temp = copyArray3[i];
            int j = i;
            while (j > 0 && copyArray3[j - 1] >= temp) {
                copyArray3[j] = copyArray3[j - 1];
                j--;
            }
            copyArray3[j] = temp;
        }
        time3 = System.currentTimeMillis() - start;

        Integer[] copyArray;

        if (time1 < time2 & time1 < time3) {
            copyArray = copyArray1;
        } else {
            if (time2 < time1 & time2 < time3) {
                copyArray = copyArray2;
            } else {
                copyArray = copyArray3;
            }

        }
        System.out.println(time1 + " " + time2 + " " + time3);
        return copyArray;
    }

    public String toString() {
        return Arrays.toString(integers);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        ServiceInteger that = (ServiceInteger) object;
        return Arrays.equals(integers, that.integers);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(integers);
    }
}
