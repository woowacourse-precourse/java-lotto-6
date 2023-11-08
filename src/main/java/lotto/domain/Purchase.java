package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import static javax.swing.JOptionPane.ERROR_MESSAGE;

public class Purchase {
    public int inputPurchaseAmount() {
        int inputPurchaseAmount = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String originInputPurchaseAmount = Console.readLine();
                inputPurchaseAmount = validateInputPurchaseAmount(originInputPurchaseAmount);
                validInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return inputPurchaseAmount;
    }

    public int validateInputPurchaseAmount(String originInputPurchaseAmount) {
        int inputPurchaseAmount = 0;

        if (!originInputPurchaseAmount.matches(".*[a-zA-Z가-힣].*")) {
            inputPurchaseAmount = Integer.parseInt(originInputPurchaseAmount);

            if (inputPurchaseAmount % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해주세요.");
            }
        }
        if (originInputPurchaseAmount.matches(".*[a-zA-Z가-힣].*")) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력하세요.");
        }
        return inputPurchaseAmount;
    }

    public int calculateRound(int inputPurchaseAmount) {
        int round = inputPurchaseAmount / 1000;
        System.out.println(round + "개를 구매했습니다.");
        return round;
    }
}
