package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoBuyer {
    private int purchaseAmount;

    public LottoBuyer() {
        this.purchaseAmount = 0;
    }

    public void inputPurchaseAmount() {
        System.out.println("구입 금액을 입력해 주세요.");
        buyLotto(Console.readLine());
    }

    public void buyLotto(String inputAmount) {
        purchaseAmount = validateInputAmount(inputAmount);
    }

    public int validateInputAmount(String inputAmount) {
        int resultAmount;
        try {
            resultAmount = Integer.parseInt(inputAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        if ((resultAmount % 1000) != 0 || (resultAmount < 0)) {
            throw new IllegalArgumentException();
        }

        return resultAmount;
    }
}
