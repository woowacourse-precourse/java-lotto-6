package lotto.model;

public enum PrizeCategory {
    THREE_MATCH("3개 일치", 3, 5000) {
        int calculatePrize(int ticketQuantity) {
            return ticketQuantity * BASIC_PRIZE;
        }
    },
    FOUR_MATCH("4개 일치", 4, 50000) {
        int calculatePrize(int ticketQuantity) {
            return ticketQuantity * BASIC_PRIZE;
        }
    },
    FIVE_MATCH_NO_BONUS("5개 일치", 5, 1500000) {
        int calculatePrize(int ticketQuantity) {
            return ticketQuantity * BASIC_PRIZE;
        }
    },
    FIVE_MATCH_WITH_BONUS("5개 일치, 보너스 볼 일치", 5, 30000000) {
        int calculatePrize(int ticketQuantity) {
            return ticketQuantity * BASIC_PRIZE;
        }
    },
    SIX_MATCH("6개 일치", 6, 2000000000) {
        int calculatePrize(int ticketQuantity) {
            return ticketQuantity * BASIC_PRIZE;
        }
    };

    protected final String NAME;
    protected final int MATCH_COUNT;
    protected final int BASIC_PRIZE;

    PrizeCategory(String name, int matchCount, int basicPrize) {
        this.NAME = name;
        this.MATCH_COUNT = matchCount;
        this.BASIC_PRIZE = basicPrize;
    }

    public String getNAME() {
        return NAME;
    }

    public int getMatchCount() {
        return MATCH_COUNT;
    }

    public int getBasicPrize() {
        return BASIC_PRIZE;
    }

    abstract int calculatePrize(int ticketQuantity);
}
