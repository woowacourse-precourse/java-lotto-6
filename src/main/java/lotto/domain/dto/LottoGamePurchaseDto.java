package lotto.domain.dto;

import java.util.List;

public class LottoGamePurchaseDto {

    private final List<List<Integer>> purchaseLottos;

    public LottoGamePurchaseDto(List<List<Integer>> purchaseLottos) {
        this.purchaseLottos = purchaseLottos;
    }

    public List<List<Integer>> getPurchaseLottos() {
        return purchaseLottos;
    }
}
