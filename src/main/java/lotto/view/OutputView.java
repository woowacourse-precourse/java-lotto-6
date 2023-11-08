package lotto.view;

import lotto.model.Lotto;

import java.util.List;
import java.util.Map;

public class OutputView {
    public static void printWinningResult(Map<Integer, Integer> winningResult, Lotto winningLotto, int bonusBall) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        for (int i = Lotto.NUMBER_COUNT; i > 0; i--) {
            if (winningResult.get(i) > 0) {
                int prize = calculatePrize(i, winningLotto, bonusBall); // winningLotto와 bonusBall을 전달
                System.out.println(i + "개 일치 (" + prize + "원)- " + winningResult.get(i) + "개");
            }
        }
    }

    private static int calculatePrize(int matchedCount, Lotto winningLotto, int bonusBall) {
        if (matchedCount == 6) {
            return winningLotto.isBonusMatch(bonusBall) ? 2_000_000_000 : 1_000_000_000;
        } else if (matchedCount == 5) {
            return winningLotto.isBonusMatch(bonusBall) ? 30_000_000 : 1_500_000;
        } else if (matchedCount == 4) {
            return 50_000;
        } else if (matchedCount == 3) {
            return 5_000;
        } else {
            return 0;
        }
    }

    public static void printLottoTickets(List<Lotto> lottoTickets) {
        System.out.println(lottoTickets.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottoTickets) {
            System.out.println(lotto);
        }
    }
}


