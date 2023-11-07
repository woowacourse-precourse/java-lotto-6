package lotto.domain.constant;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import lotto.constant.Grade;

class GradeTest {
	@Test
	void 일등_이십억() {
		assertEquals("2,000,000,000", Grade.FIRST.getFormattedPrize());
	}

	@Test
	void 이등_삼천만() {
		assertEquals("30,000,000", Grade.SECOND.getFormattedPrize());
	}

	@Test
	void 삼등_백오십만() {
		assertEquals("1,500,000", Grade.THIRD.getFormattedPrize());
	}

	@Test
	void 사등_오만() {
		assertEquals("50,000", Grade.FOURTH.getFormattedPrize());
	}

	@Test
	void 오등_오천() {
		assertEquals("5,000", Grade.FIFTH.getFormattedPrize());
	}

	@Test
	void 일등() {
		assertEquals(Grade.FIRST, Grade.of(6, false));
	}

	@Test
	void 이등() {
		assertEquals(Grade.SECOND, Grade.of(5, true));
	}

	@Test
	void 삼등() {
		assertEquals(Grade.THIRD, Grade.of(5, false));
	}

	@Test
	void 사등() {
		assertEquals(Grade.FOURTH, Grade.of(4, false));
	}

	@Test
	void 오등() {
		assertEquals(Grade.FIFTH, Grade.of(3, false));
	}

	@Test
	void 당첨안된경우() {
		assertEquals(Grade.NO_RANK, Grade.of(2, false));
	}

}