package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Screen {
    static public int inputPurchasingAmount() {
        String puchasingAmount = Console.readLine();
        try {
            checkPurchasingAmount(puchasingAmount);
        }
        catch (IllegalArgumentException exception) {
            printErrorMessage(exception.getMessage());
            inputPurchasingAmount();
        }
        return Integer.parseInt(puchasingAmount);
    }

    static private void checkPurchasingAmount(String purchasingAmount) {
        if (!isValidPurchasingAmount(purchasingAmount))
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000 단위이어야 합니다.");
    }

    static private boolean isValidPurchasingAmount(String purchasingAmount) {
        return purchasingAmount.matches("^[1-9]\\d*000$");
    }

    static private void printErrorMessage(String message) {
        System.out.println(message);
    }

    static public void printPurchasingAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }
}
