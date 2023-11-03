package lotto.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import lotto.lotto.LottoConstants;

public class RandomLottoNumberGenerator implements NumberGenerator {

    @Override
    public List<Integer> generate() {
        return generateRandomSortedNumbers();
    }

    private List<Integer> generateRandomSortedNumbers() {
        List<Integer> numbers = generateNumbers();
        return numbers.stream().sorted().collect(Collectors.toList());
    }

    private List<Integer> generateNumbers() {
        return Randoms.pickUniqueNumbersInRange(LottoConstants.MIN_LOTTO_NUMBER,
                LottoConstants.MAX_LOTTO_NUMBER,
                LottoConstants.LOTTO_NUMBER_LENGTH);
    }
}
