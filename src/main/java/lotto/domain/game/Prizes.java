package lotto.domain.game;

import java.util.List;

public record Prizes(
        List<Prize> prizes
) {
    public Prizes(final List<Prize> prizes) {
        this.prizes = makeUnmodifiable(prizes);
    }

    private List<Prize> makeUnmodifiable(final List<Prize> prizes) {
        return List.copyOf(prizes);
    }

    public Long getSumOfMoney() {
        return prizes.stream()
                .mapToLong(Prize::getPrizeMoney)
                .sum();
    }
}
