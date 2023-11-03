package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.constant.Prize;

public class LottoCalculator {
    private final int SPECIAL_MATCH = 7;
    private final Lotto winningNumber;
    private final int bonusNumber;
    private final Map<Prize, Integer> result = new HashMap<>();

    public LottoCalculator(WinningNumbers winningNumbers) {
        this.winningNumber = winningNumbers.getWinningNumber();
        this.bonusNumber = winningNumbers.getBonusNumber();
    }

    public void makePrizeResult(List<Lotto> lottoTickets) {
        initResult();
        for (Lotto oneTicket : lottoTickets) {
            int matchCount = countMatchNumbers(oneTicket);
            Prize prize = Prize.getByMatch(matchCount);

            if (prize != Prize.NONE) {
                result.put(prize, result.get(prize) + 1);
            }
            if (matchCount == SPECIAL_MATCH) {
                result.put(Prize.SECOND, result.get(Prize.SECOND) + 1);
            }
        }
    }

    public void initResult() {
        result.put(Prize.FIRST, 0);
        result.put(Prize.SECOND, 0);
        result.put(Prize.THIRD, 0);
        result.put(Prize.FOURTH, 0);
        result.put(Prize.FIFTH, 0);
        result.put(Prize.NONE, 0);
    }

    public int countMatchNumbers(Lotto lotto) {
        int matchCount = 0;
        for (Integer number : lotto.getNumbers()) {
            if (winningNumber.getNumbers().contains(number)) {
                matchCount++;
            }
            if (matchCount == 5 && isContainBonusNumber(lotto)) {
                return SPECIAL_MATCH;
            }
        }
        return matchCount;
    }

    private boolean isContainBonusNumber(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }
}
