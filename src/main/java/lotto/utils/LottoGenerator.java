package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.LottoNumberRange;

import java.util.List;

public class LottoGenerator {
    private static final int MAX_SIZE = 6;

    private static int generateRandomNumber() {
        return Randoms.pickNumberInRange(
                LottoNumberRange.MIN.getValue(),
                LottoNumberRange.MAX.getValue()
        );
    }

    public static List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                LottoNumberRange.MIN.getValue(),
                LottoNumberRange.MAX.getValue(),
                MAX_SIZE
        );
    }

    public static int generateBonusNumber(List<Integer> lotto) {
        int result = 0;

        do {
            result = generateRandomNumber();
        } while (lotto.contains(result));

        return result;
    }
}
