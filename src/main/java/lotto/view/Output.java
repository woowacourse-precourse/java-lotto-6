package lotto.view;

import lotto.Lotto;
import lotto.domain.Member;

public class Output {
    public static final String PURCHASE_RESULT_OUTPUT = "개를 구매했습니다.";
    public static final String STATISTIC_RESULT_OUTPUT = "당첨 통계";
    public static final String NEXT_LINE_OUTPUT = "---";

    public void purchaseResult(Member member) {
        int purchasedCount = member.getPurchasedCount();
        print(purchasedCount + PURCHASE_RESULT_OUTPUT);

        member.getLottos().stream()
                .forEach(Output::printLotto);
    }
    public void gameResult() {
        print(STATISTIC_RESULT_OUTPUT);
        print(NEXT_LINE_OUTPUT);

        // TODO: enum통해 구현? 어케하는거지
    }

    private static void printLotto(final Lotto lotto) {
        System.out.println(lotto.getNumbers());
    }

    private static void print(String message) {
        System.out.println(message);
    }
}
