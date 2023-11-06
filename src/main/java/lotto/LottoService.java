package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
	Validator validator = new Validator();

	public long getNumberOfLottoTickets(String cost) throws IllegalArgumentException {
		validator.isComposedOfNumbers(cost);

		long money = Long.parseLong(cost);
		validator.isMultiplesOfThousand(money);

		return money / 1000;
	}

	public List<Lotto> issueLottos(long numberOfLottoTickets) throws IllegalArgumentException {
		List<Lotto> lottos = new ArrayList<>();
		for (int i = 1; i <= numberOfLottoTickets; i++) {
			List<Integer> numbers = issueLotto();
			Lotto lotto = new Lotto(numbers);
		}
		return null;
	}

	private List<Integer> issueLotto() {
		return null;
	}
}
