package lotto;
import java.util.List;

public class LottoView {
    public static void signalInputLottoPrice() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printLottoAmount(int lottoPrice) {
        System.out.println("\n"+ lottoPrice / 1000 + "개를 구매했습니다.");
    }

    public static void printGeneratedLottos(List<Lotto> boughtLottos) {
        for (Lotto lotto : boughtLottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void signalInputWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
    }

    public static void signalInputBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
    }

    public static void printRankInfo(int[] lottoRank) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + lottoRank[4] + "개");
        System.out.println("4개 일치 (50,000원) - " + lottoRank[3] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + lottoRank[2] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + lottoRank[1] + "개");
        System.out.println("6개 일치 (20,000,000,000원) - " + lottoRank[0] + "개");
    }

    public static void printProfitRate(double lottoProfit) {
        System.out.println("총 수익률은 " + lottoProfit + "%입니다.");
    }
}
