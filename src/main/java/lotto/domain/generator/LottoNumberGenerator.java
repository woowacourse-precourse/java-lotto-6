package lotto.domain.generator;

import static lotto.domain.constant.DomainConstant.COMMA;
import static lotto.domain.constant.DomainConstant.MAX_RANGE;
import static lotto.domain.constant.DomainConstant.MIN_RANGE;
import static lotto.domain.constant.DomainConstant.NUMBERS_COUNT;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;

public final class LottoNumberGenerator {
    public List<Integer> createLottoNumbers() {
        final List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_RANGE, MAX_RANGE, NUMBERS_COUNT);

        return numbers.stream()
                .sorted()
                .toList();
    }

    public List<Integer> createByInput(final String input) {
        return Arrays.stream(input.split(COMMA))
                .map(Integer::parseInt)
                .sorted()
                .toList();
    }
}
