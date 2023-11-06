package lotto.domain;

import java.util.List;
import lotto.Dto.LottoResultDto;

public class LottoComputer {

    private final Lotto luckyLotto;
    private final Integer bonusNumber;

    public LottoComputer(Lotto luckyLotto, Integer bonusNumber) {
        this.luckyLotto = luckyLotto;
        this.bonusNumber = bonusNumber;
    }

    int profit() {
        // calculate profit
        return 0;
    }

    public LottoResultDto simulate() {
        return new LottoResultDto(List.of(1, 2, 3, 4, 5, 6));
        // simulate
    }
}