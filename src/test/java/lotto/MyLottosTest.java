package lotto;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import lotto.enums.LottoRank;

class MyLottosTest {

	private Lotto winnerLotto;
	private BonusNumber bonusNumber;
	private MyLottos myLottos;

	@BeforeEach
	public void setUp() {
		winnerLotto = Mockito.mock(Lotto.class);
		bonusNumber = Mockito.mock(BonusNumber.class);

		when(winnerLotto.getNumbers()).thenReturn(Arrays.asList(1, 2, 3, 4, 5, 6));
		when(bonusNumber.getBonusNumber()).thenReturn(7);
		myLottos = new MyLottos(4);
		myLottos.getLottos().clear(); // Clear any Lottos that were added in the constructor
		myLottos.getLottos().addAll(
			Arrays.asList(
				new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),  // 1등
				new Lotto(Arrays.asList(1, 2, 3, 4, 5, 9)),  // 3등
				new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)), // 2등
				new Lotto(Arrays.asList(12, 13, 14, 15, 16, 17)) // No win
			)
		);
	}


	@DisplayName("구매 장수를 입력해 생성하면 그에 맞는 List<Lotto>를 생성한다.")
	@Test
	void creatLottoList() {
		MyLottos myLottos1 = new MyLottos(7);
		assertThat(myLottos1.getLottos()).hasSize(7);
	}

	@DisplayName("compareLottoNumber 메서드는 로또 결과를 정확하게 기록해야 한다")
	@Test
	void compareLottoNumber() {
		myLottos.compareLottoNumber(winnerLotto, bonusNumber);

		EnumMap<LottoRank, Integer> results = myLottos.getResults();
		assertThat(results).containsEntry(LottoRank.RANK1, 1);
		assertThat(results).containsEntry(LottoRank.RANK2, 1);
		assertThat(results).containsEntry(LottoRank.RANK3, 1);
		assertThat(results).doesNotContainKey(LottoRank.RANK4);
		assertThat(results).doesNotContainKey(LottoRank.RANK5);
	}

	@DisplayName("calculateEarningRate 메서드는 수익률을 정확하게 계산해야 한다")
	@Test
	void calculateEarningRateCorrectly() {
		//현재 1등,2등,3등 1개씩, 구매는 4장
		int purchasePrice = 4 * 1000;
		double totalPrizeMoney = LottoRank.RANK1.getPrizeMoney()
			+ LottoRank.RANK3.getPrizeMoney()
			+ LottoRank.RANK2.getPrizeMoney();
		double profit = totalPrizeMoney / purchasePrice;
		myLottos.compareLottoNumber(winnerLotto, bonusNumber);
		myLottos.calculateEarningRate();
		assertThat(myLottos.getProfit()).isEqualTo(profit);
	}
}