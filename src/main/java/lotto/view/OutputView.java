package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoMatch;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {
    private static final StringBuilder stringBuilder = new StringBuilder();
    private static final String AMOUNT_FORMAT = "###,###";

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
        stringBuilder.append("\n").append("당첨 통계").append("\n").append("---").append("\n");
    }

    public static void displayWinningStatistics(final List<LottoMatch> lottoResultCount) {
        Map<LottoMatch, Integer> lottoMatchMap = new HashMap<>();
        DecimalFormat df = new DecimalFormat(AMOUNT_FORMAT);

        for (LottoMatch lottoMatch : lottoResultCount) {
            lottoMatchMap.put(lottoMatch, lottoMatchMap.getOrDefault(lottoMatch, 0) + 1);
        }

        for (LottoMatch lottoMatch : LottoMatch.values()) {
            if (lottoMatch.equals(LottoMatch.NOTHING)) {
                continue;
            }
            stringBuilder.append(lottoMatch.getMatching()).append("개 일치");
            if (lottoMatch.equals(LottoMatch.FIVE_AND_BONUS)) {
                stringBuilder.append(", 보너스 볼 일치");
            }
            stringBuilder.append(" (").append(df.format(lottoMatch.getAmount())).append("원) - ")
                    .append(getMatchCount(lottoMatchMap.get(lottoMatch))).append("개").append("\n");
        }
    }

    public static void displayYield(final double yield) {
        stringBuilder.append("총 수익률은 ").append(String.format("%.1f", yield)).append("%").append("입니다.");
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
