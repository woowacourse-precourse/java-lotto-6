package lotto.domain;

import lotto.domain.collections.LotteryResultCollection;
import lotto.domain.collections.UserTicketCollection;

import java.util.ArrayList;
import java.util.List;

public class LuckyTicket {

    private final Lotto lotto;
    private final int bonusNumber;

    private LuckyTicket(
        final Lotto lotto,
        final int bonusNumber
    ) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public static LuckyTicket of(
        final Lotto lotto,
        final int bonusNumber
    ) {
        return new LuckyTicket(lotto, bonusNumber);
    }

    public LotteryResultCollection matchWith(final UserTicketCollection userTicketCollection) {
        List<Lotto> userTickets = userTicketCollection.getTickets();
        List<LotteryResult> results = new ArrayList<>();

        for (Lotto userTicket : userTickets) {
            int numberCount = lotto.matchCount(userTicket);
            int bonusCount = lotto.matchCount(bonusNumber);
            results.add(makeLotteryResult(numberCount, bonusCount));
        }

        return LotteryResultCollection.of(results);
    }

    private LotteryResult makeLotteryResult(int matchCount, int bonusCount) {
        return LotteryResult.getWinnerMoneyOf(matchCount, bonusCount);
    }

    private int matchCountWithStream(
        final List<Integer> luckyNumbers,
        final List<Integer> userNumbers
    ) {
        Long count = userNumbers.stream()
            .filter(luckyNumbers::contains)
            .count();
        return count.intValue();
    }

}
