package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.domain.CreateLottoNumbers;
import lotto.domain.Lotto;
import lotto.domain.LottoMatch;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import lotto.view.InputView;

public class LottoController {

    public void startLotto() {
        InputView inputView = new InputView();
        CreateLottoNumbers createLottoNumbers = new CreateLottoNumbers();
        LottoMatch lottoMatch = new LottoMatch();

        int amount = inputView.lottoAmount();
        List<Lotto> lottoNumbers = createLottoNumbers.createLottoMain(amount);
        WinningLotto winningLotto = inputView.winningLottoInput();

        Map<Rank, Integer> result = lottoMatch.scoreBoard(lottoNumbers, winningLotto);
        System.out.println("result = " + result);
    }
}
