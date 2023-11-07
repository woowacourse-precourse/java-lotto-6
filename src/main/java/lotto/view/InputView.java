package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.validator.Validator;

public class InputView {
    private static final String INPUT_PURCHASE_AMOUNT_MASSAGE = "구입 금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS_MASSAGE = "당첨 번호를 입력해 주세요.";

    private final Validator validator = new Validator();

    public String inputPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT_MASSAGE);
        return Console.readLine();
    }

    public int parsePurchaseAmount(String input) {
        validatePurchaseAmount(input);
        return Integer.parseInt(input);
    }

    public String inputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS_MASSAGE);
        return Console.readLine();
    }

    public List<Integer> parseWinningNumbers(String input) {
        try {
            List<Integer> winningNumbers = Arrays.stream(input.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            return winningNumbers;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 문자열이 입력되었습니다.");
        }
    }

    private void validatePurchaseAmount(String input) {
        if (validator.containsNonNumericCharacters(input)) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 문자열이 입력되었습니다.");
        }
        if (!validator.isPositiveMultiplesOfThousand(Integer.parseInt(input))) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }
}
