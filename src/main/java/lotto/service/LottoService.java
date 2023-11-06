package lotto.service;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.Lotto;
import lotto.domain.UserLotto;
import lotto.dto.requset.WinningBonusNumber;
import lotto.dto.response.LottoCollection;
import lotto.dto.response.LottoNumber;
import lotto.dto.response.WinningResult;

public class LottoService implements Calculation{

	UserLotto userLotto = new UserLotto();

	@Override
	public LottoCollection createLotto(String price) {
		userLotto.setLotto(price);
		LottoCollection lottoCollection = new LottoCollection();
		lottoCollection.setLottoCount(userLotto.getLottoCount());
		for(Lotto lotto : userLotto.getAllLotto()){
			LottoNumber lottoNumber = new LottoNumber(lotto.getNumbers());
			lottoCollection.addLottoCollection(lottoNumber);
		}
		return lottoCollection;
	}

	@Override
	public WinningResult winningCalculation(WinningBonusNumber winningBonusNumber) {
		String winningNumber = winningBonusNumber.getWinningNumber();
		String bonusNumber = winningBonusNumber.getBonusNumber();

		List<Integer> result = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));

		List<Integer> winningNumbers = parseNumbers(winningNumber);
		int bonus = Integer.parseInt(bonusNumber);
		for (Lotto lotto : userLotto.getAllLotto()) {
			List<Integer> userNumbers = lotto.getNumbers();
			int matchCount = 0;

			for (int userNumber : userNumbers) {
				if (winningNumbers.contains(userNumber)) {
					matchCount++;
				}
			}


			// 당첨 카테고리 판별
			if (matchCount == 6) {
				result.set(5, result.get(5) + 1); // 6개 일치 (2,000,000,000원)
			} else if (matchCount == 5 && userNumbers.contains(bonus)) {
				result.set(4, result.get(4) + 1); // 5개 + 보너스 숫자 일치 (30,000,000원)
			} else if (matchCount == 5) {
				result.set(3, result.get(3) + 1); // 5개 일치 (1,500,000원)
			} else if (matchCount == 4) {
				result.set(2, result.get(2) + 1); // 4개 일치 (50,000원)
			} else if (matchCount == 3) {
				result.set(1, result.get(1) + 1); // 3개 일치 (5,000원)
			}
		}
		int totalPrize = calculateTotalWinnings(result);
		double profitMargin = ((double) (totalPrize - userLotto.getPrice()) / totalPrize) * 100.0;
		WinningResult winningResult = new WinningResult(result, profitMargin);
		return winningResult;
	}

	public int calculateTotalWinnings(List<Integer> result) {
		int totalWinnings = 0;
		for (int i = 0; i < result.size(); i++) {
			int category = i + 1;
			int prize = calculatePrize(category); // 각 카테고리별 상금 계산
			int count = result.get(i); // 해당 카테고리의 당첨 횟수
			totalWinnings += prize * count;
		}
		return totalWinnings;
	}

	public int calculatePrize(int category) {
		int prize = 0;
		if (category == 1) { // 3개 일치 (5,000원)
			prize = 5000;
		} else if (category == 2) { // 4개 일치 (50,000원)
			prize = 50000;
		} else if (category == 3) { // 5개 일치 (1,500,000원)
			prize = 1500000;
		} else if (category == 4) { // 5개 + 보너스 숫자 일치 (30,000,000원)
			prize = 30000000;
		} else if (category == 5) { // 6개 일치 (2,000,000,000원)
			prize = 2000000000;
		}
		return prize;
	}

	private List<Integer> parseNumbers(String numbersString) {
		List<Integer> numbers = new ArrayList<>();
		String[] numberStrings = numbersString.split(",");
		for (String numberStr : numberStrings) {
			numbers.add(Integer.parseInt(numberStr));
		}
		return numbers;
	}
}
