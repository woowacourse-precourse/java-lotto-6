package lotto.controller;

import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoTicket;
import lotto.model.WinningNumbers;
import lotto.utils.PrizeType;

import java.util.List;
import java.util.Objects;

public class LottoReader {
    public static List<PrizeType> read(
            WinningNumbers winningNumbers,
            BonusNumber bonusNumber,
            LottoTicket lottoTicket
    ) {
        return lottoTicket.getLottos().stream()
                .map(lotto -> match(winningNumbers, bonusNumber, lotto))
                .filter(Objects::nonNull)
                .toList();
    }

    public static PrizeType match(
            WinningNumbers winningNumbers,
            BonusNumber bonusNumber,
            Lotto lotto
    ) {
        Integer matchedCount = lotto.compare(winningNumbers.getWinningNumbers());
        if (matchedCount.equals(6)) {
            return PrizeType.FIRST_PLACE;
        }

        if (lotto.contains(bonusNumber.getBonusNumber())) {
            matchedCount++;
        }

        return PrizeType.getTypeByCode(mapToPrizeCode(matchedCount));
    }

    private static Integer mapToPrizeCode(Integer value) {
        return 8 - value;
    }
}
