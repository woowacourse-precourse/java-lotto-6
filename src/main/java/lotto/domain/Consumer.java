package lotto.domain;

import static lotto.constants.ErrorMessage.ERROR_DIVIDE_BY_AMOUNT;
import static lotto.constants.ErrorMessage.ERROR_GREATER_THAN_MAX_AMOUNT;
import static lotto.constants.ErrorMessage.ERROR_LESS_THAN_MIN_AMOUNT;
import static lotto.constants.ErrorMessage.ERROR_QUANTITY_NON_EQUALS;
import static lotto.constants.LottoConfiguration.MAX_PRICE;
import static lotto.constants.LottoConfiguration.MIN_PRICE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.exception.ConsumerException;

public class Consumer {

    private static final int MIN_AMOUNT = MIN_PRICE.getConfig();
    private static final int MAX_AMOUNT = MAX_PRICE.getConfig();

    private List<Lotto> lottoes = new ArrayList<>();
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
        if (MIN_AMOUNT > buyAmount) {
            throw ConsumerException.of(ERROR_LESS_THAN_MIN_AMOUNT);
        }
    }

    private static void buyAmountGreaterThanMaxAmount(int buyAmount) {
        if (MAX_AMOUNT < buyAmount) {
            throw ConsumerException.of(ERROR_GREATER_THAN_MAX_AMOUNT);
        }
    }

    private static void buyAmountDivideByAmount(int buyAmount) {
        if (buyAmount % MIN_AMOUNT != 0) {
            throw ConsumerException.of(ERROR_DIVIDE_BY_AMOUNT);
        }
    }

    public int getBuyAmount() {
        return buyAmount;
    }

    public List<Lotto> getLottoes() {
        return Collections.unmodifiableList(lottoes);
    }

    public int getBuyAvailableQuantity() {
        return buyAmount / MIN_AMOUNT;
    }

    public void receiveLottoes(List<Lotto> lottoes) {
        this.lottoes = lottoes;
        buyQuantityCheck();
    }

    private void buyQuantityCheck() {
        int quantity = lottoes.size();
        int availableQuantity = getBuyAvailableQuantity();

        if (quantity != availableQuantity) {
            throw ConsumerException.of(ERROR_QUANTITY_NON_EQUALS);
        }
    }
}
