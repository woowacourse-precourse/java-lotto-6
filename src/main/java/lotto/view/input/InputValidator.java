package lotto.view.input;

import lotto.controller.LottoController;
import java.util.regex.Pattern;

public final class InputValidator {

    private InputValidator() {
    }

    public static int validateNumericFormat(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자형식으로 입력해주세요.");
        }
    }

    public static void validateLottoPrice(int lottoPrice) {
        if (lottoPrice %  LottoController.lottoPrice != 0) {
            throw new IllegalArgumentException("[ERROR] 구매금액은 1000단위로 입력해야 합니다.");
        }
    }

    public static void validateNonNegativeNumber(int lottoPrice) {
        if (lottoPrice < 0) {
            throw new IllegalArgumentException("[ERROR] 구매금액은 0보다 커야 합니다.");
        }
    }

    public static void validateWinningNumberFormat(String input) {
        String regex = "^\\d(,\\d)*$";
        if (Pattern.matches(regex, input)) {
            return;
        }
        throw new IllegalArgumentException("[ERROR] 당첨첨금액은 \"1, 2, 3, 4, 5, 6\" 형식이어야 합니다.");
    }
}
