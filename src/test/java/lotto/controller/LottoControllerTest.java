package lotto.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LottoControllerTest {

	@Test
	void 로또_구매_금액_입력() {
		String amount = "7000";
		assertThat(amount).isEqualTo("7000");
	}

}
