package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Stream;
import lotto.model.BonusNumber;
import lotto.model.Constants;
import lotto.model.Lotto;
import lotto.model.WinningLotto;
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
        String purchasePrice = "";

        System.out.println(InputMessage.REQUEST_PURCHASE_PRICE.getMessage());
        purchasePrice = Console.readLine();
        purcharPriceValidator.validate(purchasePrice);
        System.out.println();

        return purchasePrice;
    }

    public WinningLotto getWinningLotto() {
        Lotto lotto = getLotto();
        BonusNumber bonusNumber = getBonusNumber();

        return new WinningLotto(lotto, bonusNumber);
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
        lottoValidator.validate(inputNumbers);
        System.out.println();

        inputNumbers = inputNumbers.replace(" ","");
        return Stream.of(inputNumbers.split(Constants.NUMBER_SEPARATOR))
                .map(Integer::parseInt)
                .toList();
    }

    private BonusNumber getBonusNumber(){
        while (true) {
            try {
                return new BonusNumber(requestBonusNumber());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int requestBonusNumber(){
        System.out.println(InputMessage.REQUEST_BONUS_NUMBER.getMessage());
        String inputNumber = Console.readLine();
        bonusNumberValidator.validate(inputNumber);
        System.out.println();

        return Integer.parseInt(inputNumber);
    }
}
