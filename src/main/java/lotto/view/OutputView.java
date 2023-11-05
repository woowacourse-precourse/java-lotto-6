package lotto.view;

import lotto.model.Lotto;
import lotto.model.Lottos;

import java.util.List;

public class OutputView {

    private static final String INPUT_PURCHASE_MONEY = "구입급액을 입력해주세요.";
    private static final String PURCHASED_COUNT = "%n%d개를 구매했습니다.%n";
    private static final String PURCHASED_NUMBER = "[%s%n]";
    private static final String INPUT_WIN_NUMBER = "당첨 번호를 입력해주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.%n";
    private static final String WIN_STATS = "당첨 통계%n";
    private static final String DIVISION_LINE = "---%n";
    private static final String CORRECTING_COUNT = "%s개 일치 (%s) - %s개%n";
    private static final String CORRECTING_COUNT_WITH_BONUS = "%s개 일치, 보너스 볼 일치 (%s) - %s개%n";
    private static final String EARNINGS_RATIO = "총 수익률은 %.1f%n";

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
    //구매 번호 출력

}
