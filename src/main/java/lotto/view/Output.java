package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.string.OutputMessage;

public class Output {
    public void requestAmount() {
        System.out.println(OutputMessage.REQUEST_AMOUNT_MESSAGE);
    }

    public void printPurchaseCount(int purchaseCount) {
        System.out.print(purchaseCount);
        System.out.println(OutputMessage.PURCHASE_COUNT_MESSAGE);
    }

    public void printLottos(List<Lotto> lottos) {
        for(Lotto lotto:lottos) {
            System.out.println(lotto.getLotto());
        }
    }

    public void requestWiningNumber() {
        System.out.println(OutputMessage.REQUEST_WININGNUMBER_MESSAGE);
    }

    public void requestBonusNumber() {
        System.out.println(OutputMessage.REQUEST_BONUSNUMBER_MESSAGE);
    }

    public void printResultLotto() {
        //추가 구현 필요
        float num = 0;
        printWiningStatisticsStart();
        System.out.println(OutputMessage.DIVISIONLINE_MESSAGE);
        printWiningCount();
        printReturnRate(num);

    }

    public void printWiningStatisticsStart() {
        System.out.println(OutputMessage.WININGSTATISTIC_START_MESSAGE);
    }

    public void printWiningCount() {
        //추가 구현 필요
        System.out.print(OutputMessage.STATISTIC_FRONT_MESSAGE);
        System.out.print(OutputMessage.STATISTIC_MIDDLE_MESSAGE);
        System.out.print(OutputMessage.STATISTIC_LAST_MESSAGE);
    }

    public void printReturnRate(float returnRate) {
        System.out.print(OutputMessage.STATISTIC_RESULT_FRONT_MESSAGE);
        System.out.print(returnRate);
        System.out.println(OutputMessage.STATISTIC_RESULT_LAST_MESSAGE);

    }
}
