package domain;

import java.util.HashMap;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoCalculatorTest {
	private static HashMap<LottoPrize, Integer> getLottoPrizeIntegerHashMap() {
		HashMap<LottoPrize, Integer> result = new HashMap<>() {{
			put(LottoPrize.FIRST_PRIZE, 1);
			put(LottoPrize.SECOND_PRIZE, 1);
			put(LottoPrize.THIRD_PRIZE, 1);
			put(LottoPrize.FOURTH_PRIZE, 1);
			put(LottoPrize.FIFTH_PRIZE, 1);
			put(LottoPrize.BLANK, 0);
		}};
		return result;
	}

	private static PurchaseLotto getPurchaseLotto() {
		PurchaseLotto purchaseLotto = new PurchaseLotto();
		purchaseLotto.getLottos().add(new Lotto("1,2,3,4,5,6"));
		purchaseLotto.getLottos().add(new Lotto("1,2,3,4,5,7"));
		purchaseLotto.getLottos().add(new Lotto("1,2,3,4,5,8"));
		purchaseLotto.getLottos().add(new Lotto("1,2,3,4,8,9"));
		purchaseLotto.getLottos().add(new Lotto("1,2,3,7,8,9"));

		return purchaseLotto;
	}

	private static WinningLotto getWinningLotto() {
		WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6", "7");
		return winningLotto;
	}

	@DisplayName("당첨 번호와 로또 번호를 비교해 같은 숫자 카운트")
	@Test
	public void countMatchingNumbers() {
		//given
		int expected = 4;
		WinningLotto winningLotto = getWinningLotto();

		Lotto purchaseLotto = new Lotto("1,2,8,4,5,9");

		// when
		WinningLottoCalculator winningLottoCalculator = new WinningLottoCalculator();
		long matchCount = winningLottoCalculator.getMatchCount(purchaseLotto, winningLotto);

		//then
		Assertions.assertThat(matchCount).isEqualTo(expected);
	}

	@DisplayName("로또 번호 중 보너스 번호가 있는지 체크")
	@Test
	public void checkBonusNumberInLottoNumbers() {
		//given
		WinningLotto winningLotto = getWinningLotto();
		Lotto purchaseLotto = new Lotto("1,2,8,4,5,7");

		// when
		WinningLottoCalculator winningLottoCalculator = new WinningLottoCalculator();
		boolean bonusNumberMatchLotto = winningLottoCalculator.isBonusNumberMatchLotto(purchaseLotto, winningLotto);

		//then
		Assertions.assertThat(bonusNumberMatchLotto).isTrue();
	}

	@DisplayName("1등~5등 중 당첨 개수 카운트 - 1등부터 5등까지 1번씩 당첨된 경우")
	@Test
	public void createForEachLottoPrizes() {
		//given
		PurchaseLotto purchaseLotto = getPurchaseLotto();
		WinningLotto winningLotto = getWinningLotto();

		HashMap<LottoPrize, Integer> result = getLottoPrizeIntegerHashMap();

		// when
		WinningLottoCalculator winningLottoCalculator = new WinningLottoCalculator();
		winningLottoCalculator.calculateLottoPrizeCount(purchaseLotto, winningLotto);

		// then
		Assertions.assertThat(winningLottoCalculator.getLottoPrizes()).isEqualTo(result);
	}

	@DisplayName("당첨 금액 계산")
	@Test
	public void calculateLottoPrizeTotalMoney() {
		//given
		Long excepted = 2031555000L;
		PurchaseLotto purchaseLotto = getPurchaseLotto();
		WinningLotto winningLotto = getWinningLotto();

		// when
		WinningLottoCalculator winningLottoCalculator = new WinningLottoCalculator();
		winningLottoCalculator.calculateLottoPrizeCount(purchaseLotto, winningLotto);

		//then
		Assertions.assertThat(winningLottoCalculator.getTotalPrizeMoney()).isEqualTo(excepted);
	}

	@DisplayName("수익률 계산")
	@Test
	public void calculateRateOfReturn() {
		// given
		double expected = 500.0;

		PurchaseAmount purchaseAmount = new PurchaseAmount("3000");
		WinningLotto winningLotto = getWinningLotto();

		PurchaseLotto purchaseLotto = new PurchaseLotto();
		purchaseLotto.getLottos().add(new Lotto("1,2,3,8,9,10"));
		purchaseLotto.getLottos().add(new Lotto("1,2,3,8,9,10"));
		purchaseLotto.getLottos().add(new Lotto("1,2,3,8,9,10"));

		WinningLottoCalculator winningLottoCalculator = new WinningLottoCalculator();
		winningLottoCalculator.calculateLottoPrizeCount(purchaseLotto, winningLotto);

		// when
		double rateOfReturn = winningLottoCalculator.getRateOfReturn(purchaseAmount);

		// then
		Assertions.assertThat(rateOfReturn).isEqualTo(expected);
	}

	@DisplayName("소수 둘째 자리에서 반올림")
	@Test
	public void test() {
		// given
		double number = 3.17;
		double excepted = 3.2;

		// when
		WinningLottoCalculator winningLottoCalculator = new WinningLottoCalculator();
		double roundedNumber = winningLottoCalculator.roundToTwoDecimalPlaces(number);

		// then
		Assertions.assertThat(roundedNumber).isEqualTo(excepted);
	}
}

