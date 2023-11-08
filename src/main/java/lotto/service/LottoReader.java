package lotto.service;

import lotto.model.Lotto;
import lotto.utils.PrizeType;

import java.util.List;
import java.util.Objects;

public class LottoReader {
    private static final Integer ALL_MATCHED_NUMBER = 6;

    public static List<PrizeType> read(
            List<Integer> winningNumbers,
            Integer bonusNumber,
            List<Lotto> lottos
    ) {
        return lottos.stream()
                .map(lotto -> match(winningNumbers, bonusNumber, lotto))
                .filter(Objects::nonNull)
                .toList();
    }

    public static PrizeType match(
            List<Integer> winningNumbers,
            Integer bonusNumber,
            Lotto lotto
    ) {
        Integer matchedCount = lotto.compare(winningNumbers);
        if (matchedCount.equals(ALL_MATCHED_NUMBER)) {
            matchedCount++;
        }
        if (lotto.contains(bonusNumber)) {
            matchedCount++;
        }
        return PrizeType.getTypeByCode(matchedCount);
    }
}
