package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoMatch;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {
    private static final StringBuilder stringBuilder = new StringBuilder();

    public static void displayPurchaseGuide() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void displayLottoCount(final int lottoCount) {
        System.out.println("\n" + lottoCount + "개를 구매했습니다.");
    }

    public static void displayLottoNumbers(final List<Lotto> lottoList) {
        stringBuilder.append(lottoList.stream()
                .map(lotto -> lotto.getNumbers() + "\n")
                .collect(Collectors.joining()));
        System.out.println(stringBuilder);
        stringBuilder.setLength(0);
    }

    public static void displayWinningNumberGuide() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void displayBonusNumberGuide() {
        System.out.println("\n" + "보너스 번호를 입력해 주세요.");
    }

    public static void displayWinningStatisticsGuide() {
        stringBuilder.append("\n")
                .append("당첨 통계")
                .append("\n")
                .append("---")
                .append("\n");
    }

    public static void displayWinningStatistics(final List<LottoMatch> lottoResultCount) {
        Map<LottoMatch, Integer> lottoMatchMap = new HashMap<>();

        for (LottoMatch lottoMatch : lottoResultCount) {
            lottoMatchMap.put(lottoMatch, lottoMatchMap.getOrDefault(lottoMatch, 0) + 1);
        }

        for (LottoMatch lottoMatch : LottoMatch.values()) {
            if (lottoMatch == LottoMatch.NOTHING) {
                continue;
            }
            String MatchingBonusBall = "";
            if (lottoMatch.equals(LottoMatch.FIVE_AND_BONUS)) {
                MatchingBonusBall = ", 보너스 볼 일치";
            }

            stringBuilder.append(String.format("%d개 일치%s(%,d원) - %d개",
                    lottoMatch.getMatching(),
                    MatchingBonusBall,
                    lottoMatch.getAmount(),
                    getMatchCount(lottoMatchMap.get(lottoMatch)))).append("\n");
        }
    }

    public static void displayYield(final double yield) {
        stringBuilder.append(String.format("총 수익률은 %.1f%%입니다.", yield));
        System.out.println(stringBuilder);
        stringBuilder.setLength(0);
    }

    private static int getMatchCount(Integer matching) {
        if (matching == null) {
            return 0;
        }
        return matching;
    }
}
