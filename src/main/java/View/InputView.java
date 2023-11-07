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
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String purchaseAmount = Console.readLine();
                validatePurchaseAmount(purchaseAmount);
                return Integer.parseInt(purchaseAmount);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void validatePurchaseAmount(String purchaseAmount) {
        validateNotBlank(purchaseAmount);
        validateInputIsNumeric(purchaseAmount);
        validateInputIsPositiveNumber(purchaseAmount);
        validateInputIsMultipleOfThousand(purchaseAmount);
    }

    public WinningNumbers askWinningNumbers() {
        Lotto lotto = askWinningLotto();
        while (true) {
            try {
                int bonusNumber = askBonusNumber();
                return new WinningNumbers(lotto, bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Lotto askWinningLotto() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String numbers = Console.readLine();
                validateNumbers(numbers);
                return new Lotto(Stream.of(numbers.split(","))
                        .map(Integer::parseInt)
                        .toList());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int askBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();
        validateNumber(bonusNumber);
        return Integer.parseInt(bonusNumber);
    }

    public void validateNumbers(String numbers) {
        validateNotEndWithDelimiter(numbers);
        List.of(numbers.split(",")).forEach(this::validateNumber);
    }

    public void validateNumber(String number) {
        validateNotBlank(number);
        validateInputIsNumeric(number);
        validateInputIsPositiveNumber(number);
    }

    private void validateNotBlank(String input) {
        if (input == null || input.isBlank() || containsWhitespace(input)) {
            throw new IllegalArgumentException("[ERROR] 공백은 입력할 수 없습니다.");
        }
    }

    private boolean containsWhitespace(String input) {
        Pattern pattern = Pattern.compile("\\s");
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }

    private void validateInputIsNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
        }
    }

    private void validateInputIsPositiveNumber(String input) {
        int purchaseAmount = Integer.parseInt(input);
        if (purchaseAmount < 1) {
            throw new IllegalArgumentException("[ERROR] 0 이상의 숫자를 입력해 주세요.");
        }
    }

    private void validateInputIsMultipleOfThousand(String input) {
        int purchaseAmount = Integer.parseInt(input);
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000 단위로 입력해 주세요.");
        }
    }

    private void validateNotEndWithDelimiter(String input) {
        if (input.endsWith(",")) {
            throw new IllegalArgumentException("[ERROR] 구분자(,)로 끝날 수 없습니다.");
        }
    }
}
