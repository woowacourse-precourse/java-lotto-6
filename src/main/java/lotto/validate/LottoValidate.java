package lotto.validate;

import static lotto.constants.LottoConstants.LOTTO_END;
import static lotto.constants.LottoConstants.LOTTO_SIZE;
import static lotto.constants.LottoConstants.LOTTO_START;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.ExceptionManager;

public class LottoValidate {

    public static void validate(List<Integer> numbers) {
        checkLottoSize(numbers);
        checkLottoNumRange(numbers);
        checkDuplicate(numbers);
    }

    private static void checkLottoSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw ExceptionManager.ERROR_MSG_PREFIX.createIllegalArgumentException(
                    LOTTO_SIZE + "개의 숫자만 가질 수 있습니다.");
        }
    }

    private static void checkLottoNumRange(List<Integer> numbers) {
        numbers.stream().filter(number -> number < LOTTO_START || number > LOTTO_END).findAny()
                .ifPresent(number -> {
                    throw ExceptionManager.ERROR_MSG_PREFIX.createIllegalArgumentException(
                            "로또의 숫자는 " + LOTTO_START + "~" + LOTTO_END + "까지 가능합니다.");
                });
    }

    private static void checkDuplicate(List<Integer> numbers) {
        Set<Integer> setNumbers = new HashSet<>(numbers);
        if (setNumbers.size() != numbers.size()) {
            throw ExceptionManager.ERROR_MSG_PREFIX.createIllegalArgumentException(
                    "로또의 숫자는 중복될 수 없습니다.");
        }
    }
}
