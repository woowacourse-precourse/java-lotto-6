package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoRank;
import lotto.service.LottoService;
import lotto.view.LottoView;

import java.util.HashMap;
import java.util.List;

public class LottoController {

    private LottoView lottoView = new LottoView();
    private LottoService lottoService = new LottoService();

    public void runLotto(){
        String lottoPurchase = lottoView.inputLottoPurchase();
        int lottoPurchaseReturn = lottoService.getLottoCount(lottoPurchase);
        lottoView.printLottoPurchase(lottoPurchaseReturn);

        LottoMachine lottoMachine = lottoService.createLottoMachine(lottoPurchaseReturn);
        lottoView.printPublishedLotto(lottoMachine.getLottos());

        String winningNumber = lottoView.inputLottoWinningNumber();
        List<Integer> winningNumbers = lottoService.getWinningNumbers(winningNumber);
        String bonusNumber = lottoView.inputLottoBonusNumber();


    }
}
