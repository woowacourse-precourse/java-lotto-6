package lotto.domain;

import java.util.List;

public class WinningLotto {
    private final LottoTicket winningTicket;
    private final int bonusNumber;

    public WinningLotto(LottoTicket winningTicket, int bonusNumber) {
        this.winningTicket = winningTicket;
        this.bonusNumber = bonusNumber;
    }

    public LottoRank match(LottoTicket ticket) {
        int matchCount = 0;
        boolean bonusMatch = false;

        List<Integer> winningNumbers = winningTicket.getNumbers();
        List<Integer> ticketNumbers = ticket.getNumbers();

        // 당첨 번호와 비교하여 일치하는 개수 파악
        for (int number : ticketNumbers) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }

        // 보너스 번호 일치 여부 파악
        bonusMatch = ticketNumbers.contains(bonusNumber) && matchCount == 5;

        // LottoRank 결정 로직
        return determineRank(matchCount, bonusMatch);
    }

    private LottoRank determineRank(int matchCount, boolean bonusMatch) {
        if (matchCount == 6) return LottoRank.FIRST;
        if (matchCount == 5 && bonusMatch) return LottoRank.SECOND;
        if (matchCount == 5) return LottoRank.THIRD;
        if (matchCount == 4) return LottoRank.FOURTH;
        if (matchCount == 3) return LottoRank.FIFTH;
        return LottoRank.NONE;
    }
}
