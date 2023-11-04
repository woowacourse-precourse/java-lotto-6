package lotto.domain;

import static lotto.config.LottoConfig.LOTTO_PRICE;
import static lotto.config.LottoConfig.LOTTO_SIZE;
import static lotto.config.LottoConfig.MAX_LOTTO_NUMBER;
import static lotto.config.LottoConfig.MIN_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

	public LottoPlayer purchaseLotto(PurchaseAmount purchaseAmount) {
		int lottoTicketCount = purchaseAmount.getAmount() / LOTTO_PRICE.getValue();

		List<Lotto> lottoList = IntStream.range(0, lottoTicketCount)
			.mapToObj(i -> generateRandomLotto())
			.collect(Collectors.toList());

		return new LottoPlayer(lottoList);
	}

	private Lotto generateRandomLotto() {
		List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER.getValue(), MAX_LOTTO_NUMBER.getValue(), LOTTO_SIZE.getValue());

		Collections.sort(numbers);

		return new Lotto(numbers);
	}
}