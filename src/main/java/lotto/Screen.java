package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

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

    static public void printPurchasingAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    static public void printAllLottos(List<Lotto> lottos) {
        System.out.printf("%s개를 구매했습니다.%n", lottos.size());
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    static private void printErrorMessage(String message) {
        System.out.println(message);
    }

}
