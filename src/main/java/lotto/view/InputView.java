package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Objects;
import lotto.constant.Message;
import lotto.domain.PurchasePrice;
import lotto.exception.LottoExceptionMessage;

public class InputView {
    public PurchasePrice inputPurchasePrice() {
        PurchasePrice purchasePrice = null;

        while (isNotValidPurchasePrice(purchasePrice)) {
            System.out.println(Message.INPUT_PRICE.getMessage());
            String inputPrice = Console.readLine().trim();
            Integer validPrice = parseValidPrice(inputPrice);

            purchasePrice = createPurchasePrice(validPrice);
        }
        return purchasePrice;
    }

    private PurchasePrice createPurchasePrice(Integer validPrice) {
        if (isValidPrice(validPrice)) {
            return PurchasePrice.from(validPrice);
        }
        return null;
    }

    private boolean isNotValidPurchasePrice(PurchasePrice purchasePrice) {
        return Objects.isNull(purchasePrice);
    }

    private boolean isValidPrice(Integer validPrice) {
        return !Objects.isNull(validPrice);
    }

    private Integer parseValidPrice(String inputPrice) {
        try {
            if (isNumber(inputPrice)) {
                return Integer.parseInt(inputPrice);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(LottoExceptionMessage.MUST_BE_NUMBER.getMessage());
        }
        return null;
    }

    private boolean isNumber(String inputPrice) {
        try {
            Integer.parseInt(inputPrice);
            return true;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LottoExceptionMessage.MUST_BE_NUMBER.getMessage());
        }
    }
}
