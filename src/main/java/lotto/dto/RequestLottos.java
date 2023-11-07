package lotto.dto;

import lotto.domain.Lotto;

import java.util.List;
import java.util.stream.Collectors;

public record RequestLottos(
        List<RequestLotto> lottoDummy
) {
    public static RequestLottos of(final List<RequestLotto> lottoDummy) {
        return new RequestLottos(lottoDummy);
    }

    public List<Lotto> createLottoDummy() {
        return lottoDummy.stream()
                .map(requestLotto -> Lotto.create(requestLotto.numbers()))
                .collect(Collectors.toList());
    }
}
