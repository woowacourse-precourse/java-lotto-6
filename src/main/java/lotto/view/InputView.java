package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.Validator;

public class InputView {
    Validator validator = new Validator();

    public int inputPurchasePrice() {
        int price = Integer.parseInt(Console.readLine());
        try {
            validator.purchasePrice(price);
        } catch (Exception e) {
            System.out.println("[ERROR] 구입 금액을 1,000원 단위로 입력하세요.");
            this.inputPurchasePrice();
        }

        return price;
    }
}
