package lotto;

import java.util.ArrayList;
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

	private void createRandomLotto(int count) { // 사용자가 입력한 갯수에 따라 로또를 생성한다.
		for (int i = 0; i < count; i++) {
			List<Integer> randomNumbers = pickUniqueNumbersInRange(1, 45, 6);
			randomLotto = new Lotto(randomNumbers);
			LottoView.printLottos(randomLotto.getNumbers());
			createdLottos.add(randomNumbers); // 생성된 로또를 저장한다.
		}
	}

	public List<List<Integer>> setCreatedLottos(List<Integer> numbers) {
		createdLottos.add(numbers);
		return createdLottos;
	}

	private void setWinNumbers() { // 사용자가 입력한 당첨번호와 보너스번호를 할당한다
		String[] numbers = LottoView.getWinNumbers(); // 사용자로부터 당첨 번호를 입력받아 할당한다.
		winNumbers = stringArrayToList(numbers);
	}

	private List<Integer> stringArrayToList(String[] input) { // 사용자가 입력한 당첨번호를 정수형 리스트로 변환한다.
		List<Integer> numbers = new ArrayList<>();

		try {
			for (String str : input) {
				int num = Integer.parseInt(str.trim());
				numbers.add(num);
			}
		} catch (NumberFormatException e) {
			LottoView.getWinNumbers();
		}
		Lotto winLotto = new Lotto(numbers);
		return winLotto.getNumbers();
	}

	private void setBonusNumber() {
		int number = LottoView.getBonusNumber();
		bonusNumber = number;
	}

	public Map<Ranking, Integer> setResult() {
		Map<Ranking, Integer> result = new LinkedHashMap<>();

		for (Ranking rank : Ranking.values()) {
			result.put(rank, 0);
		}
		return result;
	}

	public Map<Ranking, Integer> matchRank(List<List<Integer>> lottos, List<Integer> numbers) {
		Map<Ranking, Integer> result = setResult();
		for (List<Integer> lotto : lottos) {
			int count = 0;
			for (int num : numbers) {
				if (lotto.contains(num)) {
					count++;
				}
			}
			Ranking rank = Ranking.valueOf(count, containBonusNumber(lotto)); // 일치하는 숫자 수와 보너스 숫자 매칭 여부에 따른 등수 반환
			result.put(rank, result.get(rank) + 1); // 결과에 값 넣어주기
		}
		return result;
	}

	private void printResult() {
		Map<Ranking, Integer> result = matchRank(createdLottos, winNumbers);
		LottoView.printSumOfwinResult();
		for (int i = Ranking.values().length - 1; i >= 0; i--) { // result에 저장되어있는 값 출력
			Ranking.values()[i].printMessage(result.get(Ranking.values()[i]));
		}
	}

	private void marginRate() {
		double marginRate = 0;
		double costOfPayment = createdLottos.size() * 1000;
		int winPrice = 0;
		Map<Ranking, Integer> result = matchRank(createdLottos, winNumbers);
		for (Ranking rank : result.keySet()) {
			winPrice += rank.getPrice() * result.get(rank); // 당첨금액을 다 합한다.
		}
		// 수익률(%) = 당첨금 / 구매비용 * 100
		marginRate = (winPrice / costOfPayment) * 100;
		LottoView.printMargin(marginRate);
	}

	public boolean containBonusNumber(List<Integer> numbers) {
		return numbers.contains(bonusNumber);
	}

	public void processGame() {
		int count = getCount();
		this.createRandomLotto(count);
		this.setWinNumbers();
		this.setBonusNumber();
		this.printResult();
		this.marginRate();
	}
}