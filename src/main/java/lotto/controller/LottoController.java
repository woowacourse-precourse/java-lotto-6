package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoMachine;
import lotto.model.LottoResult;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.ArrayList;


public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoMachine lottoMachine;

    private List<List<Integer>> getLottoNumbers(List<Lotto> lottos) {
        List<List<Integer>> lottoNumbers = new ArrayList<>();
        for (Lotto lotto : lottos) {
            lottoNumbers.add(lotto.getNumbers());
        }
        return lottoNumbers;
    }
    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView=inputView;
        this.outputView=outputView;
        this.lottoMachine=new LottoMachine();
    }
    public void lottoStart(){
        int purchaseAmount=inputView.getPurchase();
        List<Lotto> lottos=lottoMachine.purchaseLottos(purchaseAmount);
        outputView.printLottos(lottos.size(),getLottoNumbers(lottos));

        List<Integer> winNumbers=inputView.getWinNumbers();
        int bonusNumbers=inputView.getBounsNumbers();
        LottoResult result = lottoMachine.calculateResult(lottos,winNumbers,bonusNumbers);

        outputView.printLottoResult(result,purchaseAmount);
    }


}
