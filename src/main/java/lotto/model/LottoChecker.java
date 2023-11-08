package lotto.model;

import java.util.List;

public class LottoChecker {
    private List<Lotto> lottos;
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public LottoChecker(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        this.lottos = lottos;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }
}
