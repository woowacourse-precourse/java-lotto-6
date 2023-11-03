package lotto.controller;

import lotto.constance.PrintConst;
import lotto.exceptionhandler.ExceptionHandler;
import lotto.exceptionhandler.RetryExceptionHandler;
import lotto.ui.Writer;

public class LottoController {

    ExceptionHandler retryHandler = new RetryExceptionHandler();

    //TODO 1. 로또 구매
    public void purchaseLotto(){
        retryHandler.run(()->{
            Writer.printGuide(PrintConst.GUIDE_PURCHASE);

        });
    }

    //TODO 2. 로또 생성

    //TODO 3. 로또 6자리 입력

    //TODO 4. 보너스 번호 입력

    //TODO 5. 결과 생성 및 처리
}
