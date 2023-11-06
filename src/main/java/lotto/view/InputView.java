package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Stream;
import lotto.model.Constants;
import lotto.model.Lotto;
import lotto.validator.PurchasePriceValidator;
import lotto.validator.LottoValidator;

public class InputView {
    private static final PurchasePriceValidator purcharPriceValidator = new PurchasePriceValidator();
    private static final LottoValidator LOTTO_VALIDATOR = new LottoValidator();

    public int getPurchasePrice() {
        while (true) {
            try {
                return Integer.parseInt(requestPurchasePrice());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String requestPurchasePrice() {
        String purchasePrice = "";

        System.out.println(InputMessage.REQUEST_PURCHASE_PRICE.getMessage());
        purchasePrice = Console.readLine();
        purcharPriceValidator.validate(purchasePrice);
        System.out.println();

        return purchasePrice;
    }

    public void getWinningLotto() {
        Lotto lotto = getLotto();
    }

    private Lotto getLotto() {
        while (true) {
            try {
                return new Lotto(requestLotto());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> requestLotto() {
        System.out.println(InputMessage.REQUEST_WINNING_NUMBER.getMessage());
        String inputNumbers = Console.readLine();
        LOTTO_VALIDATOR.validate(inputNumbers);
        System.out.println();

        return Stream.of(inputNumbers.split(Constants.NUMBER_SEPARATOR))
                .map(Integer::parseInt)
                .toList();
    }
}
