package lotto.dto;

import java.util.List;

public class PurchaseLottoDto {

    private List<List<Integer>> lottos;

    public PurchaseLottoDto(List<List<Integer>> lottos) {
        this.lottos = lottos;
    }

    public List<List<Integer>> getLottos() {
        return this.lottos;
    }
}
