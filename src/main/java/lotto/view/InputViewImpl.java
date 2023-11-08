package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.utils.Validation;

public class InputViewImpl implements InputView {
    private final String DELIMITER = ",";
    private final String INSERT_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private final String INSERT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private final String INSERT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private final Validation validation;

    public InputViewImpl(Validation validation) {
        this.validation = validation;
    }

    @Override
    public List<Integer> insertWinningNumbers() {
        String input;
        do {
            printInsertWinningNumbersMessage();
            input = Console.readLine();
        } while (!isValidWinningNumbers(input));
        return convertToNumbers(input);
    }

    private void printInsertWinningNumbersMessage() {
        System.out.println(INSERT_WINNING_NUMBERS_MESSAGE);
    }

    private boolean isValidWinningNumbers(String input) {
        try {
            return validation.isValidWinningNumbers(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private List<Integer> convertToNumbers(String input) {
        List<Integer> numbers = new ArrayList<>();
        String[] strings = input.split(DELIMITER);
        for (String string : strings) {
            numbers.add(Integer.parseInt(string));
        }
        return numbers;
    }

    @Override
    public int insertBonusNumber(List<Integer> winningNumbers) {
        String input;
        do {
            printInsertBonusNumberMessage();
            input = Console.readLine();
        } while (!isValidBonusNumber(input, winningNumbers));
        return Integer.parseInt(input);
    }

    private void printInsertBonusNumberMessage() {
        System.out.println(INSERT_BONUS_NUMBER_MESSAGE);
    }

    private boolean isValidBonusNumber(String input, List<Integer> winningNumbers) {
        try {
            return validation.isValidBonusNumber(input, winningNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public int insertMoney() {
        String input;
        do {
            printInsertMoneyMessage();
            input = Console.readLine();
        } while (!isValidMoney(input));
        return Integer.parseInt(input);
    }

    private void printInsertMoneyMessage() {
        System.out.println(INSERT_MONEY_MESSAGE);
    }

    private boolean isValidMoney(String input) {
        try {
            return validation.isValidMoney(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
