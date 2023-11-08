package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Rank;

public class GameOutput {
    public static void enterPurchaseAmoutMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void showPurchaseLottoNumber(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.stream()
                .forEach(lotto -> System.out.println(lotto.getNumbers()));
    }


    public static void enterWinnigNumbersMessage() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void enterBonusNumberMessage() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void lottoResultTitleMessage() {
        System.out.println("당첨 통계\n" + "---");
    }

    public static void earningMessage(String earningRate) {
        System.out.println("총 수익률은 " + earningRate + "%입니다.");
    }

    public static void lottoResultMessage() {
        for(Rank rank : Rank.values()) {
            System.out.println(rank.getMessage() + " - " + Rank.getRankCount(rank) + "개" );
        }
    }

    public static void printBlankLine() {
        System.out.println();
    }
}
