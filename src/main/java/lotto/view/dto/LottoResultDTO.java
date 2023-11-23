package lotto.view.dto;

import lotto.domain.lotto.entity.LottoResult;

public class LottoResultDTO {
    private static final String MATCH_COUNT_FORMAT = "%d개 일치";
    private static final String BONUS_BALL_MESSAGE = ", 보너스 볼 일치";
    private static final String PRICE_MESSAGE = " (%s원)";
    private final String descriptionFormat;
    private final int prize;
    private final int matchingCount;

    private LottoResultDTO(String descriptionFormat, int prize, int matchingCount) {
        this.descriptionFormat = descriptionFormat;
        this.prize = prize;
        this.matchingCount = matchingCount;
    }

    public static LottoResultDTO from(LottoResult result) {
        if (result.equals(LottoResult.SECOND)) {
            return new LottoResultDTO(MATCH_COUNT_FORMAT + BONUS_BALL_MESSAGE + PRICE_MESSAGE,
                    result.getPrize().intValue(),
                    result.getSameCount());
        }

        return new LottoResultDTO(MATCH_COUNT_FORMAT + PRICE_MESSAGE,
                result.getPrize().intValue(),
                result.getSameCount());
    }

    public String getDescriptionFormat() {
        return descriptionFormat;
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchingCount() {
        return matchingCount;
    }
}
