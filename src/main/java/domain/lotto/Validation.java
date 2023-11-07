package domain.lotto;

import static domain.lotto.LottoInfoNumbers.*;
import static domain.lotto.Messages.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validation {

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

    // 입력한 숫자의 개수가 맞는지 검사한다.
    public static void validateLengthOfList(List<Integer> list, int length) {
        if (list.size() != length) {
            String exceptionMessage = sizeError(length);
            throw new IllegalArgumentException(exceptionMessage);
        }
    }


    // 모든 입력에는 null이 올 수 없다.
    public static void validateNotNull() {
        throw new NullPointerException();
    }
}
