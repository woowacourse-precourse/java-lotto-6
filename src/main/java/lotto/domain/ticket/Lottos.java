package lotto.domain.ticket;

import java.util.List;
import lotto.domain.dto.LottoDto;
import lotto.domain.statistics.LottoResult;
import lotto.domain.winningnumbers.WinningNumbers;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<LottoDto> mapToLottoDtos() {
        return lottos.stream()
                .map(lotto -> new LottoDto(lotto.getNumbers()))
                .toList();
    }

    public List<LottoResult> checkLottos(WinningNumbers winningNumbers) {
        return lottos.stream()
                .map(lotto -> lotto.getResult(winningNumbers))
                .toList();
    }
}
