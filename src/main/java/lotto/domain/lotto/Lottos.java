package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lotto.domain.ball.Ball;
import lotto.domain.lotto.strategy.CreateStrategy;
import lotto.domain.rank.Rank;
import lotto.dto.LottosDto;

public class Lottos {

    private final List<Lotto> lottos = new ArrayList<>();

    public Lottos(final int count, final CreateStrategy createStrategy) {
        createLottos(count, createStrategy);
    }

    private void createLottos(final int count, final CreateStrategy createStrategy) {
        for (int i = 0; i < count; i++) {
            final Lotto lotto = createStrategy.createLotto();
            lottos.add(lotto);
        }
    }

    public List<LottosDto> getLottosStatus() {
        return lottos.stream()
                .map(this::toDto)
                .toList();
    }

    private LottosDto toDto(final Lotto lotto) {
        return new LottosDto(lotto.parseString());
    }

    public List<Rank> calculateRanks(final Lotto winningLotto, final Ball bonus) {
        return lottos.stream()
                .map(lotto -> lotto.calculateRank(winningLotto, bonus))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
    }

    public int getSize() {
        return lottos.size();
    }
}
