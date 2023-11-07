package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.Validator;

public class InputView {
    private static final String INPUT_PURCHASE_AMOUNT_MASSAGE = "구입 금액을 입력해 주세요.";

    private final Validator validator = new Validator();

    public String inputPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT_MASSAGE);
        return Console.readLine();
    }

    public int parsePurchaseAmount(String input) {
        validatePurchaseAmount(input);
        return Integer.parseInt(input);
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
