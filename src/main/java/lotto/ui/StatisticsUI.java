package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.Map;
import lotto.domain.BonusBall;
import lotto.domain.Lotto;
import lotto.domain.LottoPrize;
import lotto.domain.LottoTickets;
import lotto.domain.WinningLotto;
import lotto.util.LottoPrizeCalculator;

/**
 * @author 민경수
 * @description statistics ui
 * @since 2023.11.06
 **********************************************************************************************************************/
public class StatisticsUI {

    private final InputUI inputUI;
    private final ResultUI resultUI;

    public StatisticsUI(InputUI inputUI, ResultUI resultUI) {
        this.inputUI = inputUI;
        this.resultUI = resultUI;
    }

    public void printStatistic(LottoTickets boughtLottos) {
        Lotto winningLotto = getWinningNumber();
        BonusBall bonusNumber = getBonusNumber(winningLotto);
        WinningLotto winningLottoAndBonusNumber = WinningLotto.of(winningLotto, bonusNumber);
        Map<LottoPrize, Integer> result = LottoPrizeCalculator.getResult(winningLottoAndBonusNumber, boughtLottos);

        resultUI.printStatistics(result, boughtLottos);
    }

    private Lotto getWinningNumber() {
        while (true) {
            try {
                return Lotto.of(getWinningLotto());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private BonusBall getBonusNumber(Lotto winningLotto) {
        while (true) {
            try {
                int bonusBall = inputUI.getBonusBall();
                winningLotto.contain(bonusBall);
                return BonusBall.valueOf(bonusBall);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> getWinningLotto() {
        return inputUI.getWinningLotto();
    }

}