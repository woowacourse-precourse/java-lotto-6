package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.constant.PriceConstant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    private Lotteries lotteries;
    private WinningLotto winningLotto;

    @BeforeEach
    void init() {
        ParticularNumberGenerator particularNumberGenerator = new ParticularNumberGenerator(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 28));
        BonusNumber bonusNumber = BonusNumber.of("6", winningNumbers);

        lotteries = Lotteries.of(1, particularNumberGenerator);
        winningLotto = WinningLotto.of(winningNumbers,bonusNumber);
    }

    @DisplayName("2등 당첨을 확인한다.")
    @Test
    void checkSecondPrize() {
        LottoResult result = LottoResult.from();
        result.countWinningCase(lotteries.getLotteries(), winningLotto);

        assertThat(result.getResultMap().get(PriceConstant.SECOND_PLACE.getLabel())).isEqualTo(1);
    }

    @DisplayName("수익률을 계산한다.")
    @Test
    void checkEarningRate() {
        LottoResult result = LottoResult.from();
        result.countWinningCase(lotteries.getLotteries(), winningLotto);
        double earningRate = result.calculateEarningRate(1000);
        assertThat(earningRate).isEqualTo(3_000_000);
    }
}