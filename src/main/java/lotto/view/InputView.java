package lotto.view;

import camp.nextstep.edu.missionutils.Console;
public class InputView {
    private static final String INPUT_LOTTO_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String INPUT_LOTTO_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_LOTTO_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String INVALID_NUMBER_FORMAT = "[ERROR] 숫자만 입력이 가능해요";

    public static int inputLottoAmount() {
        System.out.println(INPUT_LOTTO_AMOUNT);
        return convertToIntegerValue(Console.readLine());
    }

    public static int inputLottoWinningNumbers() {
        System.out.println(INPUT_LOTTO_WINNING_NUMBERS);
        return convertToIntegerValue(Console.readLine());
    }

    public  static int inputLottoBonusNumber() {
        System.out.println(INPUT_LOTTO_BONUS_NUMBER);
        return convertToIntegerValue(Console.readLine());
    }

    private static int convertToIntegerValue(String inputStringValue) {
        try {
            return Integer.parseInt(inputStringValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT);
        }
    }
}
