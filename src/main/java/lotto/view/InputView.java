package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class InputView {
    private enum InputError {
        ERROR_NUMBER_ONLY("[ERROR] 숫자만 입력되어야 합니다."),
        ERROR_PURCHASE_UNIT("[ERROR] 금액은 1000원으로 나누어 떨어져야 합니다."),
        ERROR_LOTTO_NUMBER("[ERROR] 로또 번호는 6개만 입력돼야 합니다."),
        ERROR_LOTTO_FORM("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
        ERROR_DUPLICATED_NUMBER("[ERROR] 로또 번호는 중복될 수 없습니다.");

        private final String message;

        InputError(String message) {
            this.message = message;
        }
    }
    private static final int PURCHASE_UNIT = 1000;
    private static final int PURCHASE_REMAINDER = 0;

    public InputView() {
    }

    public int inputPurchasePrice() {
        String userInput = Console.readLine();
        int price = validatePrice(userInput);
        validatePurchase(price);
        return price;
    }
    public List<Integer> inputLottoNumbers() {
        String userInput = Console.readLine();
        List<String> inputTokens = Arrays.stream(userInput.split(","))
                .map(String::trim)
                .filter(token -> !token.isEmpty())
                .collect(Collectors.toList());
        for (String token : inputTokens) {
            validateNotNumber(token);
        }
        validateLottoNumber(inputTokens);
        validateDuplicatedNumber(inputTokens);
        return inputTokens.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int inputBonusNumber() {
        String userInput = Console.readLine();
        return validateNotNumber(userInput);
    }

    private int validatePrice(String userInput) {
        try {
            return Integer.parseInt(userInput);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(InputError.ERROR_NUMBER_ONLY.message);
        }
    }

    private int validateNotNumber(String userInput) {
        try {
            int number = Integer.parseInt(userInput);
            validateLottoForm(number);
            return number;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(InputError.ERROR_NUMBER_ONLY.message);
        }
    }

    private void validatePurchase(int money) {
        if ((money % PURCHASE_UNIT) != PURCHASE_REMAINDER) {
            throw new IllegalArgumentException(InputError.ERROR_PURCHASE_UNIT.message);
        }
    }

    private void validateLottoNumber(List<String> lottoNumbers) {
        if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException(InputError.ERROR_LOTTO_NUMBER.message);
        }
    }

    private void validateDuplicatedNumber(List<String> lottoNumbers) {
        Set<String> uniqueNumbers = new HashSet<>(lottoNumbers);
        if (uniqueNumbers.size() != lottoNumbers.size()) {
            throw new IllegalArgumentException(InputError.ERROR_DUPLICATED_NUMBER.message);
        }
    }

    private void validateLottoForm(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(InputError.ERROR_LOTTO_FORM.message);
        }
    }
}
