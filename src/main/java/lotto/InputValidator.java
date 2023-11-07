package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {
    static final String SEPARATOR = ",";

    public static int validateLottoNumber(String input) throws IllegalArgumentException {
        int number = validateInteger(input);

        if (number < Lotto.LOTTO_NUMBER_MIN || number > Lotto.LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException(String.format("로또 번호는 %d부터 %d 사이의 숫자여야 합니다.", Lotto.LOTTO_NUMBER_MIN, Lotto.LOTTO_NUMBER_MAX));
        }

        return number;
    }

    static public int validateInteger(String input) throws IllegalArgumentException {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다.");
        }
    }

    static public int validatePurchaseCount(String input) throws IllegalArgumentException {
        int amount = validateInteger(input);

        if (amount < 0) {
            throw new IllegalArgumentException("0이상의 수를 입력해야 합니다.");
        }

        if (amount % LottoSimulator.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("1,000원으로 나누어 떨어지는 수를 입력해야 합니다.");
        }

        return amount / LottoSimulator.LOTTO_PRICE;
    }

    public static List<Integer> validateWinningNumbers(String input) throws IllegalArgumentException {
        List<String> strings = List.of(input.split(SEPARATOR));

        if (strings.size() != Lotto.LOTTO_SIZE) {
            throw new IllegalArgumentException(String.format("로또 정답의 크기는 %d이어야 합니다.", Lotto.LOTTO_SIZE));
        }

        List<Integer> winningNumbers = new ArrayList<>();
        for (String numberString : strings) {
            winningNumbers.add(validateLottoNumber(numberString));
        }

        Set<Integer> check = new HashSet<>(winningNumbers);
        if (check.size() != Lotto.LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 정답은 중복되지 않은 6개의 값이어야 합니다.");
        }

        return winningNumbers;
    }

    public static int validateBonusNumber(String input) throws IllegalArgumentException {
        return validateLottoNumber(input);
    }
}
