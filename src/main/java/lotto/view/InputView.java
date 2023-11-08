package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Stream;
import lotto.model.BonusNumber;
import lotto.model.Constants;
import lotto.model.Lotto;
import lotto.validator.BonusNumberValidator;
import lotto.validator.PurchasePriceValidator;
import lotto.validator.LottoValidator;

public class InputView {
    private final PurchasePriceValidator purcharPriceValidator = new PurchasePriceValidator();
    private final LottoValidator lottoValidator = new LottoValidator();
    private final BonusNumberValidator bonusNumberValidator = new BonusNumberValidator();

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
        System.out.println(InputMessage.REQUEST_PURCHASE_PRICE.getMessage());
        String purchasePrice = Console.readLine();
        purcharPriceValidator.validate(purchasePrice);
        System.out.println();

        return purchasePrice;
    }

    public Lotto getLotto() {
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
        lottoValidator.validate(inputNumbers);
        System.out.println();

        inputNumbers = inputNumbers.replace(" ", "");
        return Stream.of(inputNumbers.split(Constants.NUMBER_SEPARATOR))
                .map(Integer::parseInt)
                .toList();
    }

    public BonusNumber getBonusNumber(Lotto lotto) {
        while (true) {
            try {
                return new BonusNumber(requestBonusNumber(lotto));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int requestBonusNumber(Lotto lotto) {
        System.out.println(InputMessage.REQUEST_BONUS_NUMBER.getMessage());
        String inputNumber = Console.readLine();
        bonusNumberValidator.validate(inputNumber);

        int bonusNumber = Integer.parseInt(inputNumber);
        bonusNumberValidator.validateDuplicated(bonusNumber, lotto);
        System.out.println();

        return bonusNumber;
    }
}
