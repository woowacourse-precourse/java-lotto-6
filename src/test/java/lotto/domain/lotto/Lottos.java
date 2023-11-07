package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.List;
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

    public List<LottoDto> getLottoStatus() {
        return lottos.stream()
                .map(this::convertToDto)
                .toList();
    }

    private LottoDto convertToDto(final Lotto lotto) {
        return new LottoDto(lotto.getStringNumbers());
    }
}
