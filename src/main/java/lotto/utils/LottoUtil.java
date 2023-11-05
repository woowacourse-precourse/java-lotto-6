package lotto.utils;

import static lotto.message.ErrorMessage.AMOUNT_IS_NOT_IN_THOUSAND_WON_UNITS;
import static lotto.message.ErrorMessage.LOTTO_NUMBER_IS_NOT_IN_RANGE;

import camp.nextstep.edu.missionutils.Randoms;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;

public class LottoUtil {
    public static void validateLottoNum(int num) {
        if (num < 1) {
            throw new IllegalArgumentException(LOTTO_NUMBER_IS_NOT_IN_RANGE.getMessage());
        }
        if (num > 45) {
            throw new IllegalArgumentException(LOTTO_NUMBER_IS_NOT_IN_RANGE.getMessage());
        }
    }

    public static List<Lotto> generateLottos(BigDecimal numberOfLottoPurchased, LottoGenerator lottoGenerator) {
        List<Lotto> lottos = new ArrayList<>();
        while (numberOfLottoPurchased.compareTo(BigDecimal.ZERO) > 0) {
            lottos.add(lottoGenerator.generate());
            numberOfLottoPurchased = numberOfLottoPurchased.subtract(BigDecimal.ONE);
        }
        return lottos;
    }

}
