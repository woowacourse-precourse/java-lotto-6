package lotto.controller;

import lotto.domain.Lotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    private final LottoService lottoService;

    public LottoController() {
        this.lottoService = new LottoService();
    }



    //실제 실행
    public void run() throws IllegalArgumentException{

        try {
            int money = InputView.inputMoney();
            int times = lottoService.convertToTimes(money);

            List<Lotto> lottoes = lottoService.createLottoes(times);

            OutputView.printPurchaseLotto(lottoes);




        } catch (IllegalArgumentException e){
            e.printStackTrace();
            return;
        }

    }
}
