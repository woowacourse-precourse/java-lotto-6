package lotto.domain;

import static lotto.domain.LottoInfoNumbers.*;
import static lotto.view.Messages.*;

import java.util.HashSet;
import java.util.List;

public class Validations {

    public static void validateMaxPurchase(int price) {
        if (price > MAX_LOTTO_PURCHASE_LIMIT) {
            throw new IllegalArgumentException(ERROR_HEADER.concat(ERR0R_MAXIMUM_PURCHASE));
        }
    }

    public static void validateMinPurchase(int price) {
        if (price < LOTTERY_TICKET_PRICE) {
            throw new IllegalArgumentException(ERROR_HEADER.concat(ERROR_MINIMUM_PURCHASE));
        }
    }

    public static void validatePurchase(int price) {
        if (price % LOTTERY_TICKET_PRICE != 0) {
            throw new IllegalArgumentException(ERROR_HEADER.concat(ERROR_NOT_DIVIDED_BY_1000));
        }
    }

    public static void validateNumberWithinRange(int number) {
        if (number < LOTTO_START_NUMBER || number > LOTTO_END_NUMBER) {
            throw new IllegalArgumentException(ERROR_HEADER.concat(ERROR_LOTTO_NUMBER_OUT_OF_BOUNDARY));
        }
    }

    public static void validateListWithinRange(List<Integer> numbers) {
        for (int number : numbers) {
            validateNumberWithinRange(number);
        }
    }

    public static void validateDuplicate(List<Integer> numbers) {
        HashSet<Integer> nonDuplicateNumbers = new HashSet<>(numbers);
        if (numbers.size() != nonDuplicateNumbers.size()) {
            throw new IllegalArgumentException(ERROR_HEADER.concat(ERROR_DUPLICATE_NUMBERS));
        }
    }

    public static void validateDuplicateElementInList(List<Integer> list, int number) {
        if (list.contains(number)) {
            throw new IllegalArgumentException(ERROR_HEADER.concat(ERROR_BONUS_NUMBER));
        }
    }

    public static void validateLengthOfList(List<Integer> list, int length) {
        if (list.size() != length) {
            String exceptionMessage = sizeError(length);
            throw new IllegalArgumentException(exceptionMessage);
        }
    }

    public static void validateParseInt(String string) {
        if (!string.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(ERROR_HEADER.concat(ERROR_NOT_DIGIT));
        }
    }

    public static void validateListParseInt(List<String> list) {
        for (String string : list) {
            validateParseInt(string);
        }
    }
}
