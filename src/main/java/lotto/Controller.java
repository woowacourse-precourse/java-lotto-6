package lotto;

import lotto.domain.LotteryReceipt;
import lotto.domain.LotteryRetailer;
import lotto.domain.LottoRandom;

public class Controller {
    private InputInterface in;
    private OutputInterface out;

    Controller(InputInterface in, OutputInterface out){
        this.in = in;
        this.out = out;
    }

    void purchaseLotteries(){
        long purchasedAmount = in.getPurchasedAmount();
        LotteryRetailer retailer = new LotteryRetailer(new LottoRandom());
        LotteryReceipt receipt = retailer.purchase(purchasedAmount);
        out.printReceipt(receipt);
    }
}
