package lotto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.Application.LOTTO_SIZE;

public class LottoGameValidator {

    public static void validateInputAmount(String inputBuyAmount) {
        validateNumericInput(inputBuyAmount);
        validateBuyAmountFormat(inputBuyAmount);
    }

    public static void validateLotteNumber(List<Integer> numbers) {
        validateLottoSize(numbers);
        validateLottoDuplicate(numbers);
    }

    public static void validateWinningLottoNumber(String inputWinningLottoNumber) {
        validateLottoNumberFormat(inputWinningLottoNumber);
        validateLottoNumberRange(inputWinningLottoNumber);
        validateDuplicateNumbers(inputWinningLottoNumber);
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

    private static void validateLottoDuplicate(List<Integer> numbers) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(numbers);
        if (nonDuplicateNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호들은 중복될 수 없습니다.");
        }
    }

    private static void validateLottoNumberRange(String inputLottoNumber) {
        List<Integer> lottoNumbers = Arrays
                .stream(inputLottoNumber.split(","))
                .map(Integer::parseInt)
                .toList();

        for (int number : lottoNumbers) {
            if (number < Application.LOTTO_MIN_NUMBER || number > Application.LOTTO_MAX_NUMBER) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 " +
                        Application.LOTTO_MIN_NUMBER + "부터 " +
                        Application.LOTTO_MAX_NUMBER + " 사이의 숫자여야 합니다.");
            }
        }
    }

    private static void validateDuplicateNumbers(String inputLottoNumber) {
        List<Integer> lottoNumbers = Arrays
                .stream(inputLottoNumber.split(","))
                .map(Integer::parseInt)
                .toList();

        Set<Integer> nonDuplicateNumbers = new HashSet<>(lottoNumbers);
        if (nonDuplicateNumbers.size() != lottoNumbers.size()) {
            throw new IllegalArgumentException("[ERROR] 서로 중복되지 않는 수를 입력해야 합니다.");
        }
    }

    private static void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개만 가능합니다.");
        }
    }

    private static void validateLottoNumberFormat(String inputLottoNumber) {
        if (!inputLottoNumber.matches("^(\\d+,)*\\d+$")) {
            throw new IllegalArgumentException("[ERROR] 콤마를 올바르게 찍어야 합니다");
        }
    }
}
