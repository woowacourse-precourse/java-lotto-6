package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.PurchaseAmountValidator;
import lotto.view.InputView;
import lotto.view.OutputView;


public class LottoService {

    private static final int DIVIDER_MONEY_TO_EXCHANGE_AMOUNT = 1000;

    public static int enterPurchaseAmount() {
        InputView.noticeToGetPurchaseAmount();
        String inputMoney = Console.readLine();
        int money = Integer.parseInt(inputMoney);
        //천 원 단위로 입력받았는지 검증
        PurchaseAmountValidator.validateMoney(inputMoney, DIVIDER_MONEY_TO_EXCHANGE_AMOUNT);

        OutputView.printPurchaseAmount(money);
        return money / DIVIDER_MONEY_TO_EXCHANGE_AMOUNT;
    }
}
