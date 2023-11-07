package lotto.constant;

public enum Rank {
    FIRST(6, false, "6개 일치 (2,000,000,000원) - %d개", 2000000000),
    SECOND(5, true, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개", 30000000),
    THIRD(5, false, "5개 일치 (1,500,000원) - %d개", 1500000),
    FOURTH(4, false, "4개 일치 (50,000원) - %d개", 50000),
    FIFTH(3, false, "3개 일치 (5,000원) - %d개", 5000),
    NONE(0, false, "none", 0);

    int numberOfMatch;
    boolean isMatchBonusNumber;
    String message;
    int amount;


    Rank(int numberOfMatch, boolean isMatch, String message, int amount) {
        this.numberOfMatch = numberOfMatch;
        this.isMatchBonusNumber = isMatch;
        this.message = message;
        this.amount = amount;
    }

    public int getNumberOfMatch() {
        return numberOfMatch;
    }

    public boolean isMatchBonusNumber() {
        return isMatchBonusNumber;
    }

    public String getMessage() {
        return message;
    }

    public int getAmount() {
        return amount;
    }
}
