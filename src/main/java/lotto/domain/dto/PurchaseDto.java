package lotto.domain.dto;

import java.util.List;

public class PurchaseDto {

    private final List<List<Integer>> purchaseLottos;

    public PurchaseDto(List<List<Integer>> purchaseLottos) {
        this.purchaseLottos = purchaseLottos;
    }

    public List<List<Integer>> getPurchaseLottos() {
        return purchaseLottos;
    }
}
