package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public record LottoNumber(int number) {

    private static final int LOTTO_NUMBER_RANGE_START = 1;
    private static final int LOTTO_NUMBER_RANGE_END = 45;

    public LottoNumber {
        validate(number);
    }

    public static Set<LottoNumber> createRandomLottoNumbers(int count) {
        return Randoms.pickUniqueNumbersInRange(
                LOTTO_NUMBER_RANGE_START, LOTTO_NUMBER_RANGE_END, count)
            .stream()
            .map(LottoNumber::new)
            .collect(Collectors.toSet());
    }

    private void validate(int number) {
        if (number < LOTTO_NUMBER_RANGE_START || LOTTO_NUMBER_RANGE_END < number) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
