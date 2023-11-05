package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningNumbers;

public class InputView {

    private final InputReader inputReader;

    public InputView(InputReader inputReader) {
        this.inputReader = inputReader;
    }

    public PurchaseAmount requestPurchaseAmount() {
        while (true) {
            try {
                System.out.println(InputMessage.INPUT_PURCHASE_AMOUNT.getMessage());
                return inputReader.readPurchaseAmount();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public WinningNumbers requestWinningNumbers() {
        Lotto winningLotto = requestWinningLotto();
        LottoNumber bonusNumber = requestBonusNumber();
        return WinningNumbers.of(winningLotto, bonusNumber);
    }

    private Lotto requestWinningLotto() {
        while (true) {
            try {
                System.out.println(InputMessage.INPUT_LOTTO.getMessage());
                return inputReader.readLotto();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private LottoNumber requestBonusNumber() {
        while (true) {
            try {
                System.out.println(InputMessage.INPUT_BONUS_NUMBER.getMessage());
                return inputReader.readBonusNumber();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
