package lotto.view;

import static lotto.view.LottoConsole.*;
import static lotto.view.LottoConstants.*;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.PurchasePrice;

public class InputView {
    public PurchasePrice readPurchasePrice() {
        print(MSG_PURCHASE_MONEY_PROMPT);
        int price = Integer.parseInt(Console.readLine());
        return new PurchasePrice(price);
    }


}
