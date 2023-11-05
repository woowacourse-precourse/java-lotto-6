package lotto.domain;

import java.util.LinkedHashMap;
import java.util.List;

public class WinnerCalculator {
    private static final int INITIAL_MATCH_COUNT = 0;
    private static final int INCREMENT = 1;
    private final LottoFactory lottoFactory;
    private final Lotto winningLotto;
    private final BonusNumber bonusNumber;
    private final LinkedHashMap<LottoRank, Integer> winnerCount;

    public WinnerCalculator(LottoFactory lottoFactory, Lotto winningLotto, BonusNumber bonusNumber) {
        this.lottoFactory = lottoFactory;
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
        this.winnerCount = initializeWinnerCount();
    }

    private LinkedHashMap<LottoRank, Integer> initializeWinnerCount() {
        LinkedHashMap<LottoRank, Integer> map = new LinkedHashMap<>();
        for (LottoRank rank : LottoRank.values()) {
            map.put(rank, INITIAL_MATCH_COUNT);
        }
        return map;
    }

    public LinkedHashMap<LottoRank, Integer> calculate() {
        List<Lotto> tickets = lottoFactory.getTickets();

        for (Lotto ticket : tickets) {
            int matchCount = getMatchCount(ticket.getNumbers(), winningLotto.getNumbers());
            boolean matchBonus = isMatchBonus(ticket);

            updateWinnerCount(matchCount, matchBonus);
        }
        return winnerCount;
    }

    private boolean isMatchBonus(Lotto ticket) {
        return ticket.getNumbers().contains(bonusNumber.getBonusNumber());
    }

    private void updateWinnerCount(int matchCount, boolean matchBonus) {
        LottoRank rank = LottoRank.valueOf(matchCount, matchBonus);
        winnerCount.put(rank, winnerCount.get(rank) + INCREMENT);
    }

    private int getMatchCount(List<Integer> ticketNumbers, List<Integer> winningNumbers) {
        return (int) ticketNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public LinkedHashMap<LottoRank, Integer> getWinnerCount() {
        return this.winnerCount;
    }
}
