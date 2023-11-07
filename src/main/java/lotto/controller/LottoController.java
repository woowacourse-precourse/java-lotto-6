package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    public void run(){
        while(true){
            try{
                int inputMoney = InputView.inputMoney();
                LottoMoney lottoMoney = new LottoMoney(inputMoney);
                OutputView.printLottoCount(lottoMoney);

                Lottos lottos = new Lottos(lottoMoney.getLottoCount());
                OutputView.printLottos(lottos);

                List<Integer> winningNumbers = InputView.inputWinningNumbers();
                int bonusNumber = InputView.inputBonusNumber();
                WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
                List<Rank> ranks = lottos.matchAllLotto(winningLotto);

                LottoResult lottoResult = new LottoResult(ranks);
                OutputView.printLottoResult(lottoResult, lottoMoney);

                break;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
