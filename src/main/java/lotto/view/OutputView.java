package lotto.view;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.RankResult;
import lotto.util.LottoUtil;

public class OutputView {
    private static final String READ_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String READ_WINNER_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String READ_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요";
    private static final String RESULT_HEADER = "당첨통계\n---\n";
    private static final String PURCHASE_INFO_MESSAGE = "%d개를 구매했습니다.";
    private static final String RATE_OF_RETURN_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public static void requestPurchaseAmount() {
        System.out.println(READ_PURCHASE_AMOUNT_MESSAGE);
    }

    public static void requestWinnerNumber() {
        System.out.println(READ_WINNER_NUMBERS_MESSAGE);
    }

    public static void requestBonusNumber() {
        System.out.println(READ_BONUS_NUMBER_MESSAGE);
    }

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
