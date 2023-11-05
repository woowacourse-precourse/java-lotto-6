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

    ResultFactory factory = new ResultFactory();
    Results results = new Results();

    public LottoController(ExceptionHandler handler, LottoStore store, LottoGameUI ui){
        this.retryHandler = handler;
        this.store = store;
        this.ui = ui;
    }

    public void run(){
        int money = getMoney();
        Lottos lottos = purchaseLotto(money);
        LottoAnswer answer = createAnswer();
        Results results = computeResult(lottos, answer);
        computeRevenue(money, results);
    }

    private int getMoney() {
        return retryHandler.getResult(ui::getMoney);
    }

    private Lottos purchaseLotto(int money) {
        Lottos lottos = store.purchase(money);
        Writer.printModelsInList(lottos.getLottosDTO());
        return lottos;
    }

    private LottoAnswer createAnswer(){
        AnswerGenerator answerGenerator = retryHandler.getResult(
                ()-> new AnswerGenerator(ui.getAnswerNumber(), ui.getBonusNumber()));
        return (LottoAnswer) answerGenerator.generate();
    }

    private Results computeResult(Lottos lottos, LottoAnswer answer){
        lottos.getLottosDTO()
                .stream()
                .map((lotto) -> factory.getResult(lotto, answer))
                .forEach(results::addResult);
        ui.printResult(results.getResults());
        return results;
    }

    private void computeRevenue(int money, Results results){
        long prize = results.getResults()
                .stream()
                .mapToLong(result -> (long) result.getKey().getPrize() * result.getValue())
                .sum();
        double revenue = prize / (double) money;
        ui.printRevenue(revenue);
    }


}
