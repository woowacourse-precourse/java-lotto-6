package lotto.buyer;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.Validator;

public class Buyer {
    public int buyLotto() {
        String buyAmount = Console.readLine();
        Console.close();
        if (!Validator.isNumber(buyAmount) || !Validator.validateBuyAmount(buyAmount)) {
            System.out.println("[ERROR] 로또 구매 금액은 1000원 단위로 입력해주세요. (최소 구매 금액: 1000원)");
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(buyAmount);
    }
}
