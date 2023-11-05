package lotto.domain.Controller;

import lotto.domain.Model.LottoContainer;
import lotto.domain.Service.LottoMakingService;
import lotto.View.LottoInputView;
import lotto.View.LottoOutputView;
import lotto.domain.Service.LottoWinningService;

import java.util.List;
import java.util.Map;

public class LottoController {

    private final LottoInputView lottoInputView;
    private final LottoOutputView lottoOutputView;
    private final LottoMakingService lottoMakingService;
    private final LottoWinningService lottoWinningService;

    public LottoController(LottoInputView lottoInputView,
                           LottoOutputView lottoOutputView,
                           LottoMakingService lottoMakingService) {
        this.lottoInputView = lottoInputView;
        this.lottoOutputView = lottoOutputView;
        this.lottoMakingService = lottoMakingService;
        this.lottoWinningService = new LottoWinningService();

    }

    public void run() {
        int cash = lottoInputView.inputCash(); // 금액 입력
        LottoContainer lottoContainer = lottoMakingService.issue(cash); // 로또 구매
        lottoOutputView.printPickedLotto(lottoContainer); // 로또 출력

        List<Integer> winningNumbers = lottoInputView.inputWinningNumbers(); // 당첨 번호 입력
        int bonusNumber = lottoInputView.inputBonusNumber(winningNumbers); // 보너스 번호 입력

        Map<String, Integer> winnings
                = lottoWinningService
                .calculateWinnings(lottoContainer, winningNumbers, bonusNumber); // 최종 결과 계산
        lottoOutputView.printWinnings(winnings, cash); // 최종 결과 출력
    }
}
