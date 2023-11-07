package lotto.View;

import System.Message;
import java.util.List;
import lotto.Model.Domain.Lotto;

public class LottoOutput {

    public void printTotalPurchaseAmount(List<Lotto> lottos) {
        System.out.println(Message.LINE_BREAK.getMessage() + lottos.size()
                + Message.OUTPUT_TOTAL_PURCHASE_AMOUNT.getMessage());
        printLottos(lottos);
    }

    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printResult() {
        System.out.println(
                Message.LINE_BREAK.getMessage() + Message.OUTPUT_WINNING_RESULT.getMessage());
        System.out.println(Message.OUTPUT_SOLID_LINE.getMessage());
        printStatics();
        System.out.printf(Message.REVENUE_RESULT.getMessage(), 62.55);
    }

    public void printStatics() {
        System.out.printf(Message.FIFTH_STATICS.getMessage() + Message.LINE_BREAK.getMessage(), 5);
        System.out.printf(Message.FOURTH_STATICS.getMessage() + Message.LINE_BREAK.getMessage(), 5);
        System.out.printf(Message.THIRD_STATICS.getMessage() + Message.LINE_BREAK.getMessage(), 5);
        System.out.printf(Message.SECOND_STATICS.getMessage() + Message.LINE_BREAK.getMessage(), 5);
        System.out.printf(Message.FIRST_STATICS.getMessage() + Message.LINE_BREAK.getMessage(), 5);
    }

}
