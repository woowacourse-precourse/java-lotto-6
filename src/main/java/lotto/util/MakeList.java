package lotto.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MakeList {
    public List<Integer> makeStringToIntegerList(String str) {
        List<String> temp = new ArrayList<>(Arrays.asList(str.split(",")));
        List<Integer> result = new ArrayList<>();
        for(String s:temp) {
            result.add(Integer.valueOf(s));
        }
        return result;
    }
}
