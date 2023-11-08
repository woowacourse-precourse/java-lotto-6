package lotto.dto;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;

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
