package lotto.ui;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    private String input;

    public void purchasePriceInput() {
        boolean isValid = false;

        while (!isValid) {
            try {
                readPurchasePrice();
                isValid = validatePurchasePriceFormat();

            } catch (IllegalArgumentException e) {
                System.out.print("[ERROR] " + e.getMessage());
            }
        }
    }

    private void readPurchasePrice() {
        System.out.print("구입 금액을 입력해 주세요.\n");
        this.input = Console.readLine().trim();
    }

    private boolean validatePurchasePriceFormat() {
        if (!this.input.matches("^(\\d+000)$")) {
            throw new IllegalArgumentException("구입 금액은 1,000원 단위로 입력받으며 1,000원으로 나누어떨어져야 합니다.\n");
        }

        return true;
    }
}
