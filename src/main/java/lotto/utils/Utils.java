package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.constants.Constants;

public class Utils {

    public static int makeStringToInteger(String stringNumber){
        return Integer.parseInt(stringNumber);
    }
    public static int figureOutQuotient(Integer dividend, Integer divisor){
        return dividend / divisor;
    }
    public static List<Integer> generateRandomNumber(){
        return Randoms.pickUniqueNumbersInRange(Constants.ONE, Constants.MAX_LOTTO_NUMBER, Constants.MAX_LOTTO_PICK_NUMBER);
    }
    public static List<String> makeStringtoArray(String stringNumber){
        return Arrays.asList(stringNumber.split(","));
    }
    public static List<Integer> makeStringArraytoIntegerArray(List<String> stringarray){
        List<Integer> integerArray = new ArrayList<>();
        for(String string: stringarray){
            integerArray.add(Integer.parseInt(string));
        }return integerArray;
    }
    public static String deleteLastCommas(String inputString){
        return inputString.stripTrailing();
    }
}
