package lotto.Model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoUtil {

    private static final int LOTTO_RANGE_MIN = 1;
    private static final int LOTTO_RANGE_MAX = 45;
    private static final int LOTTO_LENGTH=6;


    public static boolean isNumbersDuplicate(List<Integer> numbers){
        Set<Integer> set = new HashSet<>();
        for (Integer number : numbers) {
            if (!set.add(number)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNumbersOutOfRange(List<Integer> numbers){
        for(Integer number:numbers){
            if(isNumberOutOfRange(number))
                return true;
        }
        return false;
    }


    public static List<Integer> generateRandomNumbers(){
        return Randoms.pickUniqueNumbersInRange(LOTTO_RANGE_MIN,LOTTO_RANGE_MAX,LOTTO_LENGTH);
    }

    public static boolean isProfitSize(List<Integer> numbers){return numbers.size() != LOTTO_LENGTH;}


    public static boolean isNumberOutOfRange(Integer number){
        return number < LOTTO_RANGE_MIN  || LOTTO_RANGE_MAX < number;
    }

}
