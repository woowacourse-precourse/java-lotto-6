package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.wrapper.LottoNumber;
import lotto.utils.LottoConstant;
import lotto.utils.LottoConstantValue;
import lotto.utils.Prize;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Map<Prize, Integer> getPrizeCounts(Lotto winningLotto, LottoNumber bonusNumber) {
        Map<Prize, Integer> prizeCounts = new HashMap<>();
        lottos.stream()
                .map(lotto -> lotto.getRank(winningLotto, bonusNumber))
                .forEach(prize -> {
                    Integer prizeCount = prizeCounts.getOrDefault(prize, LottoConstantValue.DEFAULT_COUNT.get());
                    prizeCounts.put(prize, prizeCount);
                });
        return prizeCounts;
    }

    @Override
    public String toString() {
        return lottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining(LottoConstant.NEW_LINE.get()));
    }
}
