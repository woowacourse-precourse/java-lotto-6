package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int inputPurchasePrice() {
        System.out.println(InputMessage.INPUT_PURCHASE_PRICE_MESSAGE.getMessage());
        String amount = Console.readLine();
        // validate(amount); // TODO : 검증 로직 작성
        return Integer.parseInt(amount);
    }
}
