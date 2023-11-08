package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.AnswerLotto;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class LottoServiceTest {

	private LottoService lottoService;
	private int money;
	private int lottoPriceSum;
	private double totalReturn;
	private Lotto answerLottoNumbers;
	private AnswerLotto answerLotto;
	private Lottos lottos;

	@BeforeEach
	void setup() {
		lottoService = new LottoService();
		money = 4000;
		answerLottoNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
		answerLotto = new AnswerLotto(answerLottoNumbers, new BonusNumber(answerLottoNumbers, 7));
		lottos = new Lottos(List.of(new Lotto(List.of(1, 2, 3, 11, 12, 13)), new Lotto(List.of(1, 2, 3, 4, 12, 13)),
				new Lotto(List.of(8, 9, 10, 11, 12, 13)), new Lotto(List.of(8, 9, 10, 11, 12, 13))));
	}

	@DisplayName("로또들의 총상금의 합을 확인한다.")
	@Test
	void checkLottoPriceSum() {
		lottoPriceSum = lottoService.calculateLottoPriceSum(lottos, answerLotto);

		assertEquals(lottoPriceSum, 55000);
	}

	@DisplayName("총 수익률을 확인한다.")
	@Test
	void checkTotalReturn() {
		lottoPriceSum = lottoService.calculateLottoPriceSum(lottos, answerLotto);
		totalReturn = lottoService.calculateTotalReturn(money, lottoPriceSum);

		assertEquals(totalReturn, 1375.0);
	}

	@DisplayName("당첨 통계 메시지를 확인한다.")
	@Test
	void checkWinningStatisticsMessage() {
		String winningStatisticsMessage = lottoService.getWinningStatisticsMessage(lottos, answerLotto);

		assertThat(winningStatisticsMessage).contains(
				"3개 일치 (5,000원) - 1개",
				"4개 일치 (50,000원) - 1개",
				"5개 일치 (1,500,000원) - 0개", 
				"5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
				"6개 일치 (2,000,000,000원) - 0개");
	}
}