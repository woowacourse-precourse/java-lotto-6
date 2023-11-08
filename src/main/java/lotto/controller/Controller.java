package lotto.controller;

import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.service.Service;
import lotto.util.Util;
import lotto.view.View;

import static lotto.util.Util.createRandomNumbers;

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
