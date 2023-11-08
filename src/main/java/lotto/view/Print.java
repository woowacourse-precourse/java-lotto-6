package lotto.view;

import lotto.model.Lotto;
import lotto.model.Member;
import lotto.model.ScoreType;

public class Print {
    public static void howManyBuyLottos(Member member) {
        System.out.println(member.getAmount() + "개를 구매했습니다.");
        for (Lotto l: member.getLottos()) {
            System.out.println(l);
        }
        System.out.println("");
    }

    public static void lottoResult(Member member) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + ScoreType.FIFTH.getCount() + "개");
        System.out.println("4개 일치 (50,000원) - " + ScoreType.FOURTH.getCount() + "개");
        System.out.println("5개 일치 (1,500,000원) - " + ScoreType.THIRD.getCount() + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + ScoreType.SECOND.getCount() + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + ScoreType.FIRST.getCount() + "개");
        System.out.println("총 수익률은 " + member.getProfit() + "%입니다.");
    }
}
