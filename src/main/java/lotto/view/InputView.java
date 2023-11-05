package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.validation.LottoNumberValidator;
import lotto.validation.PurchaseAmountValidator;

public class InputView {

    private final PurchaseAmountValidator purchaseAmountValidator;
    private final LottoNumberValidator lottoNumberValidator;

    private static final String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입 금액을 입력해주세요.";
    private static final String INPUT_DRAWN_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBERS_MESSAGE = "보너스 번호를 입력해 주세요.";

    public InputView() {
        this.purchaseAmountValidator = new PurchaseAmountValidator();
        this.lottoNumberValidator = new LottoNumberValidator();
    }

    public Integer getPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);
        while (true) {
            try {
                String purchaseAmount = Console.readLine();
                purchaseAmountValidator.validatePurchaseAmount(purchaseAmount);
                return Integer.valueOf(purchaseAmount);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<String> getDrawnNumbers() {
        System.out.println();
        System.out.println(INPUT_DRAWN_NUMBERS_MESSAGE);
        while (true) {
            try {
                String drawnNumbers = Console.readLine();
                return lottoNumberValidator.validateLottNumbers(drawnNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Integer getBonusNumber(List<String> lottoNumbers) {
        System.out.println();
        System.out.println(INPUT_BONUS_NUMBERS_MESSAGE);
        while (true) {
            try {
                String bonusNumber = Console.readLine();
                return lottoNumberValidator.validateBonusNumber(bonusNumber, lottoNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
