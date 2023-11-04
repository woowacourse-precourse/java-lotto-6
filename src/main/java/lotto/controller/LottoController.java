package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoNumberGenerator;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    private final LottoNumberGenerator lottoNumberGenerator;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController() {
        this.lottoNumberGenerator = new LottoNumberGenerator();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void playLotto() {
        int purchaseAmount = inputView.readPurchaseAmount();
        List<Lotto> lottos = buyLottos(purchaseAmount);
        printLottos(lottos);

        String winningNumbersInput = readWinningNumbersInput();
        int bonusNumber = readBonusNumberInput();
        WinningNumbers winningNumbers = createWinningNumbers(winningNumbersInput, bonusNumber);
    }

    private List<Lotto> buyLottos(int purchaseAmount) {
        int numberOfLottos = purchaseAmount / 1000;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < numberOfLottos; i++) {
            lottos.add(new Lotto(lottoNumberGenerator.generate()));
        }
        return lottos;
    }

    private void printLottos(List<Lotto> lottos) {
        outputView.printNumberOfLottosPurchased(lottos.size());
        outputView.printLottos(lottos);
    }

    private String readWinningNumbersInput() {
        return inputView.readWinningNumbers();
    }

    private int readBonusNumberInput() {
        return inputView.readBonusNumber();
    }

    private WinningNumbers createWinningNumbers(String winningNumbersInput, int bonusNumber) {
        return new WinningNumbers(winningNumbersInput, bonusNumber);
    }
}
