package lotto.model;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.constant.LottoPrize;
import lotto.dto.LottoInfoResponse;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public LottoInfoResponse getLottoInfoResponse() {
        return new LottoInfoResponse(
            lottos.size(),
            lottos.stream().map(Lotto::getNumbers).toList()
        );
    }

    public LottoResult getLottoResult(WinningNumberAndBonusNumber winningNumberAndBonusNumber) {
        Map<LottoPrize, Integer> prizesCount = new EnumMap<>(LottoPrize.class);
        for (LottoPrize prize : LottoPrize.values()) {
            prizesCount.put(prize, 0); // 초기값을 0으로 설정합니다.
        }
        for (Lotto lotto : lottos) {
            final LottoPrize lottoPrize = lotto.findPrize(winningNumberAndBonusNumber);
            prizesCount.put(lottoPrize, prizesCount.get(lottoPrize) + 1);
        }
        return new LottoResult(prizesCount);
    }
}
