package lotto.dto;

import lotto.domain.LottoMatch;

public class LottoMatchCountDto {
    private int nonPlaceCount;
    private int fifthPlaceCount;
    private int fourthPlaceCount;
    private int thirdPlaceCount;
    private int secondPlaceCount;
    private int firstPlaceCount;

    public LottoMatchCountDto() {
        this.nonPlaceCount = 0;
        this.fifthPlaceCount = 0;
        this.fourthPlaceCount = 0;
        this.thirdPlaceCount = 0;
        this.secondPlaceCount = 0;
        this.firstPlaceCount = 0;
    }

    public LottoMatchCountDto(
            final int nonPlaceCount,
            final int fifthPlaceCount,
            final int fourthPlaceCount,
            final int thirdPlaceCount,
            final int secondPlaceCount,
            final int firstPlaceCount
    ) {
        this.nonPlaceCount = nonPlaceCount;
        this.fifthPlaceCount = fifthPlaceCount;
        this.fourthPlaceCount = fourthPlaceCount;
        this.thirdPlaceCount = thirdPlaceCount;
        this.secondPlaceCount = secondPlaceCount;
        this.firstPlaceCount = firstPlaceCount;
    }

    public void countLottoMatch(final LottoMatch lottoMatch) {
        switch (lottoMatch) {
            case NON_PLACE -> nonPlaceCount++;
            case FIFTH_PLACE -> fifthPlaceCount++;
            case FOURTH_PLACE -> fourthPlaceCount++;
            case THIRD_PLACE -> thirdPlaceCount++;
            case SECOND_PLACE -> secondPlaceCount++;
            case FIRST_PLACE -> firstPlaceCount++;
        }
    }

    public int getLottoMatchCount(final LottoMatch lottoMatch) {
        return switch (lottoMatch) {
            case NON_PLACE -> nonPlaceCount;
            case FIFTH_PLACE -> fifthPlaceCount;
            case FOURTH_PLACE -> fourthPlaceCount;
            case THIRD_PLACE -> thirdPlaceCount;
            case SECOND_PLACE -> secondPlaceCount;
            case FIRST_PLACE -> firstPlaceCount;
        };
    }

    @Override
    public boolean equals(Object obj) {
        LottoMatchCountDto other = (LottoMatchCountDto) obj;
        return this.nonPlaceCount == other.nonPlaceCount &&
                this.fifthPlaceCount == other.fifthPlaceCount &&
                this.fourthPlaceCount == other.fourthPlaceCount &&
                this.thirdPlaceCount == other.thirdPlaceCount &&
                this.secondPlaceCount == other.secondPlaceCount &&
                this.firstPlaceCount == other.firstPlaceCount;
    }
}
