package lotto.generator;

import static lotto.globar.GlobalConstants.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;


public class RandomNumberGenerator {
    public static List<Integer> generateUniqueRandomValues(){
        return Randoms.pickUniqueNumbersInRange(LOTTO_STARTING_RANGE, LOTTO_END_RANGE, LOTTO_NUM_SIZE);
    }

    public static int generateRandomExcludedNumbers(List<Integer> filterNums) {
        List<Integer> allLottoNumbers = NumberGenerator.generateAllLottoNumbers();
        List<Integer> filteredNumbers = NumberGenerator.generateFilteredNumbers(allLottoNumbers, filterNums);

        return Randoms.pickNumberInList(filteredNumbers);
    }
}
