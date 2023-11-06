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
        printInputMoneyMessage();
        String purchaseAmount = Console.readLine();
        validatePurchaseAmount(purchaseAmount);
        return Integer.parseInt(Console.readLine());
    }

    public void validatePurchaseAmount(String purchaseAmount) {
        validateNotBlank(purchaseAmount);
        validateInputIsNumeric(purchaseAmount);
        validateInputIsPositiveNumber(purchaseAmount);
        validateInputIsMultipleOfThousand(purchaseAmount);
    }

    public WinningNumbers askWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String numbers = Console.readLine();
        validateWinningNumbers(numbers);
        List<Integer> winningNumbers = Stream.of(numbers.split(","))
            .map(Integer::parseInt)
            .toList();

        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();
        validateBonusNumber(bonusNumber);
        return new WinningNumbers(new Lotto(winningNumbers), Integer.parseInt(bonusNumber));
    }

    public void validateWinningNumbers(String winningNumbers) {
        List<String> winningNumber = List.of(winningNumbers.split(","));
        validateNotBlank(winningNumbers);
        validateNotEndWithDelimiter(winningNumbers);
        winningNumber.forEach(this::validateInputIsNumeric);
        winningNumber.forEach(this::validateInputIsPositiveNumber);
        winningNumber.forEach(this::validateInputInRange);
    }

    public void validateBonusNumber(String bonusNumber) {
        validateNotBlank(bonusNumber);
        validateInputIsNumeric(bonusNumber);
        validateInputIsPositiveNumber(bonusNumber);
        validateInputInRange(bonusNumber);
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
        if (purchaseAmount < 0) {
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

    private void validateInputInRange(String input) {
        int number = Integer.parseInt(input);
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 1 ~ 45 사이의 숫자를 입력해 주세요.");
        }
    }

    private void printInputMoneyMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printResultMessage() {
        System.out.println("당첨 통계");
    }
}
