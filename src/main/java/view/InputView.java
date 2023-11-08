package view;

import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

public class InputView {

    public static String getMoneyForLottoPurchasing() {
        String money;
        try {
            money = Console.readLine();
        } catch (NoSuchElementException noSuchElementException) {
            throw new IllegalArgumentException();
        }
        return money;
    }

    public static String getWinningNumber() {
        String winningNumber;
        try {
            winningNumber = Console.readLine();
        } catch (NoSuchElementException noSuchElementException) {
            throw new IllegalArgumentException();
        }
        return winningNumber;
    }

    public static String getBonusNumber() {
        String bonusNumber;
        try {
            bonusNumber = Console.readLine();
        } catch (NoSuchElementException noSuchElementException) {
            throw new IllegalArgumentException();
        }
        return bonusNumber;
    }
}
