package lotto.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public enum Rank {

    FIFTH(3, 5_000, "3개 일치 (5,000원) - %d개"),
    FOURTH(4, 50_000, "4개 일치 (50,000원) - %d개"),
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원) - %d개"),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원) - %d개");

    private final int count;
    private final int prize;
    private final String message;

    Rank(int count, int prize, String message) {
        this.count = count;
        this.prize = prize;
        this.message = message;
    }

    public static List<Optional<Rank>> check(List<Lotto> randomLotto, WinningLotto winningLotto) {
        return randomLotto.stream()
                .map(lotto -> getRank(winningLotto, lotto))
                .toList();
    }

    private static Optional<Rank> getRank(WinningLotto winningLotto, Lotto lotto) {
        if (isSecond(winningLotto, lotto)) {
            return Optional.of(SECOND);
        }
        if (isThird(winningLotto, lotto)) {
            return Optional.of(THIRD);
        }
        return getElse(winningLotto, lotto);
    }

    private static boolean isSecond(WinningLotto winningLotto, Lotto lotto) {
        return winningLotto.numberOfMatched(lotto) == SECOND.count
                && winningLotto.containsBonusNumber(lotto);
    }

    private static boolean isThird(WinningLotto winningLotto, Lotto lotto) {
        return winningLotto.numberOfMatched(lotto) == THIRD.count
                && !winningLotto.containsBonusNumber(lotto);
    }

    private static Optional<Rank> getElse(WinningLotto winningLotto, Lotto lotto) {
        return Stream.of(Rank.values())
                .filter(rank -> winningLotto.numberOfMatched(lotto) == rank.count)
                .findFirst();
    }

    public BigDecimal multiply(int count) {
        return new BigDecimal(this.prize * count);
    }

    public String getMessage() {
        return message;
    }
}
