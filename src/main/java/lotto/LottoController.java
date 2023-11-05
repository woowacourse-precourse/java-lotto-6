package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class LottoController {
	private Lotto randomLotto;
	private LottoView LottoView;
	private List<List<Integer>> randomLottos;
	private List<Integer> winLotto;

	public LottoController() {
		randomLottos = new ArrayList<>();
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
			randomLottos.add(randomNumbers);
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
		String[] winNumbers = LottoView.getWinLotto();
		winLotto = this.setWinNumbers(winNumbers);
		this.addBonusNumber();
//		System.out.println(winLotto);
	}

	public void addBonusNumber() {
		int bonusNumber = LottoView.getBonusNumber();
		winLotto.add(bonusNumber);
	}

	public void processGame() {
		int count = this.getCount();
		this.createRandomLotto(count);
		this.getWinNumbers();
	}
}