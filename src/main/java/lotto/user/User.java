package lotto.user;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class User {
    private static final Payment PAYMENT = new Payment();
    private static final Winning WINNING = new Winning();
    private static final Bonus BONUS = new Bonus();

    public int purchaseLotto() {
        try {
            String purchaseMoney = input("구입금액을 입력해 주세요.");
            return PAYMENT.getMoneyNumber(purchaseMoney);
        } catch (IllegalArgumentException e) {
            printError(e.getMessage());
            System.out.println();
            return purchaseLotto();
        }
    }

    public List<Integer> getWinningNumbersAndBonus() {
        List<Integer> winningNumbers = new ArrayList<>(
                inputAndGetWinningNumbers()
        );
        int bonusNumber = inputAndGetBonusNumber(winningNumbers);
        winningNumbers.add(bonusNumber);
        return winningNumbers;
    }

    public List<Integer> inputAndGetWinningNumbers() {
        try {
            String winningLotto = input("\n당첨 번호를 입력해 주세요.");
            return WINNING.getWinningNumbers(winningLotto);
        } catch (IllegalArgumentException e) {
            printError(e.getMessage());
            return inputAndGetWinningNumbers();
        }
    }

    public int inputAndGetBonusNumber(List<Integer> winningNumbers) {
        try {
            String bonusLotto = input("\n보너스 번호를 입력해 주세요.");
            return BONUS.getBonusNumber(bonusLotto, winningNumbers);
        } catch (IllegalArgumentException e) {
            printError(e.getMessage());
            return inputAndGetBonusNumber(winningNumbers);
        }
    }

    private static String input(String printMessage) {
        System.out.println(printMessage);
        return Console.readLine();
    }

    private static void printError(String message) {
        System.out.println("[ERROR] " + message);
    }
}
