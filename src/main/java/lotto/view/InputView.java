package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import lotto.constant.Message;
import lotto.domain.PurchasePrice;
import lotto.domain.WinningNumbers;
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

    public WinningNumbers inputWinningNumbers() {
        WinningNumbers winningNumbers = null;

        while (!isValidWinningNumbers(winningNumbers)) {
            System.out.println(Message.INPUT_WINNING_NUMBERS.getMessage());
            String inputWinningNumbers = Console.readLine();
            winningNumbers = createWinningNumbers(inputWinningNumbers);
        }

        return winningNumbers;
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
            System.out.println(LottoExceptionMessage.PURCHASE_PRICE_MUST_BE_NUMBER.getMessage());
        }
        return null;
    }

    private boolean isNumber(String inputPrice) {
        try {
            Integer.parseInt(inputPrice);
            return true;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LottoExceptionMessage.PURCHASE_PRICE_MUST_BE_NUMBER.getMessage());
        }
    }

    private boolean isValidWinningNumbers(WinningNumbers validWinningNumbers) {
        return !Objects.isNull(validWinningNumbers);
    }


    private WinningNumbers createWinningNumbers(String inputWinningNumbers) {
        try {
            List<Integer> parseWinningNumbers = parseWinningNumbers(inputWinningNumbers);
            return WinningNumbers.from(parseWinningNumbers);

        } catch (IllegalArgumentException e) {
            return null;

        }
    }

    private List<Integer> parseWinningNumbers(String inputWinningNumbers) {
        try {
            return Arrays.stream(inputWinningNumbers.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            System.out.println(LottoExceptionMessage.WINNING_NUMBERS_MUST_BE_NUMBERS.getMessage());
            throw new IllegalArgumentException(LottoExceptionMessage.WINNING_NUMBERS_MUST_BE_NUMBERS.getMessage());
        }

    }
}
