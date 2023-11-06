package lotto.controller;

import static lotto.view.OutputView.printLotteriesInfo;

import java.util.List;
import lotto.domain.Lotteries;
import lotto.domain.Payment;

public class PurchaseController {
    
    public Lotteries purchaseLotteries(final Payment payment) {
        Lotteries lotteries = Lotteries.from(payment);
        List<String> lotteriesInfo = lotteries.receiveLotteriesInfo();
        
        printLotteriesInfo(lotteriesInfo);
        
        return lotteries;
    }
}
