package domain;

import static domain.LottoInfoNumbers.*;
import static view.Messages.*;

import java.util.HashSet;
import java.util.List;

public class Validations {

    // 인당 최대 구매 가능 금액은 10만원이다.
    public static void validateMaxPurchase(int price) {
        if (price > MAX_LOTTO_PURCHASE_LIMIT) {
            throw new IllegalArgumentException(ERROR_HEADER.concat(ERR0R_MAXIMUM_PURCHASE));
        }
    }

    // 인당 최소 구매 가능 금액은 1000원이다.
    public static void validateMinPurchase(int price) {
        if (price < LOTTERY_TICKET_PRICE) {
            throw new IllegalArgumentException(ERROR_HEADER.concat(ERROR_MINIMUM_PURCHASE));
        }
    }

    // 1000으로 나누어 떨어져야 한다.
    public static void validatePurchase(int price) {
        if (price % LOTTERY_TICKET_PRICE != 0) {
            throw new IllegalArgumentException(ERROR_HEADER.concat(ERROR_NOT_DIVIDED_BY_1000));
        }
    }

    // 숫자가 1이상 45이하의 범위에 있어야 한다.
    public static void validateNumberWithinRange(int number) {
        if (number < LOTTO_START_NUMBER || number > LOTTO_END_NUMBER) {
            throw new IllegalArgumentException(ERROR_HEADER.concat(ERROR_LOTTO_NUMBER_OUT_OF_BOUNDARY));
        }
    }

    // 리스트 안의 숫자는 모두 1이상 45이하의 범위에 있어야 한다.
    public static void validateListWithinRange(List<Integer> numbers) {
        for (int number : numbers) {
            validateNumberWithinRange(number);
        }
    }

    // 중복되는 숫자가 없어야 한다.
    public static void validateDuplicate(List<Integer> numbers) {
        HashSet<Integer> nonDuplicateNumbers = new HashSet<>(numbers);
        if (numbers.size() != nonDuplicateNumbers.size()) {
            throw new IllegalArgumentException(ERROR_HEADER.concat(ERROR_DUPLICATE_NUMBERS));
        }
    }

    // 보너스 번호로 뽑은 숫자는 기존에 뽑은 6개의 숫자와 중복되면 안된다.
    public static void validateDuplicateElementInList(List<Integer> list, int number) {
        if (list.contains(number)) {
            throw new IllegalArgumentException(ERROR_HEADER.concat(ERROR_BONUS_NUMBER));
        }
    }

    // 입력한 숫자의 개수가 맞는지 검사한다.
    public static void validateLengthOfList(List<Integer> list, int length) {
        if (list.size() != length) {
            String exceptionMessage = sizeError(length);
            throw new IllegalArgumentException(exceptionMessage);
        }
    }

    // 숫자로 파싱이 가능한지 확인한다.
    public static void validateParseInt(String string) {
        if (!string.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(ERROR_HEADER.concat(ERROR_NOT_DIGIT));
        }
    }

    // 리스트에 담긴 모든 숫자가 숫자로 파싱 가능한지 확인한다.
    public static void validateListParseInt(List<String> list) {
        for (String string : list) {
            validateParseInt(string);
        }
    }

    // 모든 입력에는 null이 올 수 없다.
    public static void validateNotNull() {
        throw new NullPointerException();
    }
}
