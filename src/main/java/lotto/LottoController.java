package lotto;

import java.math.BigDecimal;
import java.util.List;
import lotto.domain.lotto.LottoService;
import lotto.domain.lotto.entity.Lotto;
import lotto.domain.lotto.entity.LottoAnswer;
import lotto.domain.lotto.entity.LottoResultCount;
import lotto.domain.lotto.entity.Lottos;
import lotto.domain.lotto.generator.RandomLottoGenerator;
import lotto.domain.lotto.money.Money;
import lotto.exception.RetryExceptionHandler;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public static final BigDecimal PERCENT_DECIMAL = new BigDecimal(100);
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final RetryExceptionHandler handler = new RetryExceptionHandler();
    private final LottoService lottoService = new LottoService(new RandomLottoGenerator());

    void run() {
        //로또 구입
        Money purchaseMoney = getPurchaseMoney();
        Lottos lottos = purchaseLotto(purchaseMoney);
        printPurchasedLotto(lottos);

        //정답 생성
        LottoAnswer answer = getLottoAnswer();

        //결과 출력
        LottoResultCount results = lottos.getResults(answer);
        printResult(results);
        printRevenu(purchaseMoney, results);
    }

    private void printRevenu(Money purchaseMoney, LottoResultCount results) {
        BigDecimal initMoney = purchaseMoney.toBigDecimal();
        BigDecimal totalPrize = results.getTotalPrize();
        outputView.printRevenue(totalPrize.divide(initMoney).multiply(PERCENT_DECIMAL));
    }

    private void printResult(LottoResultCount results) {
        outputView.printResults(results);
    }

    private Money getPurchaseMoney() {
        return handler.get(() -> {
            int purchaseMoney = inputView.getPurchaseMoney();
            return Money.nonZeroMoney(purchaseMoney);
        });

    }

    private Lottos purchaseLotto(Money purchaseMoney) {
        return lottoService.purchaseLottos(purchaseMoney);
    }

    private LottoAnswer getLottoAnswer() {
        Lotto lotto = getLottoUsingInput();
        return generateLottoAnswer(lotto);
    }

    private LottoAnswer generateLottoAnswer(Lotto lotto) {
        return handler.get(() -> {
                    int bonusNumber = inputView.getBonusNumber();
                    return new LottoAnswer(lotto, bonusNumber);
                }
        );
    }

    private Lotto getLottoUsingInput() {
        return handler.get(() -> {
                    List<Integer> lottoNumbers = inputView.getLottoNumbers();
                    return new Lotto(lottoNumbers);
                }
        );
    }

    private void printPurchasedLotto(Lottos lottos) {
        outputView.printPurchasedLotto(lottos);
    }
}
