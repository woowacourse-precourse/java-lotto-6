package lotto.domain;

import java.util.List;

public class LottoManager {

    private final List<Integer> winningLottoNumbers;

    public LottoManager(List<Integer> winningLottoNumbers) {
        this.winningLottoNumbers = winningLottoNumbers;
    }
}
