package lotto.game;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;

public class Messasge {
    public static final String ERROR = "[ERROR]";
    public static final String REQUEST_PRICE = "구입금액을 입력해 주세요.";
    public static final String PURCHASE_MESSAGE = "개를 구매했습니다.";
    public static final String REQUEST_NUMBERS = "당첨 번호를 입력해 주세요.";
    public static final String REQUEST_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    public static final String RESULT = "당첨 통계\n---";

    public static String getResultMessage(Map<Rank, Integer> result, double profitRate) {
        StringBuilder message = new StringBuilder();

        message.append(String.format("%d개 일치 (%,d원) - %d개", Rank.FIFTH.getCount(), Rank.FIFTH.getReward(),
                result.get(Rank.FIFTH))).append("\n");
        message.append(String.format("%d개 일치 (%,d원) - %d개", Rank.FOURTH.getCount(), Rank.FOURTH.getReward(),
                result.get(Rank.FOURTH))).append("\n");
        message.append(String.format("%d개 일치 (%,d원) - %d개", Rank.THIRD.getCount(), Rank.THIRD.getReward(),
                result.get(Rank.THIRD))).append("\n");
        message.append(String.format("%d개 일치, 보너스 볼 일치 (%,d원) - %d개", Rank.SECOND.getCount(), Rank.SECOND.getReward(),
                result.get(Rank.SECOND))).append("\n");
        message.append(String.format("%d개 일치 (%,d원) - %d개", Rank.FIRST.getCount(), Rank.FIRST.getReward(),
                result.get(Rank.FIRST))).append("\n");
        message.append("총 수익률은 ").append(String.format("%.1f", profitRate)).append("%").append("입니다.");

        return message.toString();
    }

    public static String getLottoListMessage(List<Lotto> lottoList) {
        StringBuilder message = new StringBuilder();

        message.append(lottoList.size()).append(PURCHASE_MESSAGE).append("\n");

        for (Lotto lotto : lottoList) {
            message.append(lotto.toString()).append("\n");
        }

        return message.toString();
    }
}
