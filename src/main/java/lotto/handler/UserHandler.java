package lotto.handler;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.ResultView;

import java.util.*;

public class UserHandler {
    public static int getAmountFromUser() {
        System.out.println("구입금액을 입력해 주세요.");
        String userInput = Console.readLine();
        ResultView.printNewLine();

        return validateUserInput(userInput);
    }

    public static int validateUserInput(String userInput) {
        if (userInput == null || userInput.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 금액을 입력해주세요.");
        }

        checkStartWithZero(userInput);
        checkNumerString(userInput);

        int amount = Integer.parseInt(userInput);

        checkUnitAmount(amount);

        return amount;
    }

    public static int getLottoCountFromUser(int amount) {
        return amount/1000;
    }

    private static void checkStartWithZero(String userInput) {
        if (userInput.startsWith("0")) {
            throw new IllegalArgumentException("[ERROR] 0으로 시작하는 숫자를 입력하지 마세요.");
        }
    }

    private static void checkNumerString(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }

    private static void checkUnitAmount(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해주세요.");
        }

    }

    public static List<String> getWinningNumberFromUser() {
        ResultView.printNewLine();
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumberInput = Console.readLine();

        return validateWinningNumberInput(winningNumberInput);
    }

    private static List<String> validateWinningNumberInput(String winningNumberInput) {
        //에러 : 아무것도 입력하지 않았을 경우
        if (winningNumberInput == null || winningNumberInput.isEmpty()) {
            throw new IllegalArgumentException("번호를 입력해주세요.");
        }

        List<String> winningNumbers = splitNumbers(winningNumberInput);
//        checkWinningNumberSize(winningNumbers);

        Set<String> uniqueNumbers = new HashSet<>(winningNumbers);
        if (uniqueNumbers.size() != winningNumbers.size()) {
            throw new IllegalArgumentException("중복된 번호를 입력하였습니다.");
        }

        for (String winningNumber : winningNumbers) {
//            checkWinningNumberString(winningNumber);
            validateWinningNumber(winningNumber);
        }
        return winningNumbers;
    }

    private static List<String> splitNumbers(String winningNumberInput) {
        return Arrays.asList(winningNumberInput.split(","));
    }

    private static void checkWinningNumberSize(String winningNumbers) {

//        if (winningNumbers.size() != 6) {
//            throw new IllegalArgumentException("당첨 번호는 6개를 입력해야 합니다.");
//        }

    }

    private static void validateWinningNumber(String winningNumber) {
        // 문자열을 입력했을 경우, 쉼표로 구분하지 않았을 경우, 로또 번호의 숫자범위를 벗어났을 경우, 6개가 아닌경우, 중복되는 경우
        int number;
        try {
            number = Integer.parseInt(winningNumber.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }

        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("로또 번호는 1부터 45까지의 숫자입니다.");
        }
    }

}
