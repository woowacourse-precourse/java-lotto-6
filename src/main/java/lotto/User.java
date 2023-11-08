package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {

    public int purchaseLotto() {
        try {
            String purchaseMoney = input("구입금액을 입력해 주세요.");
            return getMoneyNumber(purchaseMoney);
        } catch (IllegalArgumentException e) {
            printError(e.getMessage());
            return purchaseLotto();
        }
    }

    public int getMoneyNumber(String purchaseMoney) {
        int moneyNumber;
        try {
            moneyNumber = convertStringToInteger(purchaseMoney);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수 형식으로 입력해야 합니다.\n");
        }

        if (moneyNumber % 1000 != 0) {
            throw new IllegalArgumentException("구입 금액은 1,000원 단위로 입력해야 합니다.\n");
        }
        return moneyNumber;
    }

    public List<Integer> getWinningNumbersAndBonus() {
        List<Integer> winningNumbers = inputAndGetWinningNumbers();
        int bonusNumber = inputAndGetBonusNumber();
        winningNumbers.add(bonusNumber);
        return winningNumbers;
    }

    public List<Integer> inputAndGetWinningNumbers() {
        try {
            String winningLotto = input("\n당첨 번호를 입력해 주세요.");
            return getWinningNumbers(winningLotto);
        } catch (IllegalArgumentException e) {
            printError(e.getMessage());
            return inputAndGetWinningNumbers();
        }
    }

    public int inputAndGetBonusNumber() {
        String bonusLotto = input("\n보너스 번호를 입력해 주세요.");
        return getBonusNumber(bonusLotto);
    }

    private static String input(String printMessage) {
        System.out.println(printMessage);
        return Console.readLine();
    }

    private static void printError(String message) {
        System.out.println("[ERROR] " + message);
    }

    private static List<Integer> getWinningNumbers(String winningLotto) {
        try {
            List<Integer> winnerNumbers = convertStringToIntegerList(winningLotto);
            validateNumbers(winnerNumbers);
            return winnerNumbers;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수만 입력해야 합니다.");
        }
    }

    private static void validateNumbers(List<Integer> winnerNumbers) {
        if (winnerNumbers.size() != 6) {
            throw new IllegalArgumentException("6개의 당첨 번호를 입력해야 합니다.");
        }

        int idx = 0;
        while (idx < winnerNumbers.size()) {
            if (winnerNumbers.get(idx) < 1)
                break;

            if (winnerNumbers.get(idx) > 45)
                break;

            idx++;
        }

        if (idx != winnerNumbers.size()) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }

        Set<Integer> distinctNumbers = new HashSet<>(winnerNumbers);
        if (winnerNumbers.size() != distinctNumbers.size()) {
            throw new IllegalArgumentException("당첨 번호에 중복이 없어야 합니다.");
        }
    }

    private static int getBonusNumber(String bonusNumber) {
        return convertStringToInteger(bonusNumber);
    }

    private static List<Integer> convertStringToIntegerList(String input) {
        List<Integer> resultNumbers = new ArrayList<>();
        String[] inputNumbers = input.split(",");

        for (String inputNumber : inputNumbers) {
            int number = convertStringToInteger(inputNumber);
            resultNumbers.add(number);
        }
        return resultNumbers;
    }

    private static Integer convertStringToInteger(String number) {
        return Integer.parseInt(number);
    }
}
