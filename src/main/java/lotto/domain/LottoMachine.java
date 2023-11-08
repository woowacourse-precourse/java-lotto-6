package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.dto.RequestLotto;
import lotto.dto.RequestLottos;
import lotto.util.NumberGenerator;


public class LottoMachine {

	private final NumberGenerator numberGenerator;
	private final Cash cash;


	private LottoMachine(final NumberGenerator numberGenerator, final Cash cash) {
		this.numberGenerator = numberGenerator;
		this.cash = cash;
	}

	public static LottoMachine create(final NumberGenerator numberGenerator, final Cash cash) {
		return new LottoMachine(numberGenerator, cash);
	}

	public RequestLottos purchaseLottos() {
		final RequestLottos requestLottos = generateLottosByCash();
		return requestLottos;
	}

	private RequestLottos generateLottosByCash() {
		List<RequestLotto> generatedNumbersDummy = new ArrayList<>();
		while (cash.isAfford()) {
			cash.spendOneUnit();
			final RequestLotto requestLotto = generateLotto();
			generatedNumbersDummy.add(requestLotto);
		}

		return RequestLottos.of(generatedNumbersDummy);
	}

	private RequestLotto generateLotto() {
		final List<Integer> numbers = numberGenerator.generateNumbers();
		final RequestLotto requestLotto = RequestLotto.of(numbers);
		return requestLotto;
	}


}
