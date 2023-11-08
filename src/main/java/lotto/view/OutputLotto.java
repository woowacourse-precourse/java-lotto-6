package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

import static lotto.util.message.Output.*;

public class OutputLotto {
    public static void counts(int purchaseCount) {
        System.out.println("\n" + purchaseCount + PURCHASE_COUNT);
    }

    public static void numbers(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void winningHistory(int[] winning) {
        System.out.println(WINNING_STATISTICS);
        System.out.println(WINNER_FIRST+winning[0]+"개");
        System.out.println(WINNER_SECOND+winning[1]+"개");
        System.out.println(WINNER_THIRD+winning[2]+"개");
        System.out.println(WINNER_FOURTH+winning[3]+"개");
        System.out.println(WINNER_FIFTH+winning[4]+"개");
    }

    public static void incomeRate(double income) {
        System.out.println(INCOME+income+"%입니다.");
    }
}
