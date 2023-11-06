package lotto.message;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import lotto.Lotto;

public enum OutputMessage {
    ASK_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    ASK_WINNING_LOTTO_NUMBER("당첨 번호를 입력해 주세요."),
    ASK_BONUS_NUMBER("보너스 번호를 입력해 주세요.");
    private String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public void printMessage() {
        System.out.println(message);
    }

    public static void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.forEach(System.out::println);
    }

    public static void printWinningStatistics(HashMap<LottoResult, BigDecimal> result, float profitRate) {
        StringBuilder sb = new StringBuilder();
        sb.append("당첨 통계\n").append("---------\n");
        sb.append(LottoResult.FIFTH.getMessage()).append(" - ").append(result.get(LottoResult.FIFTH)).append("개\n");
        sb.append(LottoResult.FOURTH.getMessage()).append(" - ").append(result.get(LottoResult.FOURTH)).append("개\n");
        sb.append(LottoResult.THIRD.getMessage()).append(" - ").append(result.get(LottoResult.THIRD)).append("개\n");
        sb.append(LottoResult.SECOND.getMessage()).append(" - ").append(result.get(LottoResult.SECOND)).append("개\n");
        sb.append(LottoResult.FIRST.getMessage()).append(" - ").append(result.get(LottoResult.FIRST)).append("개\n");
        sb.append(String.format("총 수익률은 %.1f입니다.", profitRate));
        System.out.println(sb);
    }
}
