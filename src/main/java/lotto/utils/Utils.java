package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import lotto.constants.Constants;

public class Utils {

    public static int makeStringToInteger(String stringNumber){
        return Integer.parseInt(stringNumber);
    }
    public static int figureOutQuotient(Integer dividend, Integer divisor){
        return dividend / divisor;
    }
    public static List<Integer> generateRandomNumber(){
        return Randoms.pickUniqueNumbersInRange(Constants.ONE, Constants.MAX_LOTTO_NUMBER, Constants.SIX);
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
//    public static String deleteLastCommas(String inputString){
//        return inputString.stripTrailing();
//    }

    public static List<Integer> compareTwoList(List<Integer> firstNumbers, List<Integer> secondNumbers){
        List<Integer> matchNumbers = firstNumbers.stream().filter(o -> secondNumbers.stream()
                .anyMatch(Predicate.isEqual(o))).collect(Collectors.toList());
        return matchNumbers;
    }
}
