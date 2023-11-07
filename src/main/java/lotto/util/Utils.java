package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Comparator;
import java.util.List;

public class Utils {
    private static final int NUMBER_START_INCLUSIVE = 1;
    private static final int NUMBER_END_INCLUSIVE = 45;
    private static final int NUMBER_PICK_COUNT = 6;
    
    public static int stringToInt(String string) {
        return Integer.parseInt(string.trim());
    }

    public static List<Integer> createSortedLottoNumbers() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(NUMBER_START_INCLUSIVE, NUMBER_END_INCLUSIVE,
                                                                      NUMBER_PICK_COUNT);
        lottoNumbers.sort(Comparator.naturalOrder());
        return lottoNumbers;
    }
}
