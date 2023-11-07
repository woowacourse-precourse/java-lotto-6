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

	public List<Integer> checkNumbers(String inputNumbers) throws IllegalArgumentException {
		List<Integer> userNumbers = new ArrayList<>();

		String[] numbers = inputNumbers.split(",");
		validator.isThisSizeSix(numbers);

		for (int i = 0; i < numbers.length; i++) {
			validator.isComposedOfNumbers(numbers[i]);
			validator.isInRange(numbers[i]);
			userNumbers.add(Integer.parseInt(numbers[i]));
		}
		validator.existDuplicateNumber(userNumbers);
		return userNumbers;
	}

	public int checkBonusNumber(List<Integer> userNumbers, String inputBonusNumber)
			throws IllegalArgumentException {
		validator.isComposedOfNumbers(inputBonusNumber);
		validator.isInRange(inputBonusNumber);
		validator.containNumber(userNumbers, inputBonusNumber);
		return Integer.parseInt(inputBonusNumber);
	}

	public List<Integer> getWinningResult(
			List<Lotto> computerLottos,
			List<Integer> userNumbers,
			int bonusNumber) {
		List<Integer> winningResult = new ArrayList<>();
		for (Lotto computerLotto : computerLottos) {
			List<Integer> computerLottoNumber = computerLotto.getNumbers();
			int win = compareNumber(computerLottoNumber, userNumbers);
			int bonusWin = compareBonusNumber(computerLottoNumber, bonusNumber);
		}
	}

	private int compareNumber(
			List<Integer> computerLottoNumber,
			List<Integer> userNumbers) {
		int win = 0;
		for (int i = 0; i < countOfLotto; i++) {
			if (computerLottoNumber.contains(userNumbers.get(i))) {
				win++;
			}
		}
		return win;
	}

	private int compareBonusNumber(List<Integer> computerLottoNumber, int bonusNumber) {
		if (computerLottoNumber.contains(bonusNumber)) {
			return 1;
		}
		return 0;
	}
}
