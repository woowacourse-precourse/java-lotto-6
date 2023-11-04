package lotto.controller;

import lotto.constance.PrintConst;
import lotto.exceptionhandler.ExceptionHandler;
import lotto.exceptionhandler.RetryExceptionHandler;
import lotto.model.LottoStore;
import lotto.model.Lottos;
import lotto.ui.Reader;
import lotto.ui.Writer;
import lotto.model.lottogenerator.RandomLottoGenerator;

public class LottoController {

    ExceptionHandler retryHandler = new RetryExceptionHandler();
    LottoStore store = new LottoStore(new RandomLottoGenerator());

    //TODO 1. 로또 구매
    public void purchaseLotto() {
        int money = retryHandler.getResult(
                () -> {
                    Writer.printGuide(PrintConst.GUIDE_PURCHASE);
                    return Reader.getMoney();
                });

        Lottos lottos = store.purchase(money);
        Writer.printModelsInList(lottos.getLottosDTO());
    }

    public void getAnswer(){
        retryHandler.run(()-> {
            Writer.printGuide(PrintConst.GUIDE_LOTTO_NUMBERS);

        });
    }

    //TODO 4. 보너스 번호 입력

    //TODO 5. 결과 생성 및 처리
}
