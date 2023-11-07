package lotto;

import lotto.purchasing.PurchaseAmount;

public class Application {
    public static void main(String[] args) {
        SequenceManager sequenceManager = new SequenceManager(new PurchaseAmount());

        sequenceManager.proceed();
    }
}
