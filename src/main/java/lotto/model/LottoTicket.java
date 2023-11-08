package lotto.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class LottoTicket {

    private static final int MINIMUM = 1;
    private static final String LOTTO_COUNT_EXCEPTION_MESSAGE = "[ERROR] 로또의 개수는 1개 이상이어야 합니다.";

    private final List<Lotto> lottos;

    private LottoTicket(final List<Lotto> lottos) {
        validateLottosNumber(lottos);
        this.lottos = lottos;
    }

    public static LottoTicket create(final Money purchasedLotto) {
        List<Lotto> lottos = IntStream.range(0, purchasedLotto.getNumberOfLotto())
                .mapToObj(LottoIndex -> RandomNumberGenerator.generate())
                .map(Lotto::new)
                .toList();
        return new LottoTicket(lottos);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    private void validateLottosNumber(List<Lotto> lottos) {
        if (lottos.size() < MINIMUM) {
            throw new IllegalArgumentException(LOTTO_COUNT_EXCEPTION_MESSAGE);
        }
    }
}
