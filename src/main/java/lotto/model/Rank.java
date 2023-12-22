package lotto.model;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Optional;

public enum Rank {

    FIFTH(3, 5_000, "3개 일치 (5,000원) - %d개"),
    FOURTH(4, 50_000, "4개 일치 (50,000원) - %d개"),
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원) - %d개"),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원) - %d개");

    private final int match;
    private final int prize;
    private final String message;

    Rank(int match, int prize, String message) {
        this.match = match;
        this.prize = prize;
        this.message = message;
    }

    public static Optional<Rank> sort(LottoTicket lottoTicket, WinningLottoTicket winningLottoTicket) {
        int count = winningLottoTicket.checkNumbers(lottoTicket);
        if (count == SECOND.match) {
            return sortSecond(lottoTicket, winningLottoTicket);
        }
        return sortElse(count);
    }

    private static Optional<Rank> sortSecond(LottoTicket lottoTicket, WinningLottoTicket winningLottoTicket) {
        if (winningLottoTicket.containsBonusNumber(lottoTicket)) {
            return Optional.of(SECOND);
        }
        return Optional.of(THIRD);
    }

    private static Optional<Rank> sortElse(int count) {
        return Arrays.stream(Rank.values())
                .filter(rank -> count == rank.match)
                .findFirst();
    }

    public BigDecimal multiply(int count) {
        return new BigDecimal(this.prize * count);
    }

    public String getMessage() {
        return message;
    }
}
