package lotto;

import java.util.ArrayList;
import java.util.List;
import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class LottoController {
	private List<List<Integer>> createdNumbers;
	private LottoView LottoView;

	public LottoController() {
		createdNumbers = new ArrayList<>();
		LottoView = new LottoView();
	}

	public void setCount() {
		int userInput = LottoView.getMoney();
		System.out.print("setcount" + userInput);
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