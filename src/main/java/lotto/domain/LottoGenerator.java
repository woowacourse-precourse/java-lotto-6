package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGenerator {
    private final List<Integer> randomNumbers;

    public LottoGenerator() {
        this.randomNumbers = sort(generateRandomNumbers());
    }

    public List<Integer> getRandomNumbers() {
        return randomNumbers;
    }

    private List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(LottoPolicy.LOTTO_START_NUMBER, LottoPolicy.LOTTO_END_NUMBER,
                LottoPolicy.LOTTO_SIZE);
    }

    private List<Integer> sort(List<Integer> numbers) {
        return numbers.stream().sorted().collect(Collectors.toList());
    }
}
