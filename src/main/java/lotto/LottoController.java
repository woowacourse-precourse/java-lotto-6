package lotto;

import java.util.List;
import lotto.domain.lotto.LottoService;
import lotto.domain.lotto.entity.Lotto;
import lotto.domain.lotto.entity.LottoAnswer;
import lotto.domain.lotto.entity.LottoResults;
import lotto.domain.lotto.entity.Lottos;
import lotto.domain.lotto.generator.RandomLottoGenerator;
import lotto.exception.RetryExceptionHandler;
import lotto.view.InputView;
import lotto.view.io.OutputView;

public class LottoController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final RetryExceptionHandler handler = new RetryExceptionHandler();
    private final LottoService lottoService = new LottoService(new RandomLottoGenerator());

    void run() {
        //로또 구입
        int purchaseMoney = getPurchaseMoney();
        Lottos lottos = purchaseLotto(purchaseMoney);
        printPurchasedLotto(lottos);

        //정답 생성
        LottoAnswer answer = getLottoAnswer();

        //결과 출력
        LottoResults results = lottos.getResults(answer);
    }

    private int getPurchaseMoney() {
        return handler.get(inputView::getPurchaseMoney);
    }

    //todo 시간이 된다면 빌더 패턴을 적용해 보자. 메서드 구분이 깔끔해 질 것 같다.
    private Lottos purchaseLotto(int purchaseMoney) {
        return lottoService.purchaseLottos(purchaseMoney);
    }

    private LottoAnswer getLottoAnswer() {
        Lotto lotto = getLottoUsingInput();
        return generateLottoAnswer(lotto);
        //빌더를 쓰면 정말 깔끔할 것 같긴 하나...
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
