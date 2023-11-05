package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.ErrorMessage;
import lotto.domain.LottoNumberRange;
import lotto.utils.Utils;

public class InputView {
    private final static String GET_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private final static String GET_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private final static String GET_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    private static void showMessage(String message) {
        System.out.println(message);
    }

    public static int inputAmount() {
        showMessage(GET_AMOUNT_MESSAGE);
        return Utils.convertStringToInteger(Console.readLine());
    }

    public static String inputWinningNumbers() {
        showMessage(GET_NUMBERS_MESSAGE);
        return Console.readLine();
    }

    public static int inputBonusNumber() {
        showMessage(GET_BONUS_NUMBER_MESSAGE);
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
