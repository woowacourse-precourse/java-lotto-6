package lotto.model;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoBuyer {
    private final List<Lotto> lottos;
    private final Map<LottoGrade, Integer> result = new EnumMap<>(LottoGrade.class);

    public LottoBuyer(final int amount, final LottoManager lottoManager) {
        lottos = lottoManager.createLottoTickets(amount);
        initializeResult();
    }

    private void initializeResult() {
        for (final LottoGrade lottoGrade : LottoGrade.values()) {
            result.put(lottoGrade, 0);
        }
    }
}
