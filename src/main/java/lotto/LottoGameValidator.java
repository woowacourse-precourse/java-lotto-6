package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.Application.LOTTO_SIZE;

public class LottoGameValidator {

    public static void validateInputAmount(String inputBuyAmount) {
        validateNumericInput(inputBuyAmount);
        validateBuyAmountFormat(inputBuyAmount);
    }

    private static void validateNumericInput(String inputBuyAmount) {
        try {
            int buyAmount = Integer.parseInt(inputBuyAmount);

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력하시오.");
        }
    }

    private static void validateBuyAmountFormat(String inputBuyAmount) {
        int buyAmount = Integer.parseInt(inputBuyAmount);

        if (buyAmount <= 0 || buyAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 0보다 큰 1000원 단위의 숫자로 입력해야 합니다");
        }
    }

    public static void validateLotteNumber(List<Integer> numbers) {
        validateLottoDuplicate(numbers);
        validateLottoSize(numbers);
    }

    private static void validateLottoDuplicate(List<Integer> numbers) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(numbers);
        if (nonDuplicateNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호들은 중복될 수 없습니다.");
        }
    }


    private static void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개만 가능합니다.");
        }
    }
}
