package lotto.controller;

import lotto.Lotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.LottosOutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    LottoService lottoService;

    LottoController(){
        lottoService = new LottoService();
    }

    public void gameStart(){
        int number = InputView.getLottoNumber();
        List<Lotto> lottos = generateLottos(number);
        printLottos(lottos);
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


}
