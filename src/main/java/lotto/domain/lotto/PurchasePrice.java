package lotto.domain.lotto;

import static lotto.utils.LottoConstants.LOTTO_PRICE;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lotto.exception.domain.purchaseprice.PurchasePriceDivisibleException;
import lotto.exception.domain.purchaseprice.PurchasePriceFormatException;
import lotto.exception.domain.purchaseprice.PurchasePriceLowAmountException;

public class PurchasePrice {
    private static final Pattern priceRegex = Pattern.compile("^[0-9]+(,*\\d)*$");

    private final int price;

    public static PurchasePrice create(String purchasePrice) {
        return new PurchasePrice(purchasePrice);
    }

    public int getPrice() {
        return price;
    }

    private PurchasePrice(String purchasePrice) {
        validate(purchasePrice);
        this.price = parsePrice(purchasePrice);
    }

    private void validate(String purchasePrice) {
        validateFormat(purchasePrice);

        int numberOfPrice = parsePrice(purchasePrice);
        validateNotBelowOptimalPrice(numberOfPrice);
        validateDivisibleByProperAmount(numberOfPrice);
    }

    private int parsePrice(String purchasePrice) {
        return Integer.parseInt(purchasePrice.replaceAll(",", ""));
    }

    private void validateFormat(String purchasePrice) {
        Matcher matcher = priceRegex.matcher(purchasePrice);
        boolean isInvalidFormat = !matcher.matches();

        if (isInvalidFormat) {
            throw new PurchasePriceFormatException();
        }
    }

    private void validateNotBelowOptimalPrice(int numberOfPrice) {
        if (numberOfPrice < LOTTO_PRICE) {
            throw new PurchasePriceLowAmountException();
        }
    }

    private void validateDivisibleByProperAmount(int numberOfPrice) {
        if (numberOfPrice % LOTTO_PRICE != 0) {
            throw new PurchasePriceDivisibleException();
        }
    }
}
