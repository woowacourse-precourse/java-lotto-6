package lotto.view;

import java.util.List;
import lotto.model.Score;

public class OutputView {

    private static final String PRINT_LOTTOS_COUNT = "개를 구매했습니다.";

    public void printTicketingLottos(int count, String lottos) {
        System.out.println(count + PRINT_LOTTOS_COUNT);
        System.out.println(lottos);
    }

    public void printScore(List<Score> scores) {
        System.out.println("당첨 통계\n" + "---");
        System.out.println(Score.stats(scores));
    }
}
