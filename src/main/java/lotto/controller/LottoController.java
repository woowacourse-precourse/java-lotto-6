package lotto.controller;

import static lotto.domain.StaticsEnum.MATCHED_FIVE;
import static lotto.domain.StaticsEnum.MATCHED_FIVE_WITH_BONUS;
import static lotto.domain.StaticsEnum.MATCHED_FOUR;
import static lotto.domain.StaticsEnum.MATCHED_SIX;
import static lotto.domain.StaticsEnum.MATCHED_THREE;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.StaticsEnum;
import lotto.domain.model.AmountMoney;
import lotto.domain.model.BonusNumber;
import lotto.domain.model.Lotto;
import lotto.domain.model.ResultTable;
import lotto.domain.model.WinningLotto;
import lotto.domain.service.LottoService;
import lotto.exception.defaultexception.LottoDefaultException;
import lotto.exception.lottoamountexception.LottoAmountInputException;
import lotto.exception.lottonumbersexception.LottoNumbersInputException;
import lotto.utils.Calculator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private LottoService lottoService;
    private Map<StaticsEnum, ResultTable> statistics;

    public LottoController() {
        this.lottoService = new LottoService();
        this.statistics = new HashMap();
        statistics.put(MATCHED_THREE, new ResultTable(MATCHED_THREE));
        statistics.put(MATCHED_FOUR, new ResultTable(MATCHED_FOUR));
        statistics.put(MATCHED_FIVE, new ResultTable(MATCHED_FIVE));
        statistics.put(MATCHED_FIVE_WITH_BONUS, new ResultTable(MATCHED_FIVE_WITH_BONUS));
        statistics.put(MATCHED_SIX, new ResultTable(MATCHED_SIX));
    }

    public void run() {
        // 로또 구입 금액 입력
        AmountMoney amountMoney = makeAmountMoney();
        int lottoCount = Calculator.getLottoCount(amountMoney.getAmount());

        // 로또 번호 생성 및 출력
        List<Lotto> lottoList = lottoService.makeLottoList(lottoCount);
        OutputView.displayLottoPurchase(lottoList);

        // 당첨 번호, 보너스 번호 입력
        Lotto targetLotto = makeTargetLotto();
        WinningLotto winningLotto = makeWinningLotto(targetLotto);

        // 당첨 통계 계산 및 출력
        lottoService.updateWinningStatistics(lottoList, winningLotto, statistics);
        OutputView.displayFinalResult(statistics);

        // 수익 계산 및 출력
        double profitRate = lottoService.makeProfitRate(amountMoney, statistics);
        OutputView.displayTotalProfitRate(profitRate);
    }

    private AmountMoney makeAmountMoney() {
        while (true) {
            try {
                return InputView.promptPurchaseAmount();
            } catch (LottoDefaultException | LottoAmountInputException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Lotto makeTargetLotto() {
        while (true) {
            try {
                return InputView.promptMakeLotto();
            } catch (LottoDefaultException | LottoNumbersInputException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private WinningLotto makeWinningLotto(Lotto targetLotto) {
        while (true) {
            try {
                BonusNumber bonusNumber = makeBonusNumber();
                return new WinningLotto(targetLotto, bonusNumber);
            } catch (LottoDefaultException | LottoNumbersInputException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private BonusNumber makeBonusNumber() {
        while (true) {
            try {
                return InputView.promptBonusNumber();
            } catch (LottoDefaultException | LottoNumbersInputException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}