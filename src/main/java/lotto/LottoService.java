package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.sql.Array;
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
			if (!isSortedInAscendingOrder(numbers)) {
				Collections.sort(numbers);
			}
			Lotto lotto = new Lotto(numbers);
			lottos.add(lotto);
		}
		return lottos;
	}

	private boolean isSortedInAscendingOrder(List<Integer> numbers) {
		for (int i = 1; i < numbers.size(); i++) {
			if (numbers.get(i - 1) > numbers.get(i)) {
				return false;
			}
		}
		return true;
	}

	public List<Integer> checkNumbers(String inputNumbers) throws IllegalArgumentException {
		List<Integer> userNumbers = new ArrayList<>();

		String[] numbers = inputNumbers.split(",");
		validator.isThisSizeSix(numbers);

		for (int i = 0; i < numbers.length; i++) {
			String check = numbers[i].strip();
			validator.isComposedOfNumbers(check);
			validator.isInRange(check);
			userNumbers.add(Integer.parseInt(check));
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
		int[] checkRank = new int[countOfLotto];
		for (Lotto computerLotto : computerLottos) {
			List<Integer> computerLottoNumber = computerLotto.getNumbers();
			int win = compareNumber(computerLottoNumber, userNumbers);
			int bonusWin = compareBonusNumber(computerLottoNumber, bonusNumber);
			checkRank[findRank(win, bonusWin)]++;
		}

		List<Integer> winningResult = new ArrayList<>();
		for (int i = 0; i < countOfLotto; i++) {
			winningResult.add(checkRank[i]);
		}
		return winningResult;
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

	private int findRank(int win, int bonusWin) {
		if (win == 6) {
			return 1;
		}
		if (win == 5 && bonusWin == 1) {
			return 2;
		}
		if (win == 5) {
			return 3;
		}
		if (win + bonusWin == 4) {
			return 4;
		}
		if (win + bonusWin == 3) {
			return 5;
		}
		return 0;
	}

	public String getProfitRate(long numberOfLottoTickets, long profit) {
		long money = numberOfLottoTickets * 1000;
		double profitRate = (double) profit / money;
		return String.format("%.1f", profitRate);
	}
}
