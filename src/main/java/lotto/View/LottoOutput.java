package lotto.View;

import System.Message;
import java.util.List;
import lotto.Model.Domain.Lotto;
import lotto.Model.Domain.Statics;

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

    public void printResult(Statics statics) {
        System.out.println(
                Message.LINE_BREAK.getMessage() + Message.OUTPUT_WINNING_RESULT.getMessage());
        System.out.println(Message.OUTPUT_SOLID_LINE.getMessage());

        printStatics(Message.FIFTH_STATICS.getMessage(), statics.getFifthCount());
        printStatics(Message.FOURTH_STATICS.getMessage(), statics.getFourthCount());
        printStatics(Message.THIRD_STATICS.getMessage(), statics.getThirdCount());
        printStatics(Message.SECOND_STATICS.getMessage(), statics.getSecondCount());
        printStatics(Message.FIRST_STATICS.getMessage(), statics.getFirstCount());
        printStatics(Message.REVENUE_RESULT.getMessage(), statics.getRevenue());
    }

    public void printStatics(String message, int count) {
        System.out.printf(message + Message.LINE_BREAK.getMessage(), count);
    }
    public void printStatics(String message, float count) {
        System.out.printf(message + Message.LINE_BREAK.getMessage(), count);
    }


}
