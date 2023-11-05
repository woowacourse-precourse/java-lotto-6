package lotto.system;

public enum LottoRankConst {
    FIRST_PRIZE(1, 6, false, 2000000000),
    SECOND_PRIZE(2, 5, true, 30000000),
    THIRD_PRIZE(3, 5, false, 1500000),
    FOURTH_PRIZE(4, 4, false, 50000),
    FIFTH_PRIZE(5, 3, false, 5000);

    private final int rank;
    private final int matchingNumbers;
    private final boolean hasBonusNumber;
    private final int prize;
    private final String message;

    LottoRankConst(int rank, int matchingNumbers, boolean hasBonusNumber, int prize) {
        this.rank = rank;
        this.matchingNumbers = matchingNumbers;
        this.hasBonusNumber = hasBonusNumber;
        this.prize = prize;
        this.message = creatMessage();
    }

    private String creatMessage() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(matchingNumbers);
        stringBuilder.append("개 일치");
        if (hasBonusNumber) {
            stringBuilder.append(", 보너스 볼 일치");
        }
        stringBuilder.append(String.format(" (%,d)", prize));
        return stringBuilder.toString();
    }

    public String getMessage() {
        return message;
    }
}
