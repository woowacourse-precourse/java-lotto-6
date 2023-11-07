package lotto.dto;

import lotto.domain.Lotto;

import java.util.List;

public record RequestLottos(
        List<Lotto> lottoDummy
) {
    public static RequestLottos of(final List<Lotto> lottoDummy) {
        return new RequestLottos(lottoDummy);
    }
}
