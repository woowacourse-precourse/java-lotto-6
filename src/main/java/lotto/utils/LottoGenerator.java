package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.LottoNumberRange;

import java.util.List;
import java.util.Set;

public class LottoGenerator {
    private Set<Integer> numbers;
    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(
                LottoNumberRange.MIN.getValue(),
                LottoNumberRange.MAX.getValue()
        );
    }

    public List<Integer> generateLottoNumbers() {
        while (numbers.size() < 6) {
            numbers.add(generateRandomNumber());
        }

        return numbers.stream().toList();
    }

    public int generateBonusNumber(List<Integer> lotto) {
        int result = generateRandomNumber();
        while (lotto.contains(result)) {
            result = generateRandomNumber();
        }

        return result;
    }
}
