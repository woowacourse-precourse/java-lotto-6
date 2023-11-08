package lotto.domain;

import static lotto.config.GameNumberConfig.LOTTO_PRICE;
import static lotto.exception.ErrorMessage.VALIDATE_PURCHASE_AMOUNT_DIVIDE;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.util.RandomNumbersGenerator;

public class PurchaseAmount {
    private static final int START_INCLUSIVE = 0;

    private final int money;
    private final int lottoCount;

    public PurchaseAmount(int money) {
        validate(money);
        this.money = money;
        this.lottoCount = money / LOTTO_PRICE.getValue();
    }

    private void validate(int money) {
        checkDivide(money);
    }

    private void checkDivide(int money) {
        if (money % LOTTO_PRICE.getValue() != 0) {
            throw new IllegalArgumentException(VALIDATE_PURCHASE_AMOUNT_DIVIDE.getMessage());
        }
    }

    public PurchasedLotto purchaseLotto() {
        return new PurchasedLotto(
                IntStream.range(START_INCLUSIVE, lottoCount)
                .mapToObj(i -> new Lotto(RandomNumbersGenerator.generateSortedRandomNumbers()))
                .collect(Collectors.toList())
        );
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public int getMoney() {
        return money;
    }
}
