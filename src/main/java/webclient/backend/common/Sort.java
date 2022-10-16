package webclient.backend.common;

import java.util.ArrayList;

public class Sort {

    /**
     * Сортировка списка
     */
    public static <E extends Comparable<E>> void getSortList(ArrayList<E> list) {
        E min;
        int index;
        for (int i = 0; i < list.size(); i++) {
            min = list.get(i);
            index = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (min.compareTo(list.get(j)) > 0) {
                    min = list.get(j);
                    index = j;
                }
            }
            if(index != i) {
                list.set(index, list.get(i));
                list.set(i, min);
            }
        }
    }

    /**
     * Сортировка массива
     */
    public static <E extends Comparable<E>> void getSorеArray(E[] list) {
        E min;
        int index;
        for (int i = 0; i < list.length; i++) {
            min = list[i];
            index = i;
            for (int j = i + 1; j < list.length; j++) {
                if (min.compareTo(list[j]) > 0) {
                    min = list[j];
                    index = j;
                }
            }
            if(index != i) {
                list[index] = list[i];
                list[i] = min;
            }
        }
    }
}