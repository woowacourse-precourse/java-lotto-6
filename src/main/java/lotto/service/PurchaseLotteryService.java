package lotto.service;

import lotto.domain.LotteryOperator;
import lotto.domain.LotteryReceipt;
import lotto.domain.LotteryRetailer;
import lotto.domain.LottoRandom;
import lotto.domain.PurchasedLottery;
import lotto.domain.User;

public class PurchaseLotteryService {
    private final LotteryRetailer retailer;
    private final LotteryOperator operator;

    public PurchaseLotteryService(LotteryRetailer retailer, LotteryOperator operator) {
        this.retailer = retailer;
        this.operator = operator;
    }

    public LotteryReceipt purchaseLotteries(User user, long purchasedAmount) {
        LotteryReceipt receipt = retailer.purchase(operator, purchasedAmount);
        user.takeReceipt(receipt);
        return receipt;
    }

}
