package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Comparator;
import java.util.List;

public class Utils {
    public static int stringToInt(String string) {
        return Integer.parseInt(string.trim());
    }

    public static List<Integer> createSortedLottoNumbers() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        lottoNumbers.sort(Comparator.naturalOrder());
        return lottoNumbers;
    }
}
