package lotto.service.domain.random;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class RandomPickUniqueNumbers{
    public static List<Integer> getAutoUniqueNumbers(int pickNumber) {
        List<Integer> autoUniqueNumbers
          = Randoms.pickUniqueNumbersInRange(1,45,pickNumber);
        Collections.sort(autoUniqueNumbers);
        return autoUniqueNumbers;
    }
    public static int getBonusNumber(List<Integer> getAutoUniqueNumbers){

        return 0;
    }


}
