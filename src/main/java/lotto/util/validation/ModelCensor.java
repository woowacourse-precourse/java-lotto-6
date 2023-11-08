package lotto.util.validation;

import static lotto.util.content.ErrorMessage.INPUT_UNIT_ERROR;
import static lotto.util.content.ErrorMessage.LOTTO_RANGE_ERROR;
import static lotto.util.content.ErrorMessage.LOTTO_SIZE_ERROR;
import static lotto.util.content.ErrorMessage.UNIQUE_BONUS_ERROR;
import static lotto.util.content.ErrorMessage.UNIQUE_NUMBER_ERROR;
import static lotto.util.rule.GameRule.LOTTO_SIZE;
import static lotto.util.rule.GameRule.MAX_LOTTO_RANGE;
import static lotto.util.rule.GameRule.MIN_LOTTO_RANGE;
import static lotto.util.rule.GameRule.TICKET_PRICE;

import java.util.HashSet;
import java.util.List;
import lotto.domain.Lotto;

public class ModelCensor {

    public static void validatePurchaseUnit(Integer money) {
        if (money % TICKET_PRICE.getValue() != 0) {
            throw new IllegalArgumentException(INPUT_UNIT_ERROR.getContent());
        }
    }

    public static void validateLotto(List<Integer> numbers) {
        if (!isValidLottoNumberSize(numbers)) {
            throw new IllegalArgumentException(LOTTO_SIZE_ERROR.getContent());
        }

        if (hasUniqueNumbers(numbers)) {
            throw new IllegalArgumentException(UNIQUE_NUMBER_ERROR.getContent());
        }
    }
    public static void validateAnnouncementNumber(List<Integer> numbers) {
        if (hasUniqueNumbers(numbers)) {
            throw new IllegalArgumentException(UNIQUE_NUMBER_ERROR.getContent());
        }

        if (numbers.stream().anyMatch(number -> !isValidLottoNumber(number))) {
            throw new IllegalArgumentException(LOTTO_RANGE_ERROR.getContent());
        }
    }

    public static void validateUniqueBonusNumber(Integer input, Lotto numbers) {
        if (numbers.getNumbers().contains(input)) {
            throw new IllegalArgumentException(UNIQUE_BONUS_ERROR.getContent());
        }
    }

    private static boolean isValidLottoNumber(int number) {
        return number >= MIN_LOTTO_RANGE.getValue() && number <= MAX_LOTTO_RANGE.getValue();
    }

    private static boolean isValidLottoNumberSize(List<Integer> numbers) {
        return numbers.size() == LOTTO_SIZE.getValue();
    }

    private static boolean hasUniqueNumbers(List<Integer> numbers) {
        return numbers.size() != new HashSet<>(numbers).size();
    }

}
