package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.WinningLottoNumbers;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private InputView inputView;
    private OutputView outputView;
    private LottoService lottoService;

    public LottoController() {
        inputView = new InputView();
        outputView = new OutputView();
        lottoService = new LottoService();
    }


    public void play() {

        int lottoAmount = inputView.getPurchaseAmount();
        List<Lotto> userPurchasedLotto = lottoService.generateMultipleLotto(lottoAmount);

        outputView.printPurchasedLotto(userPurchasedLotto);

        WinningLottoNumbers winningLottoNumbers = inputView.getWinningLottoNumbers();

        System.out.println(winningLottoNumbers.toString());
    }


}
