package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.LottoConfig;
import lotto.exception.LottoException;

public class InputView {

    private final LottoException lottoException = new LottoException();

    private final LottoConfig lottoConfig = new LottoConfig();

    private static final String PURCHASE_AMOUNT_MESSAGE = "구입 금액을 입력해 주세요.";
    private static final String PURCHASE_MESSAGE = "개를 구매했습니다.";
    private static final String NEW_LINE = "\n";

    public int purchaseAmountInput() {
        String purchaseAmount;

        do {
            System.out.println(PURCHASE_AMOUNT_MESSAGE);
            purchaseAmount = Console.readLine().trim();
        } while (!lottoException.checkNumber(purchaseAmount) ||
                !lottoException.purchaseAmountCheckMain(purchaseAmount));
        {
            System.out.print(NEW_LINE);
            return Integer.parseInt(purchaseAmount);
        }
    }

    public int lottoAmount() {
        int purchaseAmount = purchaseAmountInput();
        int count = purchaseAmount / lottoConfig.TICKET_PRICE;
        System.out.println(count + PURCHASE_MESSAGE);
        return count;
    }

}
