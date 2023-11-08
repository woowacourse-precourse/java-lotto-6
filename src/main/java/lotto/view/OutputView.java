package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.util.Constant;
import lotto.util.Message;

public class OutputView {
    public static OutputView getInstance() {

        return LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final OutputView INSTANCE = new OutputView();
    }

    public void printMessage(Message message) {
        println(message.getMessage());
    }

    public void printExceptionMessage(String exceptionMessage) {
        println(exceptionMessage);
    }

    public void printPurchaseNotice(int purchaseNumber) {
        String purchaseNoticeFormat = String.format(Constant.PURCHASE_NOTICE, purchaseNumber);

        println(purchaseNoticeFormat);
    }

    public void printUserLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            println(lotto.getLottoNumbers().toString());
        }
    }

    private void println(String output) {
        System.out.println(output);
    }
}
