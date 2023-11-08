package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lotto.domain.rank.Rank;
import lotto.dto.LottoDto;
import lotto.utils.generator.RandomNumber;

public class Lottos {

    private final List<Lotto> lottos = new ArrayList<>();

    public Lottos(final int count, final RandomNumber randomNumber) {
        getLottos(count, randomNumber);
    }

    private void getLottos(final int count, final RandomNumber randomNumber) {
        for (int i = 0; i < count; i++) {
            final Lotto lotto = randomNumber.generateLotto();
            lottos.add(lotto);
        }
    }

    public List<Rank> calculateRanks(final Lotto winningLotto, final int bonusNumber) {
        return lottos.stream()
                .map(lotto -> lotto.calculateRank(winningLotto, bonusNumber))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
    }

    public List<LottoDto> getLottoStatus() {
        return lottos.stream()
                .map(this::convertToDto)
                .toList();
    }

    private LottoDto convertToDto(final Lotto lotto) {
        return new LottoDto(lotto.getStringNumbers());
    }

    public int getSize() {
        return lottos.size();
    }
}
