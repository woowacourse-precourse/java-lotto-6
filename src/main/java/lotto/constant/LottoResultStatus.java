package lotto.constant;

import java.util.stream.Stream;

public enum LottoResultStatus {
    NOTHING(0, 0, ""),
    THREE(3, 5000, "3개 일치 (5,000원) - "),
    FOUR(4, 50000, "4개 일치 (50,000원) - "),
    FIVE(5, 150000, "5개 일치 (1,500,000원) - "),
    FIVE_BONUS(7, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    SIX(6, 2000000000, "6개 일치 (2,000,000,000원) - ");

    private int matchCount;
    private long winnings;
    private String description;

    LottoResultStatus(int matchCount, long winning, String description) {
        this.matchCount = matchCount;
        this.winnings = winning;
        this.description = description;
    }

    public static LottoResultStatus from(int matchCount) {
        return Stream.of(values())
                .filter(lottoResultStatus -> lottoResultStatus.matchCount == matchCount)
                .findAny()
                .orElse(NOTHING);
    }

    public String getDescription() {
        return description;
    }

    public long getWinnings() {
        return winnings;
    }
}
