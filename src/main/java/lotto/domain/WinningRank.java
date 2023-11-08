package lotto.domain;

import java.util.List;

public enum WinningRank {

    FIRST(2_000_000_000, 6),
    SECOND(30_000_000, 5, true),
    THIRD(1_500_000, 5),
    FOURTH(50_000, 4),
    FIFTH(5_000, 3),
    NOTHING(0, 0);

    private static final List<WinningRank> RANKS_ORDERED_BY_PRICE
            = List.of(FIRST, SECOND, THIRD, FOURTH, FIFTH, NOTHING);
    private static final int MIN_COUNT_OF_CORRECT = 0;
    private static final int MAX_COUNT_OF_CORRECT = 6;

    private final long price;
    private final int countOfCorrect;
    private final boolean isBonusCorrect;

    WinningRank(long price, int countOfCorrect, boolean isBonusCorrect) {
        this.price = price;
        this.countOfCorrect = countOfCorrect;
        this.isBonusCorrect = isBonusCorrect;
    }

    WinningRank(long price, int countOfCorrect) {
        this(price, countOfCorrect, false);
    }

    public static WinningRank from(int countOfCorrect, boolean isBonusCorrect) {
        validate(countOfCorrect);
        return findRank(countOfCorrect, isBonusCorrect);
    }

    private static void validate(int countOfCorrect) {
        if (isOutOfRange(countOfCorrect)) {
            throw createNotExistRankException();
        }
    }

    private static boolean isOutOfRange(int countOfCorrect) {
        return countOfCorrect < MIN_COUNT_OF_CORRECT || countOfCorrect > MAX_COUNT_OF_CORRECT;
    }

    private static WinningRank findRank(int countOfCorrect, boolean isBonusCorrect) {
        return RANKS_ORDERED_BY_PRICE.stream()
                .filter(rank -> rank.isReached(countOfCorrect, isBonusCorrect))
                .findFirst().orElseThrow(WinningRank::createNotExistRankException);
    }

    private boolean isReached(int countOfCorrect, boolean isBonusCorrect) {
        return isOverOrEquals(countOfCorrect) && isSatisfyBonus(isBonusCorrect);
    }

    private boolean isOverOrEquals(int countOfCorrect) {
        return countOfCorrect >= this.countOfCorrect;
    }

    private boolean isSatisfyBonus(boolean isBonusCorrect) {
        return !(this.isBonusCorrect && !isBonusCorrect);
    }

    private static IllegalArgumentException createNotExistRankException() {
        String exceptionMessage = "맞춘 숫자의 수는 %d 이상 %d 이하이어야 합니다"
                .formatted(MIN_COUNT_OF_CORRECT, MAX_COUNT_OF_CORRECT);
        return new IllegalArgumentException(exceptionMessage);
    }

    public int getCountOfCorrect() {
        return countOfCorrect;
    }

    public boolean isBonusCorrect() {
        return isBonusCorrect;
    }

    public long getPrice() {
        return price;
    }
}
