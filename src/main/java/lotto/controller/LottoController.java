package lotto.controller;

import java.util.List;
import lotto.exception.exceptionhandler.ExceptionHandler;
import lotto.model.LottoStore;
import lotto.model.domain.Lottos;
import lotto.model.domain.lotto.Lotto;
import lotto.model.domain.lotto.LottoAnswer;
import lotto.model.domain.Results;
import lotto.model.domain.Revenue;
import lotto.model.domain.result.ResultFactory;
import lotto.model.lottogenerator.AnswerGenerator;
import lotto.view.LottoGameUI;

public class LottoController {

    final private ExceptionHandler handler;
    final private LottoStore store;
    final private LottoGameUI ui;

    ResultFactory factory = new ResultFactory();
    Results results = new Results();

    public LottoController(ExceptionHandler handler, LottoStore store, LottoGameUI ui){
        this.handler = handler;
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
        return handler.getResult(ui::getMoney);
    }

    private Lottos purchaseLotto(int money) {
        Lottos lottos = store.purchase(money);
        List<Lotto> purchasedLottos = lottos.getLottosDTO();
        ui.printPurchasedLottos(purchasedLottos);
        return lottos;
    }

    private LottoAnswer createAnswer(){
        AnswerGenerator answerGenerator = handler.getResult(
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
        Revenue revenue = new Revenue(prize, money);
        ui.printRevenue(revenue);
    }
}
