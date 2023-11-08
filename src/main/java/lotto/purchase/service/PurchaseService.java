package lotto.purchase.service;

import lotto.lotto.domain.Lotteries;
import lotto.purchase.domain.Purchase;

public class PurchaseService {

    private final Purchase purchase = new Purchase();

    public PurchaseService() {
    }

    public Lotteries process() throws IllegalArgumentException {
        purchase.insult();
        purchase.calculate();
        System.out.println(purchase.getPurchaseAmount() + "개를 구매했습니다.");
        Lotteries lotteries = new Lotteries();
        lotteries.publishLotteries(purchase.getPurchaseAmount());
        return lotteries;
    }

    public Integer getSpendMoney() {
        return purchase.getSpendMoney();
    }

}
