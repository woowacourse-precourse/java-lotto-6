package lotto.util;

import java.util.ArrayList;
import java.util.List;

public class ListConverter {
    public static List<Integer> toIntegerList(String input) {

        List<Integer> list = new ArrayList<>();
        String[] slice = input.split(",");

        for (String elem : slice) {
            list.add(Integer.valueOf(elem));
        }

        return list;
    }
}
