package lotto.domain.lotto;

import lotto.service.dto.LottoResultDto;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private List<Lotto> lottoTickets = new ArrayList<>();

    public void insertLotto(Lotto lotto) {
        lottoTickets.add(lotto);
    }

    public List<List<Integer>> getLottoTickets() {
        return lottoTickets.stream().map(Lotto::getNumbers).toList();
    }

    public List<LottoResultDto> matchAll(List<Integer> winningNumbers, int bonusNumber) {
        return lottoTickets.stream()
                .map(lotto -> lotto.matchWithWinningNumbersAndBonusNumber(winningNumbers, bonusNumber))
                .toList();
    }
}
