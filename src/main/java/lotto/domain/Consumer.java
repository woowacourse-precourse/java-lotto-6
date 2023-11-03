package lotto.domain;

import static lotto.constants.ErrorConstants.ERROR_DIVIDE_BY_AMOUNT;
import static lotto.constants.ErrorConstants.ERROR_GREATER_THAN_MAX_AMOUNT;
import static lotto.constants.ErrorConstants.ERROR_LESS_THAN_MIN_AMOUNT;
import static lotto.constants.ErrorConstants.ERROR_QUANTITY_NON_EQUALS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.exception.ConsumerException;

public class Consumer {

    private static final int AMOUNT = 1000;
    private static final int MAX_AMOUNT = 100000;

    private List<Lotto> lottos = new ArrayList<>();
    private final int buyAmount;

    public Consumer(int buyAmount) {
        validate(buyAmount);
        this.buyAmount = buyAmount;
    }

    private static void validate(int buyAmount) {
        buyAmountLessThanMinAmount(buyAmount);
        buyAmountGreaterThanMaxAmount(buyAmount);
        buyAmountDivideByAmount(buyAmount);
    }

    private static void buyAmountLessThanMinAmount(int buyAmount) {
        if (AMOUNT > buyAmount) {
            throw ConsumerException.of(ERROR_LESS_THAN_MIN_AMOUNT);
        }
    }

    private static void buyAmountGreaterThanMaxAmount(int buyAmount) {
        if (MAX_AMOUNT < buyAmount) {
            throw ConsumerException.of(ERROR_GREATER_THAN_MAX_AMOUNT);
        }
    }

    private static void buyAmountDivideByAmount(int buyAmount) {
        if (buyAmount % AMOUNT != 0) {
            throw ConsumerException.of(ERROR_DIVIDE_BY_AMOUNT);
        }
    }

    public int getBuyAmount() {
        return buyAmount;
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public int getBuyAvailableQuantity() {
        return buyAmount / AMOUNT;
    }

    public void buyLotto(List<Lotto> lottos) {
        this.lottos = lottos;
        buyQuantityCheck();
    }
    
    private void buyQuantityCheck() {
        int quantity = lottos.size();
        int availableQuantity = getBuyAvailableQuantity();

        if (quantity != availableQuantity) {
            throw ConsumerException.of(ERROR_QUANTITY_NON_EQUALS);
        }
    }
}
