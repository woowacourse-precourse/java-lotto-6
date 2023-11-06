package lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Lotto {

	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validate(numbers);
		this.numbers = numbers;
	}

	private void validate(List<Integer> numbers) {
		if (numbers.size() != 6) {
			throw new IllegalArgumentException();
		}
	}

	public static void Create(int lottocount) {

		List<List<Integer>> lottos = new ArrayList<>();

		for (int i = 0; i < lottocount; i++) {

			List<Integer> lottonumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

			lottos.add(lottonumbers);
		}

		for (int i = 0; i < lottocount; i++) {

			System.out.println(lottos.get(i));

		}
	}

	public static void printLotto(int lottocount) {

		System.out.println(lottocount + "개를 구매했습니다.");

	}
}
