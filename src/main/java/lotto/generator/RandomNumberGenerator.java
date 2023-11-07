package lotto.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RandomNumberGenerator {
    private static final int STARTING_RANGE = 1;
    private static final int END_RANGE = 45;
    private static final int COUNT = 6;

    public static List<Integer> generateUniqueRandomValues(){
        return Randoms.pickUniqueNumbersInRange(STARTING_RANGE, END_RANGE, COUNT);
    }

    // 음.. 더 분리할 수 있을거 같은 코드 ( 다른 클래스로)
    public static int generateRandomExcludedNumbers(List<Integer> filterNums) {
        List<Integer> allNumbers = NumberGenerator.generateAllNumbers();
        List<Integer> filteredNumbers = NumberGenerator.generateFilteredNumbers(allNumbers, filterNums);

        return Randoms.pickNumberInList(filteredNumbers);
    }
}
