package lotto.domain.lotto.converter;

import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import lotto.domain.Rank;
import lotto.domain.lotto.Lotto;

public class LottoMessageConverter {
    private StringJoiner joiner;

    public String convertLottoNumberMessage(List<Lotto> lottos) {
        StringBuilder lottoNumberMessage = new StringBuilder();
        String lottoAmountCheckMessage = String.format("\n%d개를 구매했습니다.\n", lottos.size());
        lottoNumberMessage.append(lottoAmountCheckMessage);

        for (Lotto lotto : lottos) {
            joiner = new StringJoiner(", ", "[", "]\n");
            for (Integer number : lotto.getNumbers()) {
                joiner.add(number.toString());
            }
            lottoNumberMessage.append(joiner);
        }

        return lottoNumberMessage.toString();
    }

    public String convertLottoResultMessage(Map<Rank, Integer> result, double profitPercentage) {
        StringBuilder resultMessage = new StringBuilder();
        resultMessage.append("\n당첨 통계\n---\n");
        for (Rank rank : Rank.values()) {
            String rankResultMessage = String.format(rank.getWinningMessage(), result.get(rank));
            resultMessage.append(rankResultMessage);
        }
        resultMessage.append(String.format("총 수익률은 %.1f%%입니다.", profitPercentage));

        return resultMessage.toString();
    }
}
