package lotto.views;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;

public class UserOutput {
    public static void askPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void askWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void askBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void printPurchaseLottoInfo(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.print("[");
            System.out.print(getLottoNumberInfo(lotto.getNumbers()));
            System.out.print("]");
            System.out.println();
        }
    }

    public static void printNumberOfLottoPurchases(List<Lotto> lottos) {
        int numberOfLottoPurchases = lottos.size();
        System.out.println(numberOfLottoPurchases + "개를 구매했습니다.");
    }

    public static void printWinningStatistics(Map<LottoRank, Integer> winningResult, Double totalReturnRate) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + winningResult.getOrDefault(LottoRank.FIFTH_PLACE, 0) + "개");
        System.out.println("4개 일치 (50,000원) - " + winningResult.getOrDefault(LottoRank.FOURTH_PLACE, 0) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + winningResult.getOrDefault(LottoRank.THIRD_PLACE, 0) + "개");
        System.out.println(
                "5개 일치, 보너스 볼 일치 (30,000,000원) - " + winningResult.getOrDefault(LottoRank.SECOND_PLACE, 0) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + winningResult.getOrDefault(LottoRank.FIRST_PLACE, 0) + "개");
        System.out.print("총 수익률은 " + String.format("%.1f", totalReturnRate) + "%입니다."); // 소수점 둘째 자리에서 반올림
    }

    private static String getLottoNumberInfo(List<Integer> numbers) {
        List<String> lottoNumbers = numbers.stream()
                .map(Object::toString)
                .toList();

        return String.join(", ", lottoNumbers);
    }
}
