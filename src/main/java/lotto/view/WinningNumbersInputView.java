package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.NumberValidator;
import lotto.util.WinningNumbersConverter;

import java.util.List;

public class WinningNumbersInputView {
    private static final String WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";

    public List<Integer> getInput() {
        while (true) {
            System.out.println(WINNING_NUMBERS_MESSAGE);
            String winningNumbersAsString = Console.readLine();

            try {
                List<Integer> winningNumbers = WinningNumbersConverter.convertStringToList(winningNumbersAsString);
                return winningNumbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
