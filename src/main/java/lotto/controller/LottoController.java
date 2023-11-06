package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoList;
import lotto.domain.WinningNumbers;
import lotto.utils.RandomNumbersGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final RandomNumbersGenerator randomNumbersGenerator;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.randomNumbersGenerator = new RandomNumbersGenerator();
    }

    public void playLotto() {
        long purchaseAmount = inputView.getPurchaseAmount();
        LottoList lottoList = new LottoList(makeLottoList(purchaseAmount));
        outputView.printLottoList(lottoList);

        WinningNumbers winningNumbers = generateWinningNumbers();
    }

    public List<Lotto> makeLottoList(long purchaseAmount) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < purchaseAmount / 1000; i++) {
            List<Integer> lottoNumbers = randomNumbersGenerator.randomNumbersGenerate();
            lottoList.add(new Lotto(lottoNumbers));
        }
        return lottoList;
    }

    public WinningNumbers generateWinningNumbers() {
        String winningNumber = inputView.getWinningNumbers();
        int bonusNumber = inputView.getBonusNumber();
        return new WinningNumbers(winningNumber, bonusNumber);
    }
}
