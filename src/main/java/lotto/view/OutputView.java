package lotto.view;

import java.util.List;
import lotto.domain.GameResult;
import lotto.domain.Lotto;
import lotto.domain.Ranking;

public class OutputView {
    public final String OUTPUT_LOTTO_NUMBERS = "\n%d개를 구매했습니다.\n";
    public final String OUTPUT_START_NUMBERS = "[";
    public final String OUTPUT_FINISH_NUMBERS = "]";
    public final String OUTPUT_SPLIT_STRING= ", ";
    public final String OUTPUT_START_GAME_RESULT = "\n당첨 통계\n---";
    public final String OUTPUT_THREE_WINS = "3개 일치 (5,000원) - %d개\n";
    public final String OUTPUT_FOUR_WINS = "4개 일치 (50,000원) - %d개\n";
    public final String OUTPUT_FIVE_WINS = "5개 일치 (1,500,000원) - %d개\n";
    public final String OUTPUT_FIVE_PLUS_BONUS = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n";
    public final String OUTPUT_SIX_WINS = "6개 일치 (2,000,000,000원) - %d개\n";
    public final String OUTPUT_PROFIT_RATE = "총 수익률은 %.1f%%입니다.";


    public void printLottoNumbers(List<Lotto> lottos) {
        System.out.printf(OUTPUT_LOTTO_NUMBERS, lottos.size());
        for (Lotto lotto : lottos) {
            printNumbers(lotto.getNumbers());
        }
        printBlankLine();
    }

    public void printNumbers(List<Integer> numbers) {
        System.out.print(OUTPUT_START_NUMBERS + numbers.get(0));
        for (int i = 1; i < 6; i++) {
            System.out.print(OUTPUT_SPLIT_STRING + numbers.get(i));
        }
        System.out.println(OUTPUT_FINISH_NUMBERS);
    }

    public void printGameResult(GameResult gameResult) {
        System.out.println(OUTPUT_START_GAME_RESULT);
        System.out.printf(OUTPUT_THREE_WINS, gameResult.getRankCounts(Ranking.THREE_WINS));
        System.out.printf(OUTPUT_FOUR_WINS, gameResult.getRankCounts(Ranking.FOUR_WINS));
        System.out.printf(OUTPUT_FIVE_WINS, gameResult.getRankCounts(Ranking.FIVE_WINS));
        System.out.printf(OUTPUT_FIVE_PLUS_BONUS, gameResult.getRankCounts(Ranking.FIVE_PLUS_BONUS));
        System.out.printf(OUTPUT_SIX_WINS, gameResult.getRankCounts(Ranking.SIX_WINS));
    }

    public void printProfitRate(float profitRate) {
        System.out.printf(OUTPUT_PROFIT_RATE, profitRate);
    }

    public void printBlankLine() {
        System.out.println();
    }
}
