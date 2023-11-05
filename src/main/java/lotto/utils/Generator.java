package lotto.utils;

import static lotto.constants.Rule.LOTTO_SIZE;
import static lotto.constants.Rule.MAX_LOTTO;
import static lotto.constants.Rule.MIN_LOTTO;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.LottoNumber;

public class Generator {
    public static List<LottoNumber> generateIntegerToLottoNumber(List<Integer> lottoNumbers) {
        return lottoNumbers.stream().map(LottoNumber::getInstance).sorted().collect(Collectors.toList());
    }

    public static List<LottoNumber> generateLottoNumbers() {
        List<Integer> randomNumbers = generateRandomNumbers();
        return randomNumbers.stream().map(LottoNumber::getInstance).sorted().collect(Collectors.toList());
    }

    private static List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO.getValue(), MAX_LOTTO.getValue(), LOTTO_SIZE.getValue());
    }
}
