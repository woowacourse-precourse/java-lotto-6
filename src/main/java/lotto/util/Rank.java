package lotto.util;

import java.util.Arrays;
import java.util.List;
import lotto.model.LottoTicket;
import lotto.model.LottoWinningNumbers;

public enum Rank {
    BLANK(0, false, 0),
    FIFTH(3, false, 5_000),
    FOURTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(5, true, 30_000_000),
    FIRST(6, false, 2_000_000_000);

    private final int matchCount;
    private final boolean matchBonus;
    private final int prize;

    Rank(int matchCount, boolean matchBonus, int prize) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prize = prize;
    }

    public static Rank calculate(LottoTicket ticket, LottoWinningNumbers lottoWinningNumbers) {
        final int matchCount = getMatchCount(ticket, lottoWinningNumbers);
        boolean matchBonus = false;
        if (matchCount == 5) {
            matchBonus = getMatchBonus(ticket, lottoWinningNumbers);
        }
        return getRank(matchCount, matchBonus);
    }

    private static int getMatchCount(LottoTicket ticket, LottoWinningNumbers lottoWinningNumbers) {
        List<Integer> winningNumbers = lottoWinningNumbers.getNumbers();
        return (int) ticket.getNumbers().stream()
                .filter(winningNumbers::contains)
                .count();
    }

    private static boolean getMatchBonus(LottoTicket ticket, LottoWinningNumbers lottoWinningNumbers) {
        return ticket.contains(lottoWinningNumbers.getBonus());
    }

    private static Rank getRank(int matchCount, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount)
                .filter(rank -> rank.matchBonus == matchBonus)
                .findAny()
                .orElse(BLANK);
    }

    public int getPrize() {
        return prize;
    }

    public static int countRank(List<Rank> ranks, Rank targetRank) {
        return (int) ranks.stream()
                .filter(rank -> rank == targetRank)
                .count();
    }

    @Override
    public String toString() {
        StringBuilder outputMessage = new StringBuilder();
        outputMessage.append(String.format("%d개 일치", matchCount));
        if (matchBonus) {
            outputMessage.append(", 보너스 볼 일치");
        }
        outputMessage.append(String.format(" (%,d원)", prize));
        return outputMessage.toString();
    }
}