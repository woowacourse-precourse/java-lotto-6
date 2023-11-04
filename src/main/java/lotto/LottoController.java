package lotto;

import java.util.ArrayList;
import java.util.List;
import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class LottoController {
	private Lotto randomLotto;
	private LottoView LottoView;
	private List<List<Integer>> randomLottos;

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
			LottoView.printLottos(randomNumbers);
			randomLottos.add(randomNumbers);
		}
	}

	public void processGame() {
		int count = this.getCount();
		this.createRandomLotto(count);
	}
}