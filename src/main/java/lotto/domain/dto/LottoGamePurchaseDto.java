package lotto.domain.dto;

import java.util.List;
import lotto.domain.LottoGame;

public class LottoGamePurchaseDto {

    private final List<List<Integer>> purchaseLottos;

    private LottoGamePurchaseDto(List<List<Integer>> purchaseLottos) {
        this.purchaseLottos = purchaseLottos;
    }

    public static LottoGamePurchaseDto from(final LottoGame lottoGame) {
        return new LottoGamePurchaseDto(
                lottoGame.getPurchaseLottos());
    }

    public List<List<Integer>> getPurchaseLottos() {
        return purchaseLottos;
    }
}
