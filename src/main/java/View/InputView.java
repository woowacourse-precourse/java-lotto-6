package View;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        validateInputInRange(purchaseAmount);
        validateInputIsMultipleOfThousand(purchaseAmount);
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

    private void validateInputInRange(String input) {
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

    private void printInputMoneyMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printInputLottoNumberMessage() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printInputBonusNumberMessage() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printResultMessage() {
        System.out.println("당첨 통계");
    }
}
