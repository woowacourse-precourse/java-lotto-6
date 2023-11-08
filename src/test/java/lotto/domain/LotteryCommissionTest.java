package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.type.LottoResult;

public class LotteryCommissionTest {
	private List<Integer> winningNumbers;
	private LotteryCommission lotteryCommission;

	@BeforeEach
	public void setUp() {
		winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		lotteryCommission = new LotteryCommission(winningNumbers);
	}

	@Test
	@DisplayName("LotteryCommission 생성자 테스트")
	public void testValidWinningNumbers() {
		// Given in setup

		// Then no exception should be thrown
	}

	@Test
	@DisplayName("LotteryCommission 생성자 테스트 - 6개의 숫자가 아닌 경우")
	public void testInvalidWinningNumbers_Size() {
		// Given
		List<Integer> invalidNumbers = Arrays.asList(1, 2, 3, 4, 5);

		// When and Then
		assertThrows(IllegalArgumentException.class, () -> new LotteryCommission(invalidNumbers));
	}

	@Test
	@DisplayName("LotteryCommission 생성자 테스트 - 중복된 숫자가 있는 경우")
	public void testInvalidWinningNumbers_Duplicate() {
		// Given
		List<Integer> invalidNumbers = Arrays.asList(1, 2, 3, 4, 4, 5);

		// When and Then
		assertThrows(IllegalArgumentException.class, () -> new LotteryCommission(invalidNumbers));
	}

	@Test
	@DisplayName("LotteryCommission 생성자 테스트 - 범위를 벗어난 숫자가 있는 경우")
	public void testInvalidWinningNumbers_OutOfRange() {
		// Given
		List<Integer> invalidNumbers = Arrays.asList(1, 2, 3, 4, 5, 50);

		// When and Then
		assertThrows(IllegalArgumentException.class, () -> new LotteryCommission(invalidNumbers));
	}

	@Test
	@DisplayName("LotteryCommission 생성자 테스트 - 보너스 숫자가 중복되는 경우")
	public void testSetAndGetBonusNumber() {
		// Given
		Integer bonusNumber = 7;

		// When
		lotteryCommission.setBonusNumber(bonusNumber);
		Integer retrievedBonusNumber = lotteryCommission.getBonusNumber();

		// Then
		assertEquals(bonusNumber, retrievedBonusNumber);
	}

	@Test
	@DisplayName("LotteryCommission 생성자 테스트 - 보너스 숫자가 중복되는 경우")
	public void testCreateResults() {
		// When
		Map<LottoResult, Integer> results = lotteryCommission.createResults();

		// Then
		assertEquals(0, results.get(LottoResult.THREE));
		assertEquals(0, results.get(LottoResult.FOUR));
		assertEquals(0, results.get(LottoResult.FIVE));
		assertEquals(0, results.get(LottoResult.FIVE_BONUS));
		assertEquals(0, results.get(LottoResult.SIX));
	}

	@Test
	@DisplayName("LotteryCommission 생성자 테스트 - 보너스 숫자가 중복되는 경우")
	public void testGetLottoResult() {
		// Given
		Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

		// When
		Integer result = lotteryCommission.getLottoResult(lotto);

		// Then
		assertEquals(6, result);
	}

	@Test
	@DisplayName("LotteryCommission 생성자 테스트 - 보너스 숫자가 중복되는 경우")
	public void testIsBonusNumber() {
		// Given
		Integer bonusNumber = 7;
		lotteryCommission.setBonusNumber(bonusNumber);
		Lotto lottoWithBonus = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
		Lotto lottoWithoutBonus = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

		// When
		boolean isBonusWithBonus = lotteryCommission.isBonusNumber(lottoWithBonus);
		boolean isBonusWithoutBonus = lotteryCommission.isBonusNumber(lottoWithoutBonus);

		// Then
		assertTrue(isBonusWithBonus);
		assertFalse(isBonusWithoutBonus);
	}
}
