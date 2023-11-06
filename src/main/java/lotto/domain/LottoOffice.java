package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoOffice {

    private static final int COUNT_ZERO = 0;
    private static final int COUNT_ONE = 1;

    private int compareNumbers(List<Integer> lottoNumber, List<Integer> winningNumbers) {
        int cnt = 0;
        for (Integer num : lottoNumber) {
            if (winningNumbers.contains(num)) cnt += COUNT_ONE;
        }
        return cnt;
    }

    private int compareBonusNumber(List<Integer> winningNumbers, int bonus) {
        if (winningNumbers.contains(bonus)) return COUNT_ONE;
        return COUNT_ZERO;
    }

}
