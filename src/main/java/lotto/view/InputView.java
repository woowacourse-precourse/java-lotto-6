package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.validation.LottoNumberValidator;
import lotto.validation.PurchaseAmountValidator;

public class InputView {

    private static final String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입 금액을 입력해주세요.";
    private static final String INPUT_DRAWN_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBERS_MESSAGE = "보너스 번호를 입력해 주세요.";

    private final PurchaseAmountValidator purchaseAmountValidator;
    private final LottoNumberValidator lottoNumberValidator;

    public InputView() {
        this.purchaseAmountValidator = new PurchaseAmountValidator();
        this.lottoNumberValidator = new LottoNumberValidator();
    }

    public Integer getPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);
        String purchaseAmount = Console.readLine();
        return  purchaseAmountValidator.validatePurchaseAmount(purchaseAmount);
    }

    public List<Integer> getDrawnNumbers() {
        System.out.println();
        System.out.println(INPUT_DRAWN_NUMBERS_MESSAGE);
        String drawnNumbers = Console.readLine();
        return lottoNumberValidator.validateLottNumbers(drawnNumbers);
    }

    public Integer getBonusNumber() {
        System.out.println();
        System.out.println(INPUT_BONUS_NUMBERS_MESSAGE);
        String bonusNumber = Console.readLine();
        return lottoNumberValidator.validateBonusNumber(bonusNumber);
    }
}
