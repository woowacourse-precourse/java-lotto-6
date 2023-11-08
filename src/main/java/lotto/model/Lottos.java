package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.enums.LottoStatus;
import lotto.service.LottoDto;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos() {
        lottos = new ArrayList<>();
    }

    public void addLotto(List<Integer> numbers) {
        lottos.add(new Lotto(numbers));
    }

    public List<LottoDto> toDto() {
        return lottos.stream()
                .map(LottoDto::of)
                .toList();
    }

    public List<LottoStatus> compareLotto(WinningNumbers winningNumbers) {
        List<LottoStatus> lottoStatuses = new ArrayList<>();

        for (Lotto lotto : lottos) {
            int correctCount = lotto.matchNumbers(winningNumbers.getWinningLotto());
            boolean hasBonusNumber = lotto.contains(winningNumbers.getBonusNumber());
            lottoStatuses.add(LottoStatus.getLottoStatus(correctCount, hasBonusNumber));
        }
        
        return lottoStatuses;
    }

}
