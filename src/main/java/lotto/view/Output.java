package lotto.view;

import lotto.domain.result.CompareMachine;
import lotto.domain.result.LottoResult;
import lotto.domain.user.UserLotto;
import lotto.option.EqualStatus;

public class Output {
    private Output() {
    }

    public static void userLotto(UserLotto userLotto) {
        System.out.println();
        System.out.println(userLotto.size() + "개를 구매했습니다.");
        for (int i = 0; i < userLotto.size(); i++) {
            System.out.println(userLotto.indexOf(i).numbers());
        }
    }

    public static void lottoResult(CompareMachine compareMachine) {
        System.out.println();
        System.out.println("당첨통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - "
                + compareMachine.getWinStatus().get(new LottoResult(EqualStatus.THREE_EQUAL)) + "개");
        System.out.println("4개 일치 (50,000원) - "
                + compareMachine.getWinStatus().get(new LottoResult(EqualStatus.FOUR_EQUAL)) + "개");
        System.out.println("5개 일치 (1,500,000원) - "
                + compareMachine.getWinStatus().get(new LottoResult(EqualStatus.FIVE_EQUAL)) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "
                + compareMachine.getWinStatus().get(new LottoResult(EqualStatus.FIVE_AND_BONUS_EQUAL)) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - "
                + compareMachine.getWinStatus().get(new LottoResult(EqualStatus.SIX_EQUAL)) + "개");
    }

    public static void rateOfReturn(double rate) {
        System.out.printf("총 수익률은 %.1f%%입니다.", rate);
    }

    public static void message(String message) {
        System.out.println(message);
    }
}
