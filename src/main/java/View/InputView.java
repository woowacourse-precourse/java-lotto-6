package View;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import lotto.Lotto;
import lotto.WinningNumbers;

public class InputView {

    public int askPurchaseAmount() {
        boolean isNotCorrectInput = true;
        String purchaseAmount = "";
        while (isNotCorrectInput) {
            System.out.println("구입금액을 입력해 주세요.");
            purchaseAmount = Console.readLine();
            isNotCorrectInput = validatePurchaseAmount(purchaseAmount);
        }
        return Integer.parseInt(purchaseAmount);
    }

    public boolean validatePurchaseAmount(String purchaseAmount) {
        try {
            validateNotBlank(purchaseAmount);
            validateInputIsNumeric(purchaseAmount);
            validateInputIsPositiveNumber(purchaseAmount);
            validateInputIsMultipleOfThousand(purchaseAmount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }
        return false;
    }

    public WinningNumbers askWinningNumbers() {
        Lotto lotto = askWinningLotto();
        int bonusNumber = askBonusNumber();
        return new WinningNumbers(lotto, bonusNumber);
    }

    public Lotto askWinningLotto() {
        boolean isNotCorrectInput = true;
        String numbers = "";
        while (isNotCorrectInput) {
            System.out.println("당첨 번호를 입력해 주세요.");
            numbers = Console.readLine();
            isNotCorrectInput = validateNumbers(numbers);
        }
        return new Lotto(Stream.of(numbers.split(","))
                .map(Integer::parseInt)
                .toList());
    }

    private int askBonusNumber() {
        boolean isNotCorrectInput = true;
        String bonusNumber = "";
        while (isNotCorrectInput) {
            System.out.println("보너스 번호를 입력해 주세요.");
            bonusNumber = Console.readLine();
            isNotCorrectInput = validateNumber(bonusNumber);
        }
        return Integer.parseInt(bonusNumber);
    }

    public boolean validateNumbers(String numbers) {
        try {
            validateNotEndWithDelimiter(numbers);
            List.of(numbers.split(",")).forEach(this::validateNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }
        return false;
    }

    public boolean validateNumber(String number) {
        try {
            validateNotBlank(number);
            validateInputIsNumeric(number);
            validateInputIsPositiveNumber(number);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }
        return false;
    }

    private void validateNotBlank(String input) throws IllegalArgumentException {
        if (input == null || input.isBlank() || containsWhitespace(input)) {
            throw new IllegalArgumentException("[ERROR] 공백은 입력할 수 없습니다.");
        }
    }

    private boolean containsWhitespace(String input) {
        Pattern pattern = Pattern.compile("\\s");
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }

    private void validateInputIsNumeric(String input) throws IllegalArgumentException {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
        }
    }

    private void validateInputIsPositiveNumber(String input) throws IllegalArgumentException {
        int purchaseAmount = Integer.parseInt(input);
        if (purchaseAmount < 1) {
            throw new IllegalArgumentException("[ERROR] 0 이상의 숫자를 입력해 주세요.");
        }
    }

    private void validateInputIsMultipleOfThousand(String input) throws IllegalArgumentException {
        int purchaseAmount = Integer.parseInt(input);
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000 단위로 입력해 주세요.");
        }
    }

    private void validateNotEndWithDelimiter(String input) throws IllegalArgumentException {
        if (input.endsWith(",")) {
            throw new IllegalArgumentException("[ERROR] 구분자(,)로 끝날 수 없습니다.");
        }
    }
}
