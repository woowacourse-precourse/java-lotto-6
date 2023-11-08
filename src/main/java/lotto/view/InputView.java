package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.util.Validator;

public class InputView {
    private static final String LOTTO_NUMBERS_DELIMITER = ",";
    private static final String ASK_PLAYER_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String ASK_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String ASK_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    private String getInputValue() {
        String input = Console.readLine();
        Validator.validateInputEmpty(input);
        return input;
    }

    public String getPlayerAmount() {
        System.out.println(ASK_PLAYER_AMOUNT_MESSAGE);
        String playAmount = getInputValue();
        System.out.println(playAmount);
        printNewLine();

        return playAmount;

    }

    public List<String> getLottoWinningNumbers() {
        System.out.println(ASK_WINNING_NUMBER_MESSAGE);
        String winningNumbers = getInputValue();
        System.out.println(winningNumbers);
        printNewLine();
        return Arrays.asList(winningNumbers.split(LOTTO_NUMBERS_DELIMITER));
    }

    public String getBonusNumber() {
        System.out.println(ASK_BONUS_NUMBER_MESSAGE);
        String bonusNumber = getInputValue();
        System.out.println(bonusNumber);
        printNewLine();
        return bonusNumber;
    }

    private void printNewLine() {
        System.out.println();
    }
}
