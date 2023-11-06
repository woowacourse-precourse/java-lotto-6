package lotto.view;

import lotto.model.Lottos;
import lotto.view.viewArgument.LottoPrizeMoney;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class OutputView {

    private static final String INPUT_PURCHASE_MONEY = "구입급액을 입력해주세요.";
    private static final String PURCHASED_COUNT = "%n%d개를 구매했습니다.%n";
    private static final String PURCHASED_NUMBER = "[%s%n]";
    private static final String INPUT_WIN_NUMBER = "%n당첨 번호를 입력해주세요.%n";
    private static final String INPUT_BONUS_NUMBER = "%n보너스 번호를 입력해 주세요.%n";
    private static final String WINNING_STATS = "%n당첨 통계%n";
    private static final String DIVISION_LINE = "---%n";
    private static final String CORRECTING_COUNT = "%s개 일치 (%s원) - %s개%n";
    private static final String CORRECTING_COUNT_WITH_BONUS = "%s개 일치, 보너스 볼 일치 (%s원) - %s개%n";
    private static final String EARNINGS_RATIO = "총 수익률은 %.1f%n";
    private static final String COUNT_WITH_BONUS = "5 + bonus";

    public void printInputPurchaseMoney() {
        System.out.println(INPUT_PURCHASE_MONEY);
    }
    public void printPurchaseResult(int purchaseCount) {
        System.out.printf(PURCHASED_COUNT, purchaseCount);

        Lottos lottos = new Lottos();
        List<String> purchasedNumbers = lottos.printNumbers(purchaseCount);

        for (String numbers : purchasedNumbers) {
            System.out.printf(PURCHASED_NUMBER, numbers);
        }

    }

    public void printInputWinningNumber() {
        System.out.printf(INPUT_WIN_NUMBER);
    }

    public void printInputBonusNumber() {
        System.out.printf(INPUT_BONUS_NUMBER);
    }

    public void printWinningState() {
        System.out.printf(WINNING_STATS);
        System.out.printf(DIVISION_LINE);
    }

    public void printWinningDetail(String correctCount, int prizeMoney, int winningCount) {
        DecimalFormat df = new DecimalFormat("###,###");

        if (correctCount.equals(COUNT_WITH_BONUS)) {
            System.out.printf(CORRECTING_COUNT_WITH_BONUS, correctCount, df.format(prizeMoney), winningCount);
            return;
        }
        System.out.printf(CORRECTING_COUNT, correctCount, df.format(prizeMoney), winningCount);

    }

    public void printEarningRatio(int earningMoney) {
        System.out.printf(EARNINGS_RATIO, earningMoney);
    }

}
