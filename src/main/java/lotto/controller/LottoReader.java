package lotto.controller;

import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoTicket;
import lotto.model.WinningNumbers;

import java.util.List;

public class LottoReader {
    private final WinningNumbers winningNumbers;
    private final BonusNumber bonusNumber;

    public LottoReader(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> read(LottoTicket lottoTicket) {
        return lottoTicket.getLottos().stream()
                .map(this::a)
                .toList();
    }

    Integer a(Lotto lotto) {
        Integer result = lotto.compare(winningNumbers.getWinningNumbers());
        if (result.equals(6)) {
            return 1;
        }
        if (lotto.contains(bonusNumber.getBonusNumber())) {
            result++;
        }
        if (result.equals(6)) {
            return 2;
        }
        if (result.equals(5)) {
            return 3;
        }
        if (result.equals(4)) {
            return 4;
        }
        if (result.equals(3)) {
            return 5;
        }
        return null;
    }


}
