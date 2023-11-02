package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Consumer {

    private static final int AMOUNT = 1000;
    private static final int MAX_AMOUNT = 100000;

    private List<Lotto> lottos = new ArrayList<>();
    private final int buyAmount;

    public Consumer(int buyAmount) {
        validate(buyAmount);
        this.buyAmount = buyAmount;
    }

    public int getBuyAmount() {
        return buyAmount;
    }

    private static void validate(int buyAmount) {
        buyAmountLessThanMinAmount(buyAmount);
        buyAmountGreaterThanMaxAmount(buyAmount);
        buyAmountDivideByAmount(buyAmount);
    }

    private static void buyAmountLessThanMinAmount(int buyAmount) {
        if (AMOUNT > buyAmount) {
            throw new IllegalArgumentException();
        }
    }

    private static void buyAmountGreaterThanMaxAmount(int buyAmount) {
        if (MAX_AMOUNT < buyAmount) {
            throw new IllegalArgumentException();
        }
    }

    private static void buyAmountDivideByAmount(int buyAmount) {
        if (buyAmount % AMOUNT != 0) {
            throw new IllegalArgumentException();
        }
    }

    public void buyLotto(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public int getBuyAvailableQuantity() {
        return buyAmount / AMOUNT;
    }

    public void buyQuantityCheck() {
        int quantity = lottos.size();
        int availableQuantity = getBuyAvailableQuantity();

        if (quantity != availableQuantity) {
            throw new IllegalArgumentException();
        }
    }
}
