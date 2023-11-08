package lotto.domain.dto;

import java.util.List;

public class WinningResultDto {

    private final List<Integer> rankings;
    private double rateOfReturn;

    public WinningResultDto(final List<Integer> rankings, final double rateOfReturn) {
        this.rankings = rankings;
        this.rateOfReturn = rateOfReturn;
    }
}
