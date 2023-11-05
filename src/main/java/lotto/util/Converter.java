package lotto.util;

import static lotto.model.LottoInfo.ONE_LOTTO_PRICE;

import java.util.Arrays;
import java.util.List;
import lotto.exception.NonNumericInputException;
import lotto.vo.BonusNumber;
import lotto.vo.PurchaseAmount;
import lotto.vo.TicketQuantity;

public class Converter {

    private static final String DELIMITER = ",";

    private Converter() {
    }

    public static TicketQuantity convertToTicketCount(final Integer amount) {
        PurchaseAmount purchaseAmount = new PurchaseAmount(amount);
        Integer quantity = getTicketCount(purchaseAmount);

        return new TicketQuantity(quantity);
    }

    public static List<Integer> convertToLottoNumbers(final String winningNumbers) {
        return Arrays.stream(winningNumbers.split(DELIMITER))
                .map(number -> getLottoNumber(number.trim()))
                .toList();
    }

    public static BonusNumber convertToBonusNumber(final Integer number) {
        return new BonusNumber(number);
    }

    private static Integer getTicketCount(final PurchaseAmount purchaseAmount) {
        return Integer.valueOf(purchaseAmount.amount()) / ONE_LOTTO_PRICE.getValue();
    }

    private static Integer getLottoNumber(final String number) {
        try {
            return Integer.valueOf(number);
        } catch (NumberFormatException e) {
            throw new NonNumericInputException();
        }
    }
}
