package lotto.controller;

import lotto.constance.PrintConst;
import lotto.exceptionhandler.ExceptionHandler;
import lotto.exceptionhandler.RetryExceptionHandler;
import lotto.model.Lottos;
import lotto.ui.Reader;
import lotto.ui.Writer;
import lotto.util.LottoGenerator;
import lotto.util.RandomLottoGenerator;

public class LottoController {

    ExceptionHandler retryHandler = new RetryExceptionHandler();
    LottoGenerator lottoGenerator = new RandomLottoGenerator();

    //TODO 1. 로또 구매
    public void purchaseLotto(){
        retryHandler.run(()->{
            Writer.printGuide(PrintConst.GUIDE_PURCHASE);
            int money = Reader.getMoney();
            Lottos lottos = lottoGenerator.purchase(money);
            Writer.printModelsInList(lottos.getLottos());
        });
    }

    //TODO 3. 로또 6자리 입력

    //TODO 4. 보너스 번호 입력

    //TODO 5. 결과 생성 및 처리
}
