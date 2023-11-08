package lotto.model;

import static lotto.util.Constant.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;

public class LottoFactory {

    public static Lotto generateLotto() {
        return new Lotto(generateLottoNumber());
    }

    private static List<Integer> generateLottoNumber() {
        List<Integer> lottoPlayerNumber = Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX, LOTTO_NUMBER_COUNT);
        return sortLottoNumber(lottoPlayerNumber);
    }

    private static List<Integer> sortLottoNumber(List<Integer> lottoPlayerNumber) {
        return lottoPlayerNumber.stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
