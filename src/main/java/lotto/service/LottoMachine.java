package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.WinningNumbers;
import lotto.domain.WinningResult;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    public List<Lotto> generateLottoTickets(int purchaseAmount) {
        int lottoCount = purchaseAmount / 1000;
        List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoTickets.add(new Lotto(lottoNumbers));
        }
        return lottoTickets;
    }

    public WinningResult calculateWinningResult(List<Lotto> lottoTickets, List<Integer> winningNumbers, int bonusNumber) {
        WinningNumbers winningNumbersWithBonus = new WinningNumbers(winningNumbers, bonusNumber);
        return WinningResult.calculate(lottoTickets, winningNumbersWithBonus);
    }
}