package lotto.message;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import lotto.data.Lotto;
import lotto.data.LottoResult;

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
        StringBuilder sb = new StringBuilder();
        lottos.forEach(lotto -> sb.append(lotto).append("\n"));
        System.out.println(sb);
    }

    public static void printWinningStatistics(LottoResult lottoResult) {
        StringBuilder sb = new StringBuilder();
        HashMap<LottoPrize, BigDecimal> result = lottoResult.getLottoRank();
        System.out.println(result);
        sb.append("당첨 통계\n").append("---------\n");
        sb.append(LottoPrize.FIFTH.getMessage()).append(" - ").append(result.get(LottoPrize.FIFTH)).append("개\n");
        sb.append(LottoPrize.FOURTH.getMessage()).append(" - ").append(result.get(LottoPrize.FOURTH)).append("개\n");
        sb.append(LottoPrize.THIRD.getMessage()).append(" - ").append(result.get(LottoPrize.THIRD)).append("개\n");
        sb.append(LottoPrize.SECOND.getMessage()).append(" - ").append(result.get(LottoPrize.SECOND)).append("개\n");
        sb.append(LottoPrize.FIRST.getMessage()).append(" - ").append(result.get(LottoPrize.FIRST)).append("개\n");
        sb.append(String.format("총 수익률은 %.1f%%입니다.", lottoResult.getProfitPercent()));
        System.out.println(sb);
    }
}
