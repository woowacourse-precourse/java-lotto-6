package lotto.domain.machine;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.List;

public class LottoNumberGeneratorImpl implements LottoNumberGenerator {
    public static final int LOTTO_NUMBER_START = 1;
    public static final int LOTTO_NUMBER_END = 45;
    public static final int LOTTO_NUMBER_COUNT = 6;

    @Override
    public List<Integer> generateLottoNumbers() {
        return pickUniqueNumbersInRange(LOTTO_NUMBER_START, LOTTO_NUMBER_END, LOTTO_NUMBER_COUNT)
                .stream()
                .sorted()
                .toList();
    }
}
