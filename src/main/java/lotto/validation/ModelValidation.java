package lotto.validation;

import static lotto.exception.ExceptionMessage.MESSAGE_DUPLICATE_NUMBER;
import static lotto.exception.ExceptionMessage.MESSAGE_LIMIT_MONEY;
import static lotto.exception.ExceptionMessage.MESSAGE_LIMIT_SIZE;
import static lotto.exception.ExceptionMessage.MESSAGE_RANGE_NUMBER;
import static lotto.exception.ExceptionMessage.MESSAGE_THOUSAND_UNIT;
import static lotto.utils.Constants.LIMIT_MONEY;
import static lotto.utils.Constants.LOTTO_PRICE;
import static lotto.utils.Constants.MAX_LOTTO_NUMBER;
import static lotto.utils.Constants.MIN_LOTTO_NUMBER;
import static lotto.utils.Constants.REMAINDER_ZERO;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.ClientException;
import lotto.utils.Constants;

public class ModelValidation {

    public static void validateSize(List<Integer> numbers) {
        if (numbers.size() != Constants.LOTTO_SIZE) {
            throw new ClientException(MESSAGE_LIMIT_SIZE);
        }
    }

    public static void validateDuplicate(List<Integer> numbers) {
        Set<Integer> validationDuplicate = new HashSet<>(numbers);
        if (numbers.size() != validationDuplicate.size()) {
            throw new ClientException(MESSAGE_DUPLICATE_NUMBER);
        }
    }

    public static void validateRange(List<Integer> numbers) {
        numbers.forEach((number) -> {
            if (number < MIN_LOTTO_NUMBER || MAX_LOTTO_NUMBER < number) {
                throw new ClientException(MESSAGE_RANGE_NUMBER);
            }
        });
    }

    public static void validateThousandUnit(int money) {
        if (money % LOTTO_PRICE > REMAINDER_ZERO) {
            throw new ClientException(MESSAGE_THOUSAND_UNIT);
        }
    }

    public static void validateLimit(int money) {
        if (money > LIMIT_MONEY) {
            throw new ClientException(MESSAGE_LIMIT_MONEY);
        }
    }
}
