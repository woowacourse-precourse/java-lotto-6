package lotto.model;

import static lotto.model.Constant.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
        Set<Integer> lottoPlayerNumber = new HashSet<>();

        while (lottoPlayerNumber.size() < LOTTO_NUMBER_COUNT) {
            lottoPlayerNumber.add(Randoms.pickNumberInRange(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX));
        }
        return sortLottoNumber(lottoPlayerNumber);
    }

    private static List<Integer> sortLottoNumber(Set<Integer> lottoPlayerNumber) {
        return lottoPlayerNumber.stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
