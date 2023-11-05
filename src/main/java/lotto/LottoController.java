package lotto;

import java.util.ArrayList;
import java.util.List;

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
		winNumbers = this.setWinNumbers(numbers);
		bonusNumber = this.getBonusNumber();
		System.out.println(winNumbers);
		System.out.println(bonusNumber);
	}

	public int getBonusNumber() {
		int bonusNumber = LottoView.getBonusNumber();
		return  bonusNumber;
	}

	public void matchNumbers() {
		List<Integer> matchList = new ArrayList<>();
		for (List<Integer> innerList : createdLottos) {
			int count = 0;
			for (int i = 0; i < winNumbers.size() - 1; i++) {
				int num = winNumbers.get(i);
				if (innerList.contains(num)) {
					count++;
				}
			}
			matchList.add(count);
		}
		for (int count : matchList) {
			System.out.println(count);
		}
//		return matchList;
	}

	// matchNumber -> 사용자가 구매한 로또와 사용자가 입력한 당첨번호가 일치하는지 확인
	// bonusNumber -> 사용자가 입력한 보너스 번호가 일치하는지 확인
//			return Ranking.valueOf(matchNumber, bonusNumber)
	public void processGame() {
		int count = this.getCount();
		this.createRandomLotto(count);
		this.getWinNumbers();
		this.matchNumbers();
	}
}