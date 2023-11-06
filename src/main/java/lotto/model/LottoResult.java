package lotto.model;

import java.util.List;

public class LottoResult {
    private final Lotto winningLottoTicket;
    private final int bonusNumber;

    public LottoResult(final List<Integer> numbers, final int inputBonusNumber, final LottoManager lottoManager) {
        winningLottoTicket = lottoManager.createWinningLottoTicket(numbers);
        bonusNumber = lottoManager.createBonusNumber(winningLottoTicket, inputBonusNumber);
    }
}
