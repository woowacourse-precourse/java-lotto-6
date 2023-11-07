package lotto.Model;

import static lotto.Utils.toInt;

public class Price {
    private static final int ZERO = 0;
    private static final int ONE_HUNDRED_PERCENT = 100;
    private static final int UNIT_OF_ONE_LOTTO_PRICE = 1000;
    private static final int MAX_LOTTO_PURCHASE_PRICE = 2000000000;

    private static final String ERROR_NOT_NUMBER =
            "[ERROR] 공백이나 쉼표같은 특수기호 없이 숫자만을 입력하세요.(최대 구입금액은 20억입니다)";
    private static final String ERROR_UNIT_PRICE_OF_PURCHASED_LOTTO = "[ERROR] 1000원 단위로 입력하세요.";
    private static final String ERROR_NOT_PURCHASE_LOTTO = "[ERROR] 로또구입금액은 최소 1000원입니다.";
    private static final String ERROR_OVER_MAX_PRICE_OF_LOTTO_FOR_PURCHASE = "[ERROR] 로또구입금액은 최대 20억입니다.";

    int purchasePrice;

    public Price(String input) {
        
        validate(input);
        this.purchasePrice = toInt(input);
    }

    public int countPurchasedLotto() {
        return purchasePrice / UNIT_OF_ONE_LOTTO_PRICE;
    }

    public double makeWinningRate(int totalWinningPrize) {
        if (isZero(totalWinningPrize)) {
            return ZERO;
        }
        return dividePurchasePriceWith(totalWinningPrize) * ONE_HUNDRED_PERCENT;
    }

    private void validate(String input) throws IllegalArgumentException {
        int numberInput = checkNumber(input);
        checkDividingUnitOfOneLottoPrice(numberInput);
        checkValidRange(numberInput);
    }

    private int checkNumber(String input) {
        try {
            return toInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NOT_NUMBER);
        }
    }

    private void checkDividingUnitOfOneLottoPrice(int validInput) {
        if (validInput % UNIT_OF_ONE_LOTTO_PRICE != ZERO) {
            throw new IllegalArgumentException(ERROR_UNIT_PRICE_OF_PURCHASED_LOTTO);
        }
    }

    private void checkValidRange(int validInput) {
        if (validInput <= UNIT_OF_ONE_LOTTO_PRICE) {
            throw new IllegalArgumentException(ERROR_NOT_PURCHASE_LOTTO);
        }
        if (validInput > MAX_LOTTO_PURCHASE_PRICE) {
            throw new IllegalArgumentException(ERROR_OVER_MAX_PRICE_OF_LOTTO_FOR_PURCHASE);
        }
    }

    private boolean isZero(int totalPrize) {
        return totalPrize == ZERO;
    }

    private double dividePurchasePriceWith(int totalPrize) {
        return (double)totalPrize / purchasePrice;
    }
}
