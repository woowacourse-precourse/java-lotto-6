package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.LottoConstant;
import lotto.constant.LottoNumberRange;

import java.util.List;

public class LottoGenerator {

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
                LottoConstant.LOTTO_SIZE
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
