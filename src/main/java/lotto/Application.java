package lotto;

import static lotto.Input.getValidPurchaseInput;

public class Application {
    public static void main(String[] args) {
        int purchaseInputMoney = getValidPurchaseInput(); // 올바른 구매 금액을 입력했는지 확인하고 올바르지 않으면 재입력한다
    }
}
