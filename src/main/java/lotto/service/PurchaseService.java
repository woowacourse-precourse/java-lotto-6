package lotto.service;

import static lotto.view.OutputView.printLotteriesInfo;

import java.util.List;
import lotto.domain.Lotteries;
import lotto.domain.Payment;

public class PurchaseService {

    public Lotteries purchaseLotteries(final Payment payment) {
        final Lotteries lotteries = Lotteries.from(payment);
        final List<String> lotteriesInfo = lotteries.receiveLotteriesInfo();

        printLotteriesInfo(lotteriesInfo);

        return lotteries;
    }
}
