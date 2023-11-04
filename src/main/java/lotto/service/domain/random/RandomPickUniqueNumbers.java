package lotto.service.domain.random;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class RandomPickUniqueNumbers{
    private static List<Integer> autoUniqueNumbers;
    public static List<Integer> getAutoUniqueNumbers(int pickNumber) {
        autoUniqueNumbers
          = Randoms.pickUniqueNumbersInRange(1,45,pickNumber);
        Collections.sort(autoUniqueNumbers);
        return autoUniqueNumbers;
    }
    public static int getBonusNumber(){
        int missNumber;
        do{
           missNumber = Randoms.pickNumberInRange(1,45);
        }while (autoUniqueNumbers.contains(missNumber));
        return missNumber;
    }


}
