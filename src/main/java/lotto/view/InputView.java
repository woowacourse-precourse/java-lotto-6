package lotto.view;

import static lotto.constant.message.ErrorMessage.INVALID_BLANK;
import static lotto.constant.message.InputMessage.INPUT_BONUS_NUMBER;
import static lotto.constant.message.InputMessage.INPUT_MONEY;
import static lotto.constant.message.InputMessage.INPUT_WINNING_NUMBER;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.util.Converter;

public class InputView {

    public int requestMoney() {
        while (true) {
            try {
                String input = getMoney();
                validateEmptyLine(input);
                return Converter.convertInteger(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int requestBonusNumber() {
        while (true) {
            try {
                String input = getBonusNumber();
                validateEmptyLine(input);
                return Converter.convertInteger(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> requestWinningNumbers() {
        while (true) {
            try {
                String input = getWinningNumber();
                validateEmptyLine(input);
                return Converter.convertIntegerList(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String getMoney() {
        System.out.println(INPUT_MONEY);
        return Console.readLine();
    }

    private String getBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        return Console.readLine();
    }

    private String getWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBER);
        return Console.readLine();
    }

    private void validateEmptyLine(String input) {
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException(INVALID_BLANK.getMessage());
        }
    }
}
