package lotto.generator;

import java.util.Arrays;
import java.util.List;
import lotto.domain.lotto.LottoReward;
import lotto.dto.WinningResults;

public class WinningResultMessageGenerator {

    private static final List<String> WINNING_MESSAGES = List.of(
            "3개 일치 (5,000원) - %d개\n",
            "4개 일치 (50,000원) - %d개\n",
            "5개 일치 (1,500,000원) - %d개\n",
            "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n",
            "6개 일치 (2,000,000,000원) - %d개\n"
    );

    private static final String RESULT_WINNING_PRIZE_FORMAT = "총 수익률은 %.1f%%입니다.\n";

    private WinningResultMessageGenerator() {
    }

    public static String generate(final WinningResults winningResult) {
        List<Integer> winningCounts = Arrays.stream(LottoReward.values())
                .filter(lottoReward -> lottoReward != LottoReward.FAIL)
                .map(winningResult::getRewardCount)
                .toList();

        StringBuilder resultMessage = new StringBuilder();
        for (int i = 0; i < winningCounts.size(); i++) {
            resultMessage.append(String.format(WINNING_MESSAGES.get(i), winningCounts.get(i)));
        }
        resultMessage.append(String.format(RESULT_WINNING_PRIZE_FORMAT, winningResult.calculatePercentageReturn()));
        return resultMessage.toString();
    }
}
