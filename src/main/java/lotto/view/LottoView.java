package lotto.view;

import lotto.domain.LottoGame;

public class LottoView {
    public static void msgLottoPrice() {
        System.out.println("구입 금액을 입력해 주세요.");
    }

    public static void msgLottoWinningNum() {
        System.out.println("당첨 번호를 입력해 주세요");
    }

    public static void msgBonusNum() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void msgLottoCount(int count) {
        System.out.printf("%n%d개를 구매했습니다.%n", count);
    }

    public static void msgLottoNum(LottoGame lottogame) {
        System.out.println(lottogame);
        System.out.println();
    }

    public static void msgWinningStatistics() {
        System.out.printf("당첨 통계%n---%n");
    }

    public static void msgSuccess(String message, int numberOfMatch) {
        System.out.println(message + numberOfMatch + "개");
    }

    public static void msgRevenueRate(double EarningRate) {
        System.out.println("총 수익률은 " + String.format("%.1f", EarningRate) + "%입니다.");
    }
}
