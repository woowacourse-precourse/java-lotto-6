package lotto.domain.statistics;

import lotto.domain.dto.LottoRankDto;

public enum LottoRank {

    FIRST_PLACE(6, 2000000000),
    SECOND_PLACE(5, 30000000),
    THIRD_PLACE(5, 1500000),
    FOURTH_PLACE(4, 50000),
    FIFTH_PLACE(3, 5000);

    private final int standard;
    private final int prize;

    LottoRank(int standard, int prize) {
        this.standard = standard;
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }

    public int getStandard() {
        return standard;
    }

    public static LottoRankDto mapToDto() {
        return new LottoRankDto(
                FIFTH_PLACE.getStandard(), FIFTH_PLACE.getPrize(),
                FOURTH_PLACE.getStandard(), FOURTH_PLACE.getPrize(),
                THIRD_PLACE.getStandard(), THIRD_PLACE.getPrize(),
                SECOND_PLACE.getStandard(), SECOND_PLACE.getPrize(),
                FIRST_PLACE.getStandard(), FIRST_PLACE.getPrize()
        );
    }
}
