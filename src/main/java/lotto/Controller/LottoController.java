package lotto.Controller;

import lotto.Domain.Lotto;
import lotto.Service.LottoService;
import lotto.View.InputView;
import lotto.View.OutputView;

import java.util.List;

public class LottoController {


    public void playLotto(){

        Integer purchaseSum = InputView.inputPurchaseSum();
        LottoService lottoService = new LottoService(purchaseSum);

        List<Lotto> lottos = lottoService.getLottos();
        OutputView.printNewLottos(lottos);


        List<Integer> winningNumbers = InputView.inputWinningNumber();
        lottoService.setWinningNumbers(winningNumbers);
        Integer bonusNumber = InputView.inputBonusNumber();
        lottoService.setBonusNumber(bonusNumber);
        List<Integer> matchingCount = lottoService.findMatcingCount();
        OutputView.printMatchingCount(matchingCount);

        double earningRate = lottoService.findEarningRate(purchaseSum);
        OutputView.printEarningRate(earningRate);

    }

}
