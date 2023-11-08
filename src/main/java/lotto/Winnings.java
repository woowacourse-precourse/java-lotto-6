package lotto;

import java.util.Arrays;

public enum Winnings {
    FIRST_PLACE("2,000,000,000", 6, 0) {
        @Override
        public boolean collect(int collectWinningCount, int collectBonusCount) {
            return collectWinningCount == getCountCollectedWinningNumber();
        }
    },
    SECOND_PLACE("30,000,000", 5, 1) {
        @Override
        public boolean collect(int collectWinningCount, int collectBonusCount) {
            return collectWinningCount == getCountCollectedWinningNumber() &&
                    collectBonusCount == getCountCollectedBonusNumber();
        }

        @Override
        public String info() {
            return String.format("%d개 일치, 보너스 볼 일치 (%s원)", getCountCollectedWinningNumber(), getWinningsString());
        }
    },
    THIRD_PLACE("1,500,000", 5, 0) {
        @Override
        public boolean collect(int collectWinningCount, int collectBonusCount) {
            return collectWinningCount == getCountCollectedWinningNumber() &&
                    collectBonusCount == getCountCollectedBonusNumber();
        }
    },
    FOURTH_PLACE("50,000", 4, 0) {
        @Override
        public boolean collect(int collectWinningCount, int collectBonusCount) {
            return collectWinningCount == getCountCollectedWinningNumber();
        }
    },
    FIFTH_PLACE("5,000", 3, 0) {
        @Override
        public boolean collect(int collectWinningCount, int collectBonusCount) {
            return collectWinningCount == getCountCollectedWinningNumber();
        }
    },
    NONE("0", 0, 0) {
        @Override
        public boolean collect(int collectWinningCount, int collectBonusCount) {
            return false;
        }
    };

    private final String winnings;
    private final int countCollectedWinningNumber;
    private final int countCollectedBonusNumber;

    Winnings(String winnings, int countCollectedWinningNumber, int countCollectedBonusNumber) {
        this.winnings = winnings;
        this.countCollectedWinningNumber = countCollectedWinningNumber;
        this.countCollectedBonusNumber = countCollectedBonusNumber;
    }

    public abstract boolean collect(int collectWinningCount, int collectBonusCount);

    public static Winnings check(int collectWinningNumber, int collectBonusNumber) {
        return Arrays.stream(Winnings.values())
                .filter(winnings -> winnings.collect(collectWinningNumber, collectBonusNumber))
                .findAny()
                .orElse(NONE);
    }

    public long getWinningsNumber() {
        return Integer.parseInt(winnings.replace(",", ""));
    }

    public String getWinningsString() {
        return winnings;
    }

    public int getCountCollectedWinningNumber() {
        return countCollectedWinningNumber;
    }

    public int getCountCollectedBonusNumber() {
        return countCollectedBonusNumber;
    }

    public Winnings getSelf() {
        return this;
    }

    public String info() {
        return String.format("%d개 일치 (%s원)", getCountCollectedWinningNumber(), getWinningsString());
    }
}
