package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public record LottoNumber(int number) {

    private static final int LOTTO_NUMBER_RANGE_START = 1;
    private static final int LOTTO_NUMBER_RANGE_END = 45;
    private static final String ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE = "[ERROR] 로또 숫자는 %d 이상 %d 이하여야 합니다. 다시 입력하세요.";

    public LottoNumber {
        validateLottoNumberInRange(number);
    }

    public static List<LottoNumber> createRandomLottoNumbers(int count) {
        return Randoms.pickUniqueNumbersInRange(
                LOTTO_NUMBER_RANGE_START, LOTTO_NUMBER_RANGE_END, count)
            .stream()
            .map(LottoNumber::new)
            .toList();
    }

    private void validateLottoNumberInRange(int number) {
        if (number < LOTTO_NUMBER_RANGE_START || LOTTO_NUMBER_RANGE_END < number) {
            throw new IllegalArgumentException(ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE.formatted(LOTTO_NUMBER_RANGE_START, LOTTO_NUMBER_RANGE_END));
        }
    }
}
