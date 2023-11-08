package lotto.dto;

import lotto.utils.Rank;
import lotto.view.LottoResultConstants;

public record ResultResponse(Rank rank, int count) {

    @Override
    public String toString() {
        if (rank == Rank.SECOND) {
            return getFormatResult(LottoResultConstants.SECOND_RESULT_FORMAT);
        }

        return getFormatResult(LottoResultConstants.BASIC_RESULT_FORMAT);
    }

    private String getFormatResult(LottoResultConstants lottoResultConstants) {
        return String.format(
            lottoResultConstants.getText(),
            rank.getMatchCount(),
            rank.getPrize(),
            count
        );
    }
}
