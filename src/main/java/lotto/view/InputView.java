package lotto.view;

import java.util.function.Supplier;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningNumbers;

public class InputView {

    private static final String INPUT_LOTTO_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요.";
    private static final String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private final InputReader inputReader;

    public InputView(InputReader inputReader) {
        this.inputReader = inputReader;
    }

    public PurchaseAmount requestPurchaseAmount() {
        return requestInputUntilPassItsValidation(INPUT_PURCHASE_AMOUNT_MESSAGE, inputReader::readPurchaseAmount);
    }

    public WinningNumbers requestWinningNumbers() {
        Lotto winningLotto = requestWinningLotto();
        while (true) {
            try {
                return WinningNumbers.of(winningLotto, requestBonusNumber());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Lotto requestWinningLotto() {
        return requestInputUntilPassItsValidation(INPUT_LOTTO_MESSAGE, inputReader::readLotto);
    }

    private LottoNumber requestBonusNumber() {
        return requestInputUntilPassItsValidation(INPUT_BONUS_NUMBER_MESSAGE, inputReader::readBonusNumber);
    }

    private <T> T requestInputUntilPassItsValidation(String inputMessage, Supplier<T> inputSupplier) {
        while (true) {
            try {
                System.out.println(inputMessage);
                return inputSupplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
