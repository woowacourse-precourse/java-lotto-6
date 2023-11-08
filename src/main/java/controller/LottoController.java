package controller;

import domain.Lotto;
import domain.Place;
import service.LottoService;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {
    private LottoService lottoService;
    public void lottoStart(){

        int purchasePrice = InputView.inputPurchasePrice();
        int numberOfLotto = OutputView.outputNumberOfLotto(purchasePrice);

        lottoService = new LottoService(numberOfLotto);

        List<List<Integer>> lottos = OutputView.outputLottos(numberOfLotto);

        for(List<Integer> lottoList: lottos){
            Lotto lotto = new Lotto(lottoList);
            lottoService.addLotto(lotto);
        }

        List<Integer> winningNumber = InputView.inputWinningNumber();
        Lotto winningLotto = new Lotto(winningNumber);

        int bonusNumber = InputView.inputBonusNumber(winningNumber);

        Map<Place, Integer> numberOfWins = lottoService.numberOfWins(winningLotto, bonusNumber);

        Long profit = OutputView.outputStatics(numberOfWins);

        OutputView.outputRate(purchasePrice,profit);
    }
}
