package lotto;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoMatchChecker;
import lotto.domain.LottoRank;
import lotto.domain.numbergenerator.NumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoGameFacade lottoGameFacade;
    private final NumberGenerator generator;
    private final LottoGenerator lottoGenerator;

    public LottoController(InputView inputView, OutputView outputView, NumberGenerator generator) {
        this.lottoGameFacade = new LottoGameFacade(inputView, outputView);
        this.generator = generator;
        this.lottoGenerator = new LottoGenerator();
    }

    public void run() {
        // 금액 입력 받고 로또 발행
        int money = lottoGameFacade.receiveValidMoney();
        List<Lotto> lottos = lottoGenerator.generate(money, generator);

        // 발행 로또 출력
        lottoGameFacade.showGeneratedLottos(lottos);

        // 당첨 번호와 보너스 번호 입력
        List<Integer> validWinningNumbers = lottoGameFacade.receiveValidWinningNumbers();
        int validBonusNumber = lottoGameFacade.receiveValidBonusNumber();

        // 결과 분석
        LottoMatchChecker lottoMatchChecker = new LottoMatchChecker(validWinningNumbers, validBonusNumber);
        Map<LottoRank, Integer> result = lottoMatchChecker.getResult(lottos);

        // 결과 출력
        lottoGameFacade.showResult(result);
    }
}
