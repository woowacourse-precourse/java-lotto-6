package lotto.dto;

import java.util.List;

public class LottoNumberDTO {
    List<Integer> lotto;

    public LottoNumberDTO(List<Integer> lotto) {
        this.lotto = lotto;
    }

    public List<Integer> getLotto() {
        return lotto;
    }
}
