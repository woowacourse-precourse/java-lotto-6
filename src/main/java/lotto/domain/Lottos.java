package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.service.PrizeChecker;
import lotto.utils.LottoConstant;
import lotto.utils.LottoConstantValue;
import lotto.utils.Prize;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int getLottoCount() {
        return lottos.size();
    }

    public Map<Prize, Integer> getLottosResult(PrizeChecker prizeChecker) {
        Map<Prize, Integer> lottosResult = new HashMap<>();
        for (Lotto lotto : lottos) {
            Prize prize = prizeChecker.calculatePrize(lotto);
            if (prize.equals(Prize.NO_PRIZE)) {
                continue;
            }
            Integer prizeCount = lottosResult.getOrDefault(prize, LottoConstantValue.DEFAULT_COUNT.get());
            prizeCount++;
            lottosResult.put(prize, prizeCount);
        }
        return lottosResult;
    }

    @Override
    public String toString() {
        return lottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining(LottoConstant.NEW_LINE.get()));
    }
}
