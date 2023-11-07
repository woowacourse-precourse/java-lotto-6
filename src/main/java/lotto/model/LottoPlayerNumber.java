package lotto.model;

import static lotto.model.Constant.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;

public class LottoPlayerNumber {
    private final List<Integer> lottoPlayerNumber;

    public LottoPlayerNumber() {
        this.lottoPlayerNumber = generateLottoNumber();
    }

    public List<Integer> getLottoPlayerNumber() {
        return lottoPlayerNumber;
    }

    private List<Integer> generateLottoNumber() {
        List<Integer> lottoPlayerNumber = Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX, LOTTO_NUMBER_COUNT);
        return sortLottoNumber(lottoPlayerNumber);
    }

    private static List<Integer> sortLottoNumber(List<Integer> lottoPlayerNumber) {
        return lottoPlayerNumber.stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
