package lotto.controller;

import lotto.Lotto;
import lotto.model.Result;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.LastResultOutputView;
import lotto.view.LottosOutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private final LottoService lottoService;

    public LottoController(){
        this.lottoService = new LottoService();
    }

    public void gameStart(){
        int number = InputView.getLottoNumber();
        List<Lotto> lottos = generateLottos(number);
        printLottos(lottos);
        List<Integer> wonLotto = InputView.inputWonLottoNumbers();
        int bonusNumber = InputView.inputBonusNumber(wonLotto);
        Result result = lottoService.calculateTotalResult(lottos,wonLotto,bonusNumber);
        printResult(result,number*lottos.size()*1000);
    }

    public LottosOutputView printLottos(List<Lotto> lottos){
        return new LottosOutputView(lottos);
    }

    public List<Lotto> generateLottos(int number){
        List<Lotto> lottos = new ArrayList<>();
        for(int i=0;i<number;++i){
            Lotto lotto = new Lotto(lottoService.generateLotto());
            lottos.add(lotto);
        }
        return lottos;
    }

    public LastResultOutputView printResult(Result result,int inputCost){
        return new LastResultOutputView(result,inputCost);
    }


}
