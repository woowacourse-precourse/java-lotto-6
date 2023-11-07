package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public static int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int purchaseAmount = 0;
        try {
            purchaseAmount = Integer.parseInt(readLine());
            validatePurchaseAmount(purchaseAmount);
        } catch (NumberFormatException e) {
            validateNumber();
        }
        return purchaseAmount;
    }

    public static void validateNumber() {
        throw new IllegalArgumentException("입력 값은 정수여야 합니다.");
    }

    public static void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("1000원으로 나누어떨어지지 않습니다");
        }

        if (purchaseAmount < 1000) {
            throw new IllegalArgumentException("구입금액은 1000원 보다 커야합니다.");
        }
    }
}

