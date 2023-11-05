package VIew;

import Utils.LottoRank;
import Utils.Messages;
import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;

import java.util.List;
import java.util.Map;

public class LottoView {

    /*public Lotto promptForWinningNumbers() {
        System.out.println(Messages.INPUT_WINNING_NUMBERS);
        return new Lotto(Console.readLine());
    }*/

    public int promptForBonusNumber() {
        System.out.println(Messages.INPUT_BONUS_NUMBER);
        return Integer.parseInt(Console.readLine());
    }

    public void printWinningStatistics(Map<LottoRank, Integer> statistics) {
        System.out.println(Messages.WINNING_STATISTICS);
        System.out.println(Messages.UNDER_BAR);
        statistics.forEach((rank, value) -> {
            if (rank != LottoRank.NONE) {
                System.out.println(rank.getDescription() + " - " + value + "개");
            }
        });
    }
}
