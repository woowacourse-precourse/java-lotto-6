package lotto.controller;

import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.service.Service;
import lotto.view.View;

public class Controller {
    Buyer buyer = new Buyer();
    Service service = new Service();
    public void run() {
        service.createLotto(buyer);
        watchPurchasedLotteries();
        LottoResult lottoResult = new LottoResult();
    }

    public void watchPurchasedLotteries(){
        View.printPurchasedLotteries(buyer.getCount());
        for (Lotto lotto : buyer.getPurchasedLotteries()){
            View.printPurchasedLotteries(lotto.getNumbers());
        }
    }
}
