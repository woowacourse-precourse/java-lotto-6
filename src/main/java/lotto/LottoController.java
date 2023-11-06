package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class LottoController {
	private Lotto randomLotto;
	private LottoView LottoView;
	private List<List<Integer>> createdLottos;
	private List<Integer> winNumbers;
	private int bonusNumber;

	public LottoController() {
		createdLottos = new ArrayList<>();
		LottoView = new LottoView();
	}

	public int getCount() {
		return LottoView.getMoney();
	}

	public void createRandomLotto(int count) { // 사용자가 입력한 갯수에 따라 로또를 생성한다.
		for (int i = 0; i < count; i++) {
			List<Integer> randomNumbers = pickUniqueNumbersInRange(1, 45, 6);
			randomLotto = new Lotto(randomNumbers);
			LottoView.printLottos(randomLotto.getNumbers());
			createdLottos.add(randomNumbers);
		}
	}

	public List<Integer> setWinNumbers(String[] input) {
		List<Integer> winNumbers = new ArrayList<>();

		for (String str : input) {
			try {
				int num = Integer.parseInt(str.trim());
				winNumbers.add(num);
			} catch (NumberFormatException e) {
				LottoView.getWinLotto();
			}

		}
		return winNumbers;
	}

	public void getWinNumbers() {
		String[] numbers = LottoView.getWinLotto();
		winNumbers = setWinNumbers(numbers);
		bonusNumber = getBonusNumber();
//		System.out.println(winNumbers);
//		System.out.println(bonusNumber);
	}

	public int getBonusNumber() {
		int bonusNumber = LottoView.getBonusNumber();
		return bonusNumber;
	}

	public Map<Ranking, Integer> setResult() {
		Map<Ranking, Integer> result = new LinkedHashMap<>();

		for (Ranking rank : Ranking.values()) {
			result.put(rank, 0);
		}
		return result;
	}

	public Map<Ranking, Integer> matchRank() {
		Map<Ranking, Integer> result = setResult();
		for (List<Integer> innerList : createdLottos) {
			int count = 0;
			for (int num : winNumbers) {
				if (innerList.contains(num)) {
					count++;
				}
			}
			Ranking rank = Ranking.valueOf(count, containBonusNumber(innerList)); // 일치하는 숫자 수와 보너스 숫자 매칭 여부에 따른 등 반환
			result.put(rank, result.get(rank) + 1); // 결과에 값 넣어주기
		}
		return result;
	}

	public void printResult() {
		Map<Ranking, Integer> result = matchRank();
		System.out.printf("%n당첨 통계%n");
		System.out.println("---");
		for (int i = Ranking.values().length - 1; i >= 0; i--) {
			Ranking.values()[i].printMessage(result.get(Ranking.values()[i]));
		}
	}

	public boolean containBonusNumber(List<Integer> numbers) {
		return numbers.contains(bonusNumber);
	}

	public void processGame() {
		int count = getCount();
		this.createRandomLotto(count);
		this.getWinNumbers();
		this.matchRank();
		this.printResult();
	}
}