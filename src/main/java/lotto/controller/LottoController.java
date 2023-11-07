package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.LottoTicket;
import lotto.model.Prize;
import lotto.model.WinningNumbers;
import lotto.util.Validator;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class LottoController {

    private final LottoInputView inputView;
    private final LottoOutputView outputView;
    public static final int LOTTO_PRICE = 1000;

    public LottoController(LottoInputView inputView, LottoOutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        int money = getValidPurchaseAmount();
        int count = getCount(money);
        LottoTicket userLotto = new LottoTicket(count);
        outputView.printLottoEntries(userLotto);
        Lotto winningLotto = getWinningLotto();
        int bonusNumber = getBonusNumber(winningLotto.getNumbers());
        WinningNumbers winningNumbers = new WinningNumbers(winningLotto, bonusNumber);
        Map<Prize, Integer> prizeMap = winningNumbers.calculatePrizes(userLotto.getLottoEntries());
        outputView.printResult(prizeMap, money);
    }

    private int getCount(int money) {
        return money / LOTTO_PRICE;
    }

    private int getBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                int bonusNumber = inputView.promptBonusNumber();
                Validator.validateBonusNumber(winningNumbers, bonusNumber);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                outputView.print(Validator.INVALID_BONUS_NUMBER);
            }
        }

    }

    private Lotto getWinningLotto() {
        while (true) {
            try {
                return new Lotto(inputView.promptWinningNumbers());
            } catch (IllegalArgumentException e) {
                outputView.print(Validator.INVALID_NUMBERS);
            }
        }
    }

    private int getValidPurchaseAmount() {
        while (true) {
            try {
                return inputView.promptForPurchaseAmount();
            } catch (IllegalArgumentException e) {
                outputView.print(e.getMessage());
            }
        }
    }

}
