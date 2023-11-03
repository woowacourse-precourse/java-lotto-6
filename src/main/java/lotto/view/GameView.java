package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.WinningStatistics;
import lotto.utils.LottoFormatter;
import lotto.utils.WinningStatisticsFormatter;

import java.util.List;

public class GameView {
    private final LottoFormatter lottoFormatter;
    private final WinningStatisticsFormatter winningStatisticsFormatter;

    public GameView(LottoFormatter lottoFormatter, WinningStatisticsFormatter winningStatisticsFormatter) {
        this.lottoFormatter = lottoFormatter;
        this.winningStatisticsFormatter = winningStatisticsFormatter;
    }

    public String getPurchaseAmountInput() {
        System.out.println("구입 금액을 입력해 주세요.");
        String input = getInput();

        return input;
    }

    public void showLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");

        String formattedLottos = lottoFormatter.format(lottos);

        System.out.println(formattedLottos);
    }

    public String getWinningNumbersInput() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = getInput();

        return input;
    }

    public String getBonusNumberInput() {
        System.out.println("보너스 번호를 입력해주세요.");
        String input = getInput();

        return input;
    }

    public void showWinningStatistics(WinningStatistics winningStatistics) {
        String formattedStatistics = winningStatisticsFormatter.format(winningStatistics);
        System.out.println(formattedStatistics);
    }

    private String getInput() {
        return Console.readLine();
    }
}
