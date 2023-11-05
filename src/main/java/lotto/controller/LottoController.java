package lotto.controller;

import lotto.exceptionhandler.ExceptionHandler;
import lotto.exceptionhandler.RetryExceptionHandler;
import lotto.model.LottoStore;
import lotto.model.Lottos;
import lotto.model.domain.LottoAnswer;
import lotto.model.domain.Results;
import lotto.model.domain.result.ResultFactory;
import lotto.model.lottogenerator.AnswerGenerator;
import lotto.view.LottoGameUI;
import lotto.view.TerminalUI;
import lotto.ui.Writer;
import lotto.model.lottogenerator.RandomLottoGenerator;

public class LottoController {

    final private ExceptionHandler retryHandler;
    final private LottoStore store;
    final private LottoGameUI ui;

    private Lottos lottos;
    //private AnswerGenerator answerGenerator;
    private LottoAnswer answer;
    ResultFactory factory = new ResultFactory();
    Results results = new Results();

    public LottoController(ExceptionHandler handler, LottoStore store, LottoGameUI ui){
        this.retryHandler = handler;
        this.store = store;
        this.ui = ui;
    }

    public void run(){
        purchaseLotto();
        createAnswer();
    }

    private void purchaseLotto() {
        lottos = retryHandler.getResult(
                () -> {
                    int money = ui.getMoney();
                    return store.purchase(money);
                }); // vs inline code
        Writer.printModelsInList(lottos.getLottosDTO());
    }

    private void createAnswer(){
        AnswerGenerator answerGenerator = retryHandler.getResult(
                ()-> new AnswerGenerator(ui.getAnswerNumber(), ui.getBonusNumber()));
        answer = (LottoAnswer) answerGenerator.generate();
    }

    private void computeResult(){
        lottos.getLottosDTO()
                .stream()
                .map((lotto) -> factory.getResult(lotto, answer))
                .forEach(results::addResult);
    }


}
