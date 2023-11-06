package lotto.view;

import lotto.model.Lotto;

import java.util.List;
import java.util.Map;

public class OutputView {
    public static void printLottoTickets(List<Lotto> lottoTickets) {
        System.out.println(lottoTickets.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottoTickets) {
            System.out.println(lotto);
        }
    }

    public static void printWinningResult(Map<Integer, Integer> winningResult) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (int i = Lotto.NUMBER_COUNT; i > 0; i--) {
            if (winningResult.get(i) > 0) {
                System.out.println(i + "개 일치 (" + calculatePrize(i) + "원)- " + winningResult.get(i) + "개");
            }
        }
    }

    private static int calculatePrize(int matchedCount) {
        // 여기에 맞는 번호의 개수에 따른 상금을 계산하는 로직을 구현하세요.
        return 0;
    }
}
