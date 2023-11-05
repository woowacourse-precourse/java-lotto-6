package lotto.model;

import lotto.record.AmountRecord;

public class Amount {

    private final Cash amountCash;

    public Amount(String amountCash) {
        this.amountCash = new Cash(amountCash);
    }

    public AmountRecord toRecord() {
        return new AmountRecord(amountCash.cash());
    }

}
