package lotto.controller;

import lotto.exceptionhandler.ExceptionHandler;
import lotto.exceptionhandler.RetryExceptionHandler;
import lotto.model.LottoStore;
import lotto.model.Lottos;
import lotto.model.domain.LottoAnswer;
import lotto.model.lottogenerator.AnswerGenerator;
import lotto.view.LottoGameUI;
import lotto.view.TerminalUI;
import lotto.ui.Writer;
import lotto.model.lottogenerator.RandomLottoGenerator;

public class LottoController {

    private ExceptionHandler retryHandler = new RetryExceptionHandler();
    private LottoStore store = new LottoStore(new RandomLottoGenerator());
    private LottoGameUI ui = new TerminalUI();

    //TODO 1. 로또 구매
    public Lottos purchaseLotto() {
        int money = retryHandler.getResult(() -> ui.getMoney());
        Lottos lottos = store.purchase(money);
        Writer.printModelsInList(lottos.getLottosDTO());

        return lottos;
    }

    public LottoAnswer getAnswer(){
        AnswerGenerator answerGenerator = retryHandler.getResult(
                ()-> new AnswerGenerator(ui.getAnswerNumber(), ui.getBonusNumber()));
        return (LottoAnswer) answerGenerator.generate();
    }

    //TODO 4. 보너스 번호 입력

    //TODO 5. 결과 생성 및 처리
}
