package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class LottoService {
	Validator validator = new Validator();
	final int lottoRangeStart = 1;
	final int lottoRangeEnd = 45;
	final int countOfLotto = 6;

	public long getNumberOfLottoTickets(String cost) throws IllegalArgumentException {
		validator.isComposedOfNumbers(cost);

		long money = Long.parseLong(cost);
		validator.isMultiplesOfThousand(money);

		return money / 1000;
	}

	public List<Lotto> issueLottos(long numberOfLottoTickets) throws IllegalArgumentException {
		List<Lotto> lottos = new ArrayList<>();
		for (int i = 1; i <= numberOfLottoTickets; i++) {
			List<Integer> numbers =
					Randoms.pickUniqueNumbersInRange(lottoRangeStart, lottoRangeEnd, countOfLotto);
			Lotto lotto = new Lotto(numbers);
			lottos.add(lotto);
		}
		return lottos;
	}

	public List<Integer> checkNumbers(String inputNumbers) throws IllegalArgumentException{
		String[] numbers = inputNumbers.split(",");
		validator.isThisSizeSix(numbers);
		return null;
	}
}
