package lotto.dto;

import java.util.List;

public class LottoPurchaseResultDto {

    private List<List<Integer>> lottos;

    public LottoPurchaseResultDto(List<List<Integer>> lottos) {
        this.lottos = lottos;
    }

    public List<List<Integer>> getLottos() {
        return this.lottos;
    }
}
