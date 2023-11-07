package lotto.util;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static lotto.model.Constants.INVALID_MONEY_FORMAT;
import static lotto.model.Constants.INVALID_NUMBER_FORMAT;

public class StringUtil {
    private StringUtil() {}

    public static List<Integer> stringToIntegerList(String string){
        List<Integer> inputList = new ArrayList<>();

        String[] result = string.split(",");

        try{
            for (String s : result) {
                inputList.add(Integer.parseInt(s));
            }
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT);
        }

        return inputList;
    }
}
