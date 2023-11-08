package lotto.constants;

import java.util.Arrays;

public enum Prize {
    NO_LUCK(0, 0, "저런!"),
    FIFTH(3, 5_000, "3개 일치 (5,000원)"),
    FOURTH(4, 50_000, "4개 일치 (50,000원)"),
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원)") {
        @Override
        protected boolean check(final int match, final boolean hasBonusNumber) {
            return super.check(match, hasBonusNumber) && !hasBonusNumber;
        }
    },
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)") {
        @Override
        protected boolean check(final int match, final boolean hasBonusNumber) {
            return super.check(match, hasBonusNumber) && hasBonusNumber;
        }
    },
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원)");

    private final int matches;
    private final int winnings;
    private final String message;

    Prize(int matches, int winnings, String message) {
        this.matches = matches;
        this.winnings = winnings;
        this.message = message;
    }

    public static Prize of(final int matches, final boolean hasBonusNumber) {
        return Arrays.stream(values())
                .filter(prize -> prize.check(matches, hasBonusNumber))
                .findAny()
                .orElse(NO_LUCK);
    }

    protected boolean check(int matches, boolean hasBonusNumber) {
        return this.matches == matches;
    }

    public int getWinnings() {
        return winnings;
    }

    public String getMessage() {
        return message;
    }
}
