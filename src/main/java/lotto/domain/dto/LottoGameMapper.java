package lotto.domain.dto;

import lotto.domain.LottoGame;

public class LottoGameMapper {

    private LottoGameMapper() {

    }

    public static LottoGamePurchaseDto toPurchaseDtofrom(final LottoGame lottoGame) {
        return LottoGamePurchaseDto.from(lottoGame);
    }

    public static LottoGameWinningResultDto toWinningResultDtofrom(final LottoGame lottoGame) {
        return LottoGameWinningResultDto.from(lottoGame);
    }
}
