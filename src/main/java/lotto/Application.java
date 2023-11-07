package lotto;

import java.util.List;
import lotto.controller.LottoGameController;
import lotto.domain.BonusNumber;
import lotto.domain.Lotties;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningNumbers;
import lotto.exception.ModelExceptionConstant;
import lotto.service.LottoGameService;
import lotto.util.LottoGameUtil;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    private final static InputView inputView = new InputView();
    private final static OutputView outputView = new OutputView();

    public static void main(String[] args) {

        PurchaseAmount purchaseAmount = setPurchaseAmount();

        Lotties lotties = LottoGameUtil.setLotties(purchaseAmount.getLottoCount());
        outputView.printLotties(lotties.getLottiesStatus(), purchaseAmount.getLottoCount());

        WinningNumbers winningNumbers = setWinningNumbers();

        BonusNumber bonusNumber = setBonusNumber();

        LottoGameController controller = new LottoGameController(new LottoGameService());
        controller.run(purchaseAmount, winningNumbers, bonusNumber, lotties);
    }

    private static PurchaseAmount setPurchaseAmount() {
        while (true) {
            try {
                String input = inputView.inputPurchaseAmount();

                int number = LottoGameUtil.StringToInt(input);

                return new PurchaseAmount(number);
            } catch (IllegalArgumentException e) {
                System.out.println(ModelExceptionConstant.NOT_DIVIDE_BY_LOTTO_PRICE.getText());
            }
        }
    }

    private static WinningNumbers setWinningNumbers() {
        while (true) {
            try {
                String[] inputArray = inputView.inputWinningNumbers();

                List<Integer> numbers = LottoGameUtil.stringArrayToList(inputArray);

                return new WinningNumbers(numbers);
            } catch (IllegalArgumentException e) {
                System.out.println(ModelExceptionConstant.OUT_OF_WINNING_NUMBERS_SIZE.getText());
            }
        }
    }

    private static BonusNumber setBonusNumber() {
        while (true) {
            try {
                String input = inputView.inputBonusNumber();

                int number = LottoGameUtil.StringToInt(input);

                return new BonusNumber(number);
            } catch (IllegalArgumentException e) {
                System.out.println(ModelExceptionConstant.OUT_OF_LOTTO_NUMBER_RANGE.getText());
            }
        }
    }
}
