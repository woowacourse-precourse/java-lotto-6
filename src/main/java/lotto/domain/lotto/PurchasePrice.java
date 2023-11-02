package lotto.domain.lotto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lotto.exception.domain.purchaseprice.PurchasePriceDivisibleException;
import lotto.exception.domain.purchaseprice.PurchasePriceFormatException;
import lotto.exception.domain.purchaseprice.PurchasePriceLowAmountException;

public class PurchasePrice {
    private static final Pattern priceRegex = Pattern.compile("^[0-9]+(,*\\d)*$");

    private final int price;

    public PurchasePrice(String purchasePrice) {
        validate(purchasePrice);
        this.price = Integer.parseInt(purchasePrice);
    }

    public int getPrice() {
        return price;
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
        if (numberOfPrice < 1000) {
            throw new PurchasePriceLowAmountException();
        }
    }

    private void validateDivisibleByProperAmount(int numberOfPrice) {
        if (numberOfPrice % 1000 != 0) {
            throw new PurchasePriceDivisibleException();
        }
    }
}
