package lotto.controller;

import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.service.Service;
import lotto.view.View;

public class Controller {
    Buyer buyer = new Buyer();
    Service service = new Service();
    public void run() {
        service.createLotto(buyer);
        watchPurchasedLotteries();
    }

    public void watchPurchasedLotteries(){
        View.printPurchasedLotteries(buyer.getCount());
        for (Lotto lotto : buyer.getPurchasedLotteries()){
            View.printPurchasedLotteries(lotto.getNumbers());
        }
    }
}
