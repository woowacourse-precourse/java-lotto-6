package lotto.domain;

import java.util.stream.Stream;

public enum LottoResultStatus {
    NOTHING(0, ""),
    THREE(3, "3개 일치 (5,000원) - "),
    FOUR(4, "4개 일치 (50,000원) - "),
    FIVE(5, "5개 일치 (1,500,000원) - "),
    FIVE_BONUS(7, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    SIX(6, "6개 일치 (2,000,000,000원) - ");

    private int matchCount;
    private String description;

    LottoResultStatus(int matchCount, String description) {
        this.matchCount = matchCount;
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
}
