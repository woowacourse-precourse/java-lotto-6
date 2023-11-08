package lotto.domain.dto;

import lotto.domain.LottoGame;

public class LottoGameMapper {

    private LottoGameMapper() {

    }

    public static LottoGamePurchaseDto from(final LottoGame lottoGame) {
        return LottoGamePurchaseDto.from(lottoGame);
    }
}
