package lotto.converter;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.Ranking;

public class MessageConverter {
    private static final String START_TAG = "[";
    private static final String SEPARATOR = ", ";
    private static final String END_TAG = "]";
    private static final String NEXT_LINE = "\n";

    private static final String UNIT = "개\n";

    public static String writePurchasedLottos(List<Lotto> lottos) {
        StringBuilder sb = new StringBuilder();
        lottos.forEach(lotto -> sb.append(lotto.writePurchasedLotto()).append(NEXT_LINE));
        return sb.toString();
    }

    public static String writePurchasedLotto(List<Integer> numbers) {
        StringBuilder sb = new StringBuilder();
        sb.append(START_TAG);
        List<String> nums_str = numbers.stream().map(String::valueOf).toList();
        sb.append(String.join(SEPARATOR, nums_str));
        sb.append(END_TAG);
        return sb.toString();
    }

    public static String writeResultsOfRanks(List<Ranking> rankings) {
        StringBuilder sb = new StringBuilder();
        for (Ranking ranking : Ranking.values()) {
            if (ranking == Ranking.FAIL) {
                continue;
            }
            int cnt = (int) rankings.stream().filter(r -> r == ranking).count();
            sb.append(ranking.getCondition()).append(cnt).append(UNIT);
        }
        return sb.toString();
    }
}
