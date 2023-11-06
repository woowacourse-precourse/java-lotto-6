package lotto.util;

import java.util.ArrayList;
import java.util.List;

public class StringToListConverter {
    public List<Integer> stringToList(String input) {
        List<Integer> userNum = new ArrayList<>();
        for(String s : input.split(",")){
            int number = Integer.parseInt(s);
            userNum.add(number);
        }
        return userNum;
    }
}
