package lotto.domain.lotto;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LottoTicket {
    List<Lotto> lottos;

    private LottoTicket(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static LottoTicket of(List<Lotto> lottos) {
        validate(lottos);
        return new LottoTicket(lottos);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    private static void validate(List<Lotto> lottos) {
        validateNull(lottos);
        validateEmpty(lottos);
    }

    private static void validateNull(List<Lotto> lottos) {
        if (Objects.isNull(lottos)) {
            throw new IllegalArgumentException("[ERROR] 로또 목록이 비었습니다");
        }
    }

    private static void validateEmpty(List<Lotto> lottos) {
        if (lottos.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 로또 목록이 비었습니다");
        }
    }
}
