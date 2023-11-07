package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoManager;
import lotto.domain.LottoShop;
import lotto.domain.LottosResult;
import lotto.domain.PurchaseAmount;
import lotto.domain.Rank;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {

    }

    private List<Integer> getWinningLottoNumbers() {
        try {
            List<Integer> winningNumbers = inputView.inputWinningNumbers();
            Lotto winningLotto = new Lotto(winningNumbers);
            return winningNumbers;
        } catch (IllegalArgumentException exception) {
            outputView.printError(exception.getMessage());
            return getWinningLottoNumbers();
        }
    }

    private LottoManager generateLottoManager(List<Integer> winningNumbers, int bonusNumber) {
        try {
            LottoManager lottoManager = new LottoManager(winningNumbers, bonusNumber);
            return lottoManager;
        } catch (IllegalArgumentException exception) {
            outputView.printError(exception.getMessage());
            return generateLottoManager(winningNumbers, getBonusNumber());
        }
    }

    private int getBonusNumber() {
        try {
            return inputView.inputBonusNumber();
        } catch (IllegalArgumentException exception) {
            outputView.printError(exception.getMessage());
            return getBonusNumber();
        }
    }
}
