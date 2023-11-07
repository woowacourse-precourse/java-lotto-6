package lotto.Util;

import lotto.exception.PurchasePriceException;

public class PurchasePriceUtil {
    public int validPurchasePrice(String price){
        PurchasePriceException.validateOnlyNumeric(price);
        PurchasePriceException.validateNumberInRangeIntMax(price);
        int PriceDigit = Integer.parseInt(price);
        PurchasePriceException.validateNumberInRange(PriceDigit);
        PurchasePriceException.validateSmallerthanLottoPrice(PriceDigit);
        PurchasePriceException.validateMultipleOfThousand(PriceDigit);
        return PriceDigit;
    }
}
