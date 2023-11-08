package lotto.view;

import static lotto.domain.enums.LottoConstants.LOTTO_MISS_COUNT;

import java.util.Arrays;
import lotto.domain.Lottos;
import lotto.domain.PlayerAmount;
import lotto.domain.Profit;
import lotto.domain.RankResult;
import lotto.domain.enums.Rank;

public class OutputView {

    public void printCreatedLotto(PlayerAmount playerAmount, Lottos lottos) {
        System.out.println(String.format("%d개를 구매했습니다.", playerAmount.getLottoCount()));
        System.out.println(lottos.toString());
    }

    public void printLottoRank(RankResult rankResult) {
        Arrays.stream(Rank.values())
                .filter(rank -> rank.getMatchCount() != LOTTO_MISS_COUNT)
                .forEach(rank ->
                        System.out.println(String.format(rank.getMessage(), rankResult.getRankCount(rank)))
                );
    }

    public void printLottoProfitRate(Profit profit) {
        System.out.println(String.format("총 수익률은 %.1f%%입니다.", profit.getRate()));
    }
}
