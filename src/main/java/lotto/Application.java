package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Buyer;
import lotto.view.InputMessage;

public class Application {
    public static void main(String[] args) {
        InputMessage.inputPurchaseAmount();
        int purchaseAmount = Integer.parseInt(Console.readLine());
        Buyer buyer = Buyer.from(purchaseAmount);
        System.out.println(buyer.getPurchaseAmount());
    }
}
