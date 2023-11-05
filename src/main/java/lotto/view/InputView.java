package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.ErrorMessage;
import lotto.domain.LottoNumberRange;
import lotto.utils.Utils;

public class InputView {
    private final static String AMOUNT_FORMAT = "구입금액을 입력해 주세요.";
    private final static String WINNING_NUMBER_FORMAT = "당첨 번호를 입력해 주세요.";
    private final static String BONUS_NUMBER_FORMAT = "보너스 번호를 입력해 주세요.";

    private static void showMessage(String message) {
        System.out.println(message);
    }

    public static int inputAmount() {
        showMessage(AMOUNT_FORMAT);
        return Utils.convertStringToInteger(Console.readLine());
    }

    public static String inputWinningNumbers() {
        showMessage(WINNING_NUMBER_FORMAT);
        return Console.readLine();
    }

    public static int inputBonusNumber() {
        showMessage(BONUS_NUMBER_FORMAT);
        int bonusNumber = Utils.convertStringToInteger(Console.readLine());
        validateNumberRange(bonusNumber);
        return bonusNumber;
    }

    public static void validateNumberRange(int number) {
        boolean isValidRange = (number >= LottoNumberRange.MIN.getValue() && number <= LottoNumberRange.MAX.getValue());

        if (!isValidRange) {
            throw new IllegalArgumentException(
                    ErrorMessage.INVALID_NUMBER_RANGE.getValue()
            );
        }
    }
}
