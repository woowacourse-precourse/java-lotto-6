package lotto.Model;

import static lotto.Constants.DEFAULT;
import static lotto.Constants.MAX_LOTTO_PURCHASE_PRICE;
import static lotto.Constants.MAX_LOTTO_PURCHASE_PRICE_TO_STRING;
import static lotto.Constants.ONE_HUNDRED_PERCENT;
import static lotto.Constants.TENTHS;
import static lotto.Constants.UNIT_OF_ONE_LOTTO_PRICE;
import static lotto.Utils.toInt;

public class Price {
    public static final String ERROR_NOT_NUMBER =
            String.format("[ERROR] 숫자만을 입력하세요.(최대 구입금액은 %s입니다)", MAX_LOTTO_PURCHASE_PRICE_TO_STRING);
    public static final String ERROR_UNIT_PRICE_OF_PURCHASED_LOTTO =
            String.format("[ERROR] %d원 단위로 입력하세요.", UNIT_OF_ONE_LOTTO_PRICE);
    public static final String ERROR_NOT_PURCHASE_LOTTO =
            String.format("[ERROR] 로또구입금액은 최소 %d원입니다.", UNIT_OF_ONE_LOTTO_PRICE);
    public static final String ERROR_OVER_MAX_PRICE_OF_LOTTO_FOR_PURCHASE =
            String.format("[ERROR] 로또구입금액은 최대 %s입니다.", MAX_LOTTO_PURCHASE_PRICE_TO_STRING);

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
            return DEFAULT;
        }
        return (double) Math.round(dividePurchasePriceWith(totalWinningPrize) * ONE_HUNDRED_PERCENT * TENTHS) / TENTHS;
    }

    private void validate(String input) throws IllegalArgumentException {
        int numberInput = validateNumber(input);
        validateDividingUnitOfOneLottoPrice(numberInput);
        validateNumberRange(numberInput);
    }

    private int validateNumber(String input) {
        try {
            return toInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NOT_NUMBER);
        }
    }

    private void validateDividingUnitOfOneLottoPrice(int validInput) {
        if (validInput % UNIT_OF_ONE_LOTTO_PRICE != DEFAULT) {
            throw new IllegalArgumentException(ERROR_UNIT_PRICE_OF_PURCHASED_LOTTO);
        }
    }

    private void validateNumberRange(int validInput) {
        if (validInput < UNIT_OF_ONE_LOTTO_PRICE) {
            throw new IllegalArgumentException(ERROR_NOT_PURCHASE_LOTTO);
        }
        if (validInput > MAX_LOTTO_PURCHASE_PRICE) {
            throw new IllegalArgumentException(ERROR_OVER_MAX_PRICE_OF_LOTTO_FOR_PURCHASE);
        }
    }

    private boolean isZero(int totalPrize) {
        return totalPrize == DEFAULT;
    }

    private double dividePurchasePriceWith(int totalPrize) {
        return (double) totalPrize / purchasePrice;
    }
}
