package lotto.view;

import lotto.domain.Buyer;
import lotto.domain.Result;
import lotto.message.ErrorMessage;
import lotto.view.contants.OutputMessage;

public class OutputView {

    public static void purchaseLottos(Buyer buyer) {
        System.out.println(String.format(OutputMessage.PURCHASE_RESULT.getValue(), buyer.lottoCount()));
        System.out.println(buyer);
    }

    public static void winningResult(Result result) {
        System.out.println(OutputMessage.WINNING_STATISTICS.getValue());
        System.out.print(result);
        System.out.print(String.format(OutputMessage.RATE_OF_RETURN.getValue(), result.calculateLottoRateOfReturn()));
    }

    public static void errorMessage(String errorMessage) {
        System.out.println(ErrorMessage.PREFIX.getValue() + errorMessage);
    }
}
