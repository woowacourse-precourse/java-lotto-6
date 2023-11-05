package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
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
}
