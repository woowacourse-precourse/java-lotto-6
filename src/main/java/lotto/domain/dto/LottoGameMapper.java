package lotto.domain.dto;

import java.util.List;
import lotto.domain.LottoGame;

public class LottoGameMapper {

    private LottoGameMapper() {

    }

    public static LottoGamePurchaseDto toPurchaseDtofrom(final List<List<Integer>> purchaseLottos) {
        return new LottoGamePurchaseDto(purchaseLottos);
    }

    public static LottoGameWinningResultDto toWinningResultDtofrom(final List<Integer> rankings,
                                                                   final double rateOfReturn) {
        return new LottoGameWinningResultDto(rankings, rateOfReturn);
    }
}
