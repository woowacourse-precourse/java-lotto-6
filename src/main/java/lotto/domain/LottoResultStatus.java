package lotto.domain;

import java.util.stream.Stream;

public enum LottoResultStatus {
    NOTHING(0),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    FIVE_BONUS(7);

    private int matchCount;

    LottoResultStatus(int matchCount) {
        this.matchCount = matchCount;
    }

    public static LottoResultStatus from(int matchCount) {
        return Stream.of(values())
                .filter(lottoResultStatus -> lottoResultStatus.matchCount == matchCount)
                .findAny()
                .orElse(NOTHING);
    }
}
