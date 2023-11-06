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

    private static final int AMOUNT = MIN_PRICE.getConfig();
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

    /**
     * 로또 구매 최소 금액 확인
     *
     * @param buyAmount
     */
    private static void buyAmountLessThanMinAmount(int buyAmount) {
        if (AMOUNT > buyAmount) {
            throw ConsumerException.of(ERROR_LESS_THAN_MIN_AMOUNT);
        }
    }

    /**
     * 로또 구매 최대 금액 확인
     *
     * @param buyAmount
     */
    private static void buyAmountGreaterThanMaxAmount(int buyAmount) {
        if (MAX_AMOUNT < buyAmount) {
            throw ConsumerException.of(ERROR_GREATER_THAN_MAX_AMOUNT);
        }
    }

    /**
     * 로또 구매 가능 확인
     *
     * @param buyAmount
     */
    private static void buyAmountDivideByAmount(int buyAmount) {
        if (buyAmount % AMOUNT != 0) {
            throw ConsumerException.of(ERROR_DIVIDE_BY_AMOUNT);
        }
    }

    public int getBuyAmount() {
        return buyAmount;
    }

    public List<Lotto> getLottoes() {
        return Collections.unmodifiableList(lottoes);
    }

    /**
     * 로또 구입 가능 갯수
     *
     * @return
     */
    public int getBuyAvailableQuantity() {
        return buyAmount / AMOUNT;
    }

    /**
     * 로또 구매
     *
     * @param lottoes
     */
    public void receiveLottoes(List<Lotto> lottoes) {
        this.lottoes = lottoes;
        buyQuantityCheck();
    }

    /**
     * 구입 로또 갯수 확인
     */
    private void buyQuantityCheck() {
        int quantity = lottoes.size();
        int availableQuantity = getBuyAvailableQuantity();

        if (quantity != availableQuantity) {
            throw ConsumerException.of(ERROR_QUANTITY_NON_EQUALS);
        }
    }
}
