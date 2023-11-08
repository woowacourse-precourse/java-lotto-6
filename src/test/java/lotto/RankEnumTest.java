package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class RankEnumTest {
	@Test
	public void testHasBonus() {
		assertTrue(RankEnum.SECOND.hasBonus());
		assertFalse(RankEnum.FIRST.hasBonus());
		assertFalse(RankEnum.THIRD.hasBonus());
		assertFalse(RankEnum.FORTH.hasBonus());
		assertFalse(RankEnum.FIFTH.hasBonus());
		assertFalse(RankEnum.NONE.hasBonus());
	}

	@Test
	public void testGetMatchCount() {
		assertEquals(0, RankEnum.NONE.getMatchCount());
		assertEquals(3, RankEnum.FIFTH.getMatchCount());
		assertEquals(4, RankEnum.FORTH.getMatchCount());
		assertEquals(5, RankEnum.THIRD.getMatchCount());
		assertEquals(5, RankEnum.SECOND.getMatchCount());
		assertEquals(6, RankEnum.FIRST.getMatchCount());
	}

	@Test
	public void testGetPrize() {
		assertEquals(0, RankEnum.NONE.getPrize());
		assertEquals(5_000, RankEnum.FIFTH.getPrize());
		assertEquals(50_000, RankEnum.FORTH.getPrize());
		assertEquals(1_500_000, RankEnum.THIRD.getPrize());
		assertEquals(30_000_000, RankEnum.SECOND.getPrize());
		assertEquals(2_000_000_000, RankEnum.FIRST.getPrize());
	}

	@Test
	public void testGetFormattedPrize() {
		assertEquals("0", RankEnum.NONE.getFormattedPrize());
		assertEquals("5,000", RankEnum.FIFTH.getFormattedPrize());
		assertEquals("50,000", RankEnum.FORTH.getFormattedPrize());
		assertEquals("1,500,000", RankEnum.THIRD.getFormattedPrize());
		assertEquals("30,000,000", RankEnum.SECOND.getFormattedPrize());
		assertEquals("2,000,000,000", RankEnum.FIRST.getFormattedPrize());
	}

	@Test
	public void testGetRankByMatchCount() {
		RankEnum result1 = RankEnum.getRankByMatchCount(0);
		assertEquals(RankEnum.NONE, result1);


		RankEnum result2 = RankEnum.getRankByMatchCount(3);
		assertEquals(RankEnum.FIFTH, result2);

		RankEnum result3 = RankEnum.getRankByMatchCount(6);
		assertEquals(RankEnum.FIRST, result3);
	}

}
