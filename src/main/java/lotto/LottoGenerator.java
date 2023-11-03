package lotto;

import java.util.ArrayList;
import java.util.List;
import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class LottoGenerator {
	private static List<List<Integer>> createdNumbers = new ArrayList<>();

	public LottoGenerator(int count) {
		this.generate(count);
	}

	public void generate(int count) {
		for (int i = 0; i < count; i++) {
			List<Integer> randomNumbers = pickUniqueNumbersInRange(1, 45, 6);
			System.out.println(randomNumbers);
//			createdNumbers.add(this.getNumbers(randomNumbers));
		}
	}

	public List<Integer> getNumbers(List<Integer> numbers) {
		System.out.println(numbers);
		return numbers;
	}

	public List<List<Integer>> getCreatedNumbers() {
		return createdNumbers;
	}
}