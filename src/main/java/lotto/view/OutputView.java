package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Winning;
import lotto.dto.NumbersParam;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class OutputView {
    public static final String askMoneyMessage = "구입금액을 입력해 주세요.";
    public static final String askWinningNumbersMessage = "당첨 번호를 입력해 주세요.";
    public static final String askBonusNumberMessage = "보너스 번호를 입력해 주세요.";
    public static final String noticeTrialMessage = "개를 구매했습니다.";
    public static final String alertResultMessage = "당첨 통계\n---";

    public static void printAskMoneyMessage() {
        System.out.println(askMoneyMessage);
    }

    public static void printNoticeTrialMessage(int trial) {
        System.out.println(trial + noticeTrialMessage);
    }

    public static void printBoughtLottos(List<Lotto> lottos) {
        List<NumbersParam> numbersParams = lottos.stream()
                .map(lotto -> NumbersParam.from(lotto.getNumbers()))
                .toList();
        for (NumbersParam param : numbersParams) {
            System.out.println("[" + String.join(", ", param.numbers()) + "]");
        }
    }

    public static void printAskWinningNumbersMessage() {
        System.out.println(askWinningNumbersMessage);
    }

    public static void printAskBonusNumberMessage() {
        System.out.println(askBonusNumberMessage);
    }

    public static void printAlertResultMessage() {
        System.out.println(alertResultMessage);
    }
    public static void printWinningResult(int[] resultCounter) {
        for (int index = 0; index < 5; index++) {
            Winning winning = Winning.values()[index];
            String status = winning.getStatus();
            String reward = String.format("%,d", winning.getReward());
            int counter = resultCounter[index];
            System.out.println(status + " (" + reward + "원) - " + counter + "개");
        }
    }
}
