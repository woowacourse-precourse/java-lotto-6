package view;

import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

public class InputView {

    String getMoneyForLottoPurchasing() {
        String money;
        try {
            money = Console.readLine();
        } catch (NoSuchElementException noSuchElementException) {
            throw new IllegalArgumentException();
        }
        return money;
    }

    String getWinningNumber() {
        String winningNumber;
        try {
            winningNumber = Console.readLine();
        } catch (NoSuchElementException noSuchElementException) {
            throw new IllegalArgumentException();
        }
        return winningNumber;
    }
}
