package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoService {
	Validator validator = new Validator();
	final int lottoRangeStart = 1;
	final int lottoRangeEnd = 45;
	final int countOfLotto = 6;

	public long getNumberOfLottoTickets(String cost) throws IllegalArgumentException {
		validator.checkComposedOfNumbers(cost);

		long money = Long.parseLong(cost);
		validator.checkMultiplesOfThousand(money);

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

	public Lotto issueUserLotto(String inputNumbers) throws IllegalArgumentException {
		List<Integer> userNumbers = new ArrayList<>();

		String[] numbers = inputNumbers.split(",");
		for (int i = 0; i < numbers.length; i++) {
			String check = numbers[i].strip();
			validator.checkComposedOfNumbers(check);
			validator.checkInRange(Integer.parseInt(check));
			userNumbers.add(Integer.parseInt(check));
		}
		Lotto user = new Lotto(userNumbers);
		return user;
	}

	public int checkBonusNumber(Lotto user, String inputBonusNumber)
			throws IllegalArgumentException {
		List<Integer> userNumbers = user.getNumbers();
		validator.checkComposedOfNumbers(inputBonusNumber);
		int bonusNumber = Integer.parseInt(inputBonusNumber);
		validator.checkInRange(bonusNumber);
		validator.checkContainNumber(userNumbers, bonusNumber);
		return bonusNumber;
	}

	public List<Integer> getWinningResult(List<Lotto> computerLottos, Lotto user, int bonusNumber) {
		List<Integer> userNumbers = user.getNumbers();
		int[] checkRank = new int[countOfLotto];

		for (Lotto computerLotto : computerLottos) {
			List<Integer> computerLottoNumber = computerLotto.getNumbers();
			int win = compareNumber(computerLottoNumber, userNumbers);
			int bonusWin = compareBonusNumber(computerLottoNumber, bonusNumber);
			checkRank[findRank(win, bonusWin)]++;
		}

		return Arrays.stream(checkRank).boxed().collect(Collectors.toList());
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
		double profitRate = ((double) profit / money) * 100;
		return String.format("%.1f", profitRate);
	}
}
