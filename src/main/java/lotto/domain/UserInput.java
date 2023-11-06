package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {
    public UserInput() {
    }

    public String input() {
        String input = Console.readLine();
        try {
            checkInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return input;
    }

    public int getUserPurchaseAmount(String inputPurchaseAmount) {
        int purchaseAmount = Integer.parseInt(inputPurchaseAmount);
        try {
            checkPurchaseAmount(purchaseAmount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return purchaseAmount;
    }

    public int checkPurchaseAmount(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0)
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 단위로만 입력 가능합나다.");
        return purchaseAmount;
    }

    public int getUserWinningNumbers(String inputWinningNumbers) { // ","마다 따로 저장하기, 각 숫자는 1~45의 숫자이다.

        return 0;
    }

    public int getUserBonusNumber() { // 1~45의 숫자이다.
        return 0;
    }

    public void checkInt(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닙니다.");
        }
    }
}
