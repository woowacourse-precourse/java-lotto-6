package lotto.controller;

import lotto.domain.Rank;
import lotto.dto.AnswerLotto;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Arrays;
import java.util.List;

public class LottoGame {

    private final InputView inputView;
    private final LottoService lottoService;
    private final OutputView outputView;

    public LottoGame() {
        this.inputView = new InputView();
        this.lottoService = new LottoService();
        this.outputView = new OutputView();
    }

    public void run(){
        int price = inputView.inputPrice();

        LottoMachine lottoMachine = LottoMachine.getInstance();
        List<Lotto> lottos = lottoMachine.produceLottos(price);
        outputView.printLottoNumbers(lottos);
//        for(Lotto lotto : lottos){
//            System.out.println(lotto.getNumbers().toString());
//        }
        List<Integer> answerNumbers = inputView.inputAnswerNumbers();
//        System.out.println(answerNumbers.toString());
        int bonusNumber = inputView.inputBonusNumber(answerNumbers);
//        System.out.println(bonusNumber);

        AnswerLotto answerLotto = new AnswerLotto(answerNumbers, bonusNumber);

        List<Rank> winningResults = lottoService.findWinningResult(lottos, answerLotto);
//        System.out.println(Arrays.toString(winningResults.toArray()));

        double rateOfReturn = lottoService.findRateOfReturn(winningResults);

        outputView.printResult(winningResults);
        outputView.printRateOfReturn(rateOfReturn);


    }
}
