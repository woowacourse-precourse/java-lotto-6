package lotto.view;

import java.util.List;
import lotto.controller.Lotto;

public class Output {

    public static void printPromptForPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printPurchasedDetails(List<Lotto> Lottos) {
        int purchasedLottoAmount = Lottos.size();
        System.out.println("\n"+ purchasedLottoAmount +"개를 구매했습니다.");
        for (Lotto lotto : Lottos) {
            System.out.println(lotto);
        }


    }

    public static void printPromptForWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
    }

    public static void printPromptForBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
    }

    public static void printWinningStatistics(List<Integer> rewards, List<Integer> counts, double earningRate) {
        System.out.println("\n당첨 통계\n---");
        System.out.println("3개 일치 (" + formatCurrency(rewards.get(0)) + "원) - " + counts.get(0) + "개");
        System.out.println("4개 일치 (" + formatCurrency(rewards.get(1)) + "원) - " + counts.get(1) + "개");
        System.out.println("5개 일치 (" + formatCurrency(rewards.get(2)) + "원) - " + counts.get(2) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (" + formatCurrency(rewards.get(3)) + "원) - " + counts.get(3) + "개");
        System.out.println("6개 일치 (" + formatCurrency(rewards.get(4)) + "원) - " + counts.get(4) + "개");
        System.out.println("총 수익률은 " + earningRate + "%입니다.");
    }

    private static String formatCurrency(int amount) {
        return String.format("%,d", amount);
    }

}
