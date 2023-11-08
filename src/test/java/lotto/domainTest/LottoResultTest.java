package lotto.domainTest;

import lotto.entity.LottoResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    @DisplayName("구입금액이 8000원이고 3개일치가 1개라면 수익률은 62.5이어야 한다")
    @Test
    void whenOne_3Correction() {
        LottoResult lottoResult = new LottoResult();
        lottoResult.plusOne_3Correction();
        Integer inputMoney = 8000;

        double profitRate = lottoResult.getProfitRate(inputMoney);
        double expectedProfitRate = 62.5;

        assertThat(profitRate).isEqualTo(expectedProfitRate);
    }

    @DisplayName("구입금액이 8000원이고 4개일치가 1개라면 수익률은 625이어야 한다")
    @Test
    void whenOne_4Correction() {
        LottoResult lottoResult = new LottoResult();
        lottoResult.plusOne_4Correction();
        Integer inputMoney = 8000;

        double profitRate = lottoResult.getProfitRate(inputMoney);
        double expectedProfitRate = 625;

        assertThat(profitRate).isEqualTo(expectedProfitRate);
    }
    @DisplayName("구입금액이 8000원이고 5개일치가 1개라면 수익률은 18750이어야 한다")
    @Test
    void whenOne_5Correction() {
        LottoResult lottoResult = new LottoResult();
        lottoResult.plusOne_5Correction();
        Integer inputMoney = 8000;

        double profitRate = lottoResult.getProfitRate(inputMoney);
        double expectedProfitRate = 18750;

        assertThat(profitRate).isEqualTo(expectedProfitRate);
    }
    @DisplayName("구입금액이 8000원이고 5개일치, 보너스 볼 일치가 1개라면 수익률은 375000이어야 한다")
    @Test
    void whenOne_5CorrectionAndBonus() {
        LottoResult lottoResult = new LottoResult();
        lottoResult.plusOne_5CorrectionAndBonus();
        Integer inputMoney = 8000;

        double profitRate = lottoResult.getProfitRate(inputMoney);
        double expectedProfitRate = 375000;

        assertThat(profitRate).isEqualTo(expectedProfitRate);
    }
    @DisplayName("구입금액이 8000원이고 6개일치가 1개라면 수익률은 25000000이어야 한다")
    @Test
    void whenOne_6Correction() {
        LottoResult lottoResult = new LottoResult();
        lottoResult.plusOne_6Correction();
        Integer inputMoney = 8000;

        double profitRate = lottoResult.getProfitRate(inputMoney);
        double expectedProfitRate = 25000000;

        assertThat(profitRate).isEqualTo(expectedProfitRate);
    }
    @DisplayName("구입금액이 8000원이고 3개일치가 1개, 4개일치 1개라면 수익률은 687.5이어야 한다")
    @Test
    void whenOne_3Correction_and_One_4Correction() {
        LottoResult lottoResult = new LottoResult();
        lottoResult.plusOne_3Correction();
        lottoResult.plusOne_4Correction();
        Integer inputMoney = 8000;

        double profitRate = lottoResult.getProfitRate(inputMoney);
        double expectedProfitRate = 687.5;

        assertThat(profitRate).isEqualTo(expectedProfitRate);
    }
    @DisplayName("구입금액이 8000원이고 3개일치가 1개, 4개일치 1개, 5개일치가 1개라면 수익률은 19437.5이어야 한다")
    @Test
    void whenOne_3Correction_and_One_4Correction_and_One_5Correction() {
        LottoResult lottoResult = new LottoResult();
        lottoResult.plusOne_3Correction();
        lottoResult.plusOne_4Correction();
        lottoResult.plusOne_5Correction();
        Integer inputMoney = 8000;

        double profitRate = lottoResult.getProfitRate(inputMoney);
        double expectedProfitRate = 19437.5;

        assertThat(profitRate).isEqualTo(expectedProfitRate);
    }
}
