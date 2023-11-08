package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.LottoConstant;
import java.util.List;

public class LottoGenerator {
    private final List<Integer> randomNumbers;

    public LottoGenerator() {
        this.randomNumbers = sortRandomNumbers(generateRandomNumbers());
    }

    public List<Integer> getRandomNumbers() {
        return randomNumbers;
    }

    private List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                LottoConstant.LOTTO_START_RANGE, LottoConstant.LOTTO_END_RANGE, LottoConstant.LOTTO_NUMBER_SIZE);
    }

    private List<Integer> sortRandomNumbers(List<Integer> randomNumbers) {
        return randomNumbers.stream().sorted().toList();
    }
}
