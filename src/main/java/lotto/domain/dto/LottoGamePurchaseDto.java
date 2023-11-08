package lotto.domain.dto;

import java.util.List;
import lotto.domain.LottoGame;

public class LottoGamePurchaseDto {

    private final int purchaseAmount;
    private final List<List<Integer>> purchaseLottos;

    private LottoGamePurchaseDto(int purchaseAmount, List<List<Integer>> purchaseLottos) {
        this.purchaseAmount = purchaseAmount;
        this.purchaseLottos = purchaseLottos;
    }

    public static LottoGamePurchaseDto from(final LottoGame lottoGame) {
        return new LottoGamePurchaseDto(
                lottoGame.getPurchaseAmount(),
                lottoGame.getPurchaseLottos());
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public List<List<Integer>> getPurchaseLottos() {
        return purchaseLottos;
    }
}
