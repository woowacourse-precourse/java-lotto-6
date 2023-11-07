package lotto.view;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.RankResult;
import lotto.util.LottoUtil;

public class OutputView {
    private static final String RESULT_HEADER = "당첨통계\n---\n";
    private static final String PURCHASE_INFO_MESSAGE = "%d개를 구매했습니다.";
    private static final String RATE_OF_RETURN_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public static void displayUserLottos(List<Lotto> userLottos) {
        System.out.printf(PURCHASE_INFO_MESSAGE, userLottos.size());
        userLottos.forEach(userLotto -> {
            System.out.println(userLotto.getDisplayFormat());
        });
    }

    public static void displayResult(RankResult rankResult, float rateOfReturn) {
        System.out.print(RESULT_HEADER + LottoUtil.convertResultToDisplayFormat(rankResult));
        System.out.printf(RATE_OF_RETURN_MESSAGE, rateOfReturn);
    }

    public static void displayExceptionMessage(Exception exception) {
        System.out.println(exception.getMessage());
    }
}
