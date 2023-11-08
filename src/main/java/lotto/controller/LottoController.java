package lotto.controller;

import java.util.List;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.Match;
import lotto.domain.WinningLottoNumbers;
import lotto.service.LottoCountService;
import lotto.service.LottoGenerateService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private InputView inputView;
    private OutputView outputView;
    private LottoGenerateService lottoGenerateService;
    private LottoCountService lottoCountService;

    public LottoController() {
        inputView = new InputView();
        outputView = new OutputView();
        lottoGenerateService = new LottoGenerateService();
        lottoCountService = new LottoCountService();
    }


    public void play() {

        int lottoAmount = inputView.getPurchaseAmount();
        List<Lotto> userPurchasedLotto = lottoGenerateService.generateMultipleLotto(lottoAmount);

        outputView.printPurchasedLotto(userPurchasedLotto);

        WinningLottoNumbers winningLottoNumbers = inputView.getWinningLottoNumbers();

        Bonus bonus = inputView.getBonusLottoNumber();

        Match matchResult = lottoCountService.countMatching(userPurchasedLotto, winningLottoNumbers, bonus);

        outputView.printMatchResult(matchResult);

    }


}
