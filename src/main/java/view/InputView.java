package view;

import Exception.BonusNumberNotNumberException;
import Exception.MoneyNotNumberException;
import Exception.MoneyZeroException;
import Exception.WinningNumberFormatException;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class InputView {
    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String WINNING_NUMBER_PATTERN = "[0-9]+,[0-9]+,[0-9]+,[0-9]+,[0-9]+,[0-9]+";

    public int inputMoney() {
        System.out.println(INPUT_MONEY_MESSAGE);
        String money = Console.readLine();
        validateMoney(money);
        return Integer.parseInt(money);
    }

    private void validateMoney(String money) {
        isNumber(money);
        isZero(money);
    }

    private void isNumber(String input) throws IllegalStateException {
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new MoneyNotNumberException();
            }
        }
    }

    private void isZero(String input) throws IllegalStateException {
        if (input.equals("0")) {
            throw new MoneyZeroException();
        }
    }

    public List<Integer> inputWinningNumber() {
        System.out.println("\n" + INPUT_WINNING_NUMBER_MESSAGE);
        String winningNumber = Console.readLine();
        validateWinningNumber(winningNumber);
        return winningNumberStringToList(winningNumber);
    }

    private void validateWinningNumber(String winningNumber) {
        if (!isWinningNumberFormat(winningNumber)) {
            throw new WinningNumberFormatException();
        }
    }

    private boolean isWinningNumberFormat(String winningNumber) {
        return Pattern.matches(WINNING_NUMBER_PATTERN, winningNumber);
    }

    private List<Integer> winningNumberStringToList(String winningNumber) {
        String[] stringNumbers = winningNumber.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String number : stringNumbers) {
            numbers.add(Integer.parseInt(number));
        }
        return numbers;
    }

    public int inputBonusNumber() {
        System.out.println("\n" + INPUT_BONUS_NUMBER_MESSAGE);
        String bonusNumber = Console.readLine();
        validateBonusNUmber(bonusNumber);
        return Integer.parseInt(bonusNumber);
    }

    private void validateBonusNUmber(String bonusNumber) {
        for (char c : bonusNumber.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new BonusNumberNotNumberException();
            }
        }
    }
}
