package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.util.Validator;

public class InputView {
    private static final String LOTTO_NUMBERS_DELIMITER = ",";

    private String getInputValue() {
        String input = Console.readLine();
        Validator.validateInputEmpty(input);
        return input;
    }

    public String getPlayerAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String playAmount = getInputValue();
        System.out.println(playAmount);
        printNewLine();

        return playAmount;

    }

    public List<String> getLottoWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumbers = getInputValue();
        System.out.println(winningNumbers);
        printNewLine();
        return Arrays.asList(winningNumbers.split(LOTTO_NUMBERS_DELIMITER));
    }

    public String getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = getInputValue();
        System.out.println(bonusNumber);
        printNewLine();
        return bonusNumber;
    }

    private void printNewLine() {
        System.out.println();
    }
}
