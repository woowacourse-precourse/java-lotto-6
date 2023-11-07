package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.domain.CreateLottoNumbers;
import lotto.domain.Lotto;
import lotto.domain.LottoMatch;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

    public void startLotto() {
        InputView inputView = new InputView();
        CreateLottoNumbers createLottoNumbers = new CreateLottoNumbers();
        LottoMatch lottoMatch = new LottoMatch();
        ResultView resultView = new ResultView();

        int amount = inputView.lottoAmount();
        List<Lotto> lottoNumbers = createLottoNumbers.createLottoMain(amount);
        WinningLotto winningLotto = inputView.winningLottoInput();

        Map<Rank, Integer> lottoResult = lottoMatch.scoreBoard(lottoNumbers, winningLotto);
        double earningRates = lottoMatch.earningRateMain(lottoResult, amount);
        resultView.lottoResultPrint(lottoResult, earningRates);
    }
}
