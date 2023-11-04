package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.BonusNumber;
import lotto.domain.BuyAmount;
import lotto.domain.WinningNumber;
import lotto.utils.converter.Converter;
import lotto.utils.validator.Validator;

public class InputView {

    private static final String ONLY_NUMBER_MESSAGE = "숫자만 입력 가능합니다.";
    private static final String INPUT_BUY_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    private InputView() {
    }

    public static BuyAmount getBuyAmountFromInput() {
        try {
            System.out.println(INPUT_BUY_AMOUNT_MESSAGE);
            String buyAmount = read();
            Validator.validateEmpty(buyAmount);
            return new BuyAmount(Long.parseLong(buyAmount));
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ONLY_NUMBER_MESSAGE);
        }
    }

    public static WinningNumber getWinningNumberFromInput() {
        try {
            System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
            String winningNumber = read();
            return new WinningNumber(Converter.convertStringToList(winningNumber));
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ONLY_NUMBER_MESSAGE);
        }
    }

    public static BonusNumber getBonusNumberFromInput() {
        try {
            System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
            String bonusNumber = read();
            Validator.validateEmpty(bonusNumber);
            return new BonusNumber(Integer.parseInt(bonusNumber));
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ONLY_NUMBER_MESSAGE);
        }
    }

    private static String read() {
        return Console.readLine().trim();
    }
}
