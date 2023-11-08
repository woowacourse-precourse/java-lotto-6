package lotto.app.collaboration;

import java.util.List;
import java.util.Map;
import lotto.app.collaboration.dto.PlayerLotto;
import lotto.app.collaboration.enums.Prize;

public class PrizeLottos {

    private final Map<Prize, List<PlayerLotto>> lottosWithPrize;

    public PrizeLottos(final Map<Prize, List<PlayerLotto>> lottosWithPrize) {
        this.lottosWithPrize = Map.copyOf(lottosWithPrize);
    }

    public String getMessageCountOfPrizeLottosBy(final Prize prize) {
        List<PlayerLotto> lottos = lottosWithPrize.getOrDefault(prize, List.of());
        return prize.makeCountOfPrizeLottos(lottos.size());
    }

    public long calculateTotalPrizeMoney() {
        long totalPrizeMoney = 0L;
        for (Prize prize : Prize.prizeByRank()) {
            List<PlayerLotto> lottos = lottosWithPrize.getOrDefault(prize, List.of());
            totalPrizeMoney += prize.money() * lottos.size();
        }
        return totalPrizeMoney;
    }

}
