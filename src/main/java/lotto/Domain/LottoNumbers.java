package lotto.Domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.Utils.SystemConstants;

public class LottoNumbers {
    public LottoNumbers() {

    }

    public static List<Integer> createSixLottoNumbers() {
        var sixLottoNumbers = Randoms.pickUniqueNumbersInRange(SystemConstants.MIN_L0TTO_NUMBER,
                SystemConstants.MAX_L0TTO_NUMBER, SystemConstants.LOTTO_NUMBERS_COUNT);
        var sortedNumbers = new ArrayList<>(sixLottoNumbers);
        Collections.sort(sortedNumbers);
        System.out.println(sortedNumbers);
        return sortedNumbers;
    }
}
