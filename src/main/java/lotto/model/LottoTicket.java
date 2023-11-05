package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.enums.LottoStatus;
import lotto.service.LottoDto;

public class LottoTicket {
    private final List<Lotto> lottos;

    public LottoTicket() {
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
        for (int i = 0; i < lottos.size(); i++) {
            int correctCount = lottos.get(i).compare(winningNumbers.getWinningLotto());
            boolean hasBonusNumber = lottos.get(i).contains(winningNumbers.getBonusNumber());
            lottoStatuses.add(LottoStatus.getLottoStatus(correctCount, hasBonusNumber));
        }
        return lottoStatuses;
    }

}
