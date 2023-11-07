package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;
import lotto.constant.Number;
import lotto.model.LottoDatas;

public class LottoService {

    private final LottoDatas lottoDatas;

    public LottoService(final LottoDatas lottoDatas) {
        this.lottoDatas = lottoDatas;
    }

    public void convertPurchaseToCount(String inputPurchase) {

    }

    public static List<Integer> generateLottoNumbers() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(Number.THE_SMALLEST_LOTTO_NUMBER.getMessage(),
                Number.THE_BIGGEST_LOTTO_NUMBER.getMessage(), Number.LOTTO_LENGTH_LIMIT.getMessage());
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    public void checkValidation(String inputPurchase) {
        Validator.ParseIntNumber(inputPurchase);
        Validator.notZeroOfRestDividedThousand(inputPurchase);
    }
}
