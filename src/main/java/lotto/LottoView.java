package lotto;

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

    public static void msgLottoNum(String lottoNum) {
        System.out.println(lottoNum);
    }

    public static void msgEarningRate(double EarningRate) {
        System.out.printf("총 수익률은 %f입니다.%n", EarningRate);
    }

    public static void msgWinningStatistics() {
        System.out.printf("당첨 통계%n---%n");
    }
}
