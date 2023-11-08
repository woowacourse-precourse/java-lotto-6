package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningStatisticsTest {
	
	WinningStatistics winningStatistics;
	
	Lotto purchaseNumbers;
	Lotto winningNumbers;
	BonusNumber bonusNumber;
	
	@BeforeEach
	void SetUp() {
		winningStatistics = new WinningStatistics();
		winningNumbers = new Lotto(Arrays.asList(1,2,3,4,5,6));
		bonusNumber = new BonusNumber(7, winningNumbers);
	}

	@DisplayName("1등 당첨 결과가 제대로 추가되는지 확인한다.")
	@Test
	void 복권_1등_당첨_결과_확인() {
		purchaseNumbers = new Lotto(Arrays.asList(1,2,3,4,5,6));
		winningStatistics.addWinning(purchaseNumbers, winningNumbers, bonusNumber);

	    Map<Rank, Integer> winnings = winningStatistics.getWinnings();
	    assertThat(winnings.get(Rank.FIRST)).isEqualTo(1);
	}
	
	@DisplayName("2등 당첨 결과가 제대로 추가되는지 확인한다.")
	@Test
	void 복권_2등_당첨_결과_확인() {
		purchaseNumbers = new Lotto(Arrays.asList(1,2,3,4,5,7));
		
		winningStatistics.addWinning(purchaseNumbers, winningNumbers, bonusNumber);

	    Map<Rank, Integer> winnings = winningStatistics.getWinnings();
	    assertThat(winnings.get(Rank.SECOND)).isEqualTo(1);
	}
	
	@DisplayName("3등 당첨 결과가 제대로 추가되는지 확인한다.")
	@Test
	void 복권_3등_당첨_결과_확인() {
		purchaseNumbers = new Lotto(Arrays.asList(1,2,3,4,5,10));
		winningStatistics.addWinning(purchaseNumbers, winningNumbers, bonusNumber);

	    Map<Rank, Integer> winnings = winningStatistics.getWinnings();
	    assertThat(winnings.get(Rank.THIRD)).isEqualTo(1);
	}
	
	@DisplayName("4등 당첨 결과가 제대로 추가되는지 확인한다.")
	@Test
	void 복권_4등_당첨_결과_확인() {
		purchaseNumbers = new Lotto(Arrays.asList(1,2,3,4,10,11));
		winningStatistics.addWinning(purchaseNumbers, winningNumbers, bonusNumber);

	    Map<Rank, Integer> winnings = winningStatistics.getWinnings();
	    assertThat(winnings.get(Rank.FOURTH)).isEqualTo(1);
	}
	
	@DisplayName("5등 당첨 결과가 제대로 추가되는지 확인한다.")
	@Test
	void 복권_5등_당첨_결과_확인() {
		purchaseNumbers = new Lotto(Arrays.asList(1,2,3,10,11,12));
		winningStatistics.addWinning(purchaseNumbers, winningNumbers, bonusNumber);

	    Map<Rank, Integer> winnings = winningStatistics.getWinnings();
	    assertThat(winnings.get(Rank.FIFTH)).isEqualTo(1);
	}
	
	@DisplayName("총 수익률 계산이 제대로 동작하는지 확인한다.")
	@Test
	void 총_수익률_계산_동작_확인() {
		purchaseNumbers = new Lotto(Arrays.asList(1,2,3,10,11,12));
	    winningStatistics.addWinning(purchaseNumbers, winningNumbers, bonusNumber);

	    
	    double expectedProfitRate = (5000.0 / 8000.0) * 100;
	    double actualProfitRate = winningStatistics.getTotalProfitRate(8000);

	    assertThat(actualProfitRate).isEqualTo(expectedProfitRate);
	}
}
