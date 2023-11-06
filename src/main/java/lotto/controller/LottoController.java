package lotto.controller;

import java.util.List;
import lotto.exception.exceptionhandler.ExceptionHandler;
import lotto.model.LottoStore;
import lotto.model.domain.Money;
import lotto.model.domain.Revenue;
import lotto.model.domain.lotto.Lotto;
import lotto.model.domain.lotto.LottoAnswer;
import lotto.model.domain.lotto.Lottos;
import lotto.model.domain.lotto.lottogenerator.AnswerGenerator;
import lotto.model.domain.result.LottoResultFactory;
import lotto.model.domain.result.LottoResults;
import lotto.view.TerminalUI;

public class LottoController {

    final private ExceptionHandler handler;
    final private LottoStore store;
    final private TerminalUI ui;

    LottoResultFactory factory = new LottoResultFactory();
    LottoResults lottoResults = new LottoResults();

    public LottoController(ExceptionHandler handler, LottoStore store) {
        this.handler = handler;
        this.store = store;
        this.ui = new TerminalUI();
    }

    public void run() {
        Money money = getMoney();
        Money initialMoney = money.snapShot();
        Lottos lottos = purchaseLotto(money);
        LottoAnswer answer = createAnswer();
        LottoResults lottoResults = computeResult(lottos, answer);
        computeRevenue(initialMoney, lottoResults);
    }

    private Money getMoney() {
        return handler.getResult(() -> new Money(ui.getMoney()));
    }

    private Lottos purchaseLotto(Money money) {
        Lottos lottos = store.purchase(money);
        List<Lotto> purchasedLottos = lottos.getLottos();
        ui.printPurchasedLottos(purchasedLottos);
        return lottos;
    }

    private LottoAnswer createAnswer() {
        AnswerGenerator answerGenerator = handler.getResult(
                () -> new AnswerGenerator(ui.getAnswerNumber(), ui.getBonusNumber()));
        return answerGenerator.generate();
    }

    private LottoResults computeResult(Lottos lottos, LottoAnswer answer) {
        lottos.getLottos()
                .stream()
                .map(answer::compareLotto)
                .map(factory::getLottoResult)
                .forEach(lottoResults::addResult);
        ui.printResult(lottoResults.getResults());
        return lottoResults;
    }

    private void computeRevenue(Money money, LottoResults lottoResults) {
        long prize = lottoResults.getResults()
                .stream()
                .mapToLong(result -> (long) result.getKey().getPrize() * result.getValue())
                .sum();
        Revenue revenue = new Revenue(prize, money);
        ui.printRevenue(revenue);
    }
}
