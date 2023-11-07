package lotto.util;

import java.util.ArrayList;
import java.util.List;

public class StringUtil {
    private StringUtil() {}

    public static List<Integer> stringToIntegerList(String string){
        List<Integer> inputList = new ArrayList<>();

        String[] result = string.split(",");

        for (String s : result) {
            inputList.add(Integer.parseInt(s));
        }

        return inputList;
    }
}
