package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

public class Input {
    public int inputPurchaseAmount() {
        try {
            String purchaseAmount = Console.readLine();
            validatePurchaseAmount(purchaseAmount);
            return Integer.parseInt(purchaseAmount);
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException();
        }
    }

    private void validatePurchaseAmount(String purchaseAmount) {
        int temp;
        try {
            temp = Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        if ((temp / 1000) != 0) {
            throw new IllegalArgumentException();
        }
    }
}