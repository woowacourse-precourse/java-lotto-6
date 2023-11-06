package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final List<LotteryReceipt> receipts;

    public User() {
        this.receipts = new ArrayList<>();
    }

    public void takeReceipt(LotteryReceipt receipt) {
        receipts.add(receipt);
    }

    public List<LotteryReceipt> getReceipts() {
        return List.copyOf(receipts);
    }

}
