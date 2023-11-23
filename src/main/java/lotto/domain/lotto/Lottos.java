package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.lotto.strategy.CreateStrategy;
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
}
