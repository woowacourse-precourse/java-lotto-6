package lotto.Function;

import java.util.List;

import lotto.Util.ErrorMessage;
import static lotto.Lotto.*;
import static lotto.Domain.Money.*;

public class Validate {
    //각 도메인 및 기능들의 검증 기능을 분리함
    public static void validatePrizeNumber(String[] input) {
        if (input.length != LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.PRIZE_SIZE_ERROR_MESSAGE);
        }
    }
    public static void validateBonusNumber(int prizeBonusNumber) {
        if (prizeBonusNumber < MIN_LOTTO_RANGE || prizeBonusNumber > MAX_LOTTO_RANGE) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_RANGE_ERROR_MESSAGE);
        }
    }
    public static void validateLotto(List<Integer> numbers) {
        validateNumberSize(numbers);
        validateNumberRange(numbers);
        validateNumber_NotEqual(numbers);
    }

    private static void validateNumberSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_SIZE_ERROR_MESSAGE);
        }
    }

    private static void validateNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < MIN_LOTTO_RANGE || number > MAX_LOTTO_RANGE) {
                throw new IllegalArgumentException(ErrorMessage.NUMBER_RANGE_ERROR_MESSAGE);
            }
        }
    }
    private static void validateNumber_NotEqual(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                checkNotEqual(numbers.get(i), numbers.get(j));
            }
        }
    }

    private static void checkNotEqual(Integer number1,Integer number2) {
        if (number1.equals(number2)) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_DUPLICATE_ERROR_MESSAGE);
        }
    }

    public static void validateMoney(int inputMoney) {
        validateZero(inputMoney);
        validateThousandMoney(inputMoney);
    }

    private static void validateZero(int inputMoney) {
        if (inputMoney == ZERO) {
            throw new IllegalArgumentException(ErrorMessage.ZERO_ERROR_MESSAGE);
        }
    }

    private static void validateThousandMoney(int inputMoney) {
        if (inputMoney % THOUSAND != ZERO) {
            throw new IllegalArgumentException(ErrorMessage.THOUSAND_ERROR_MESSAGE);
        }
    }
}
