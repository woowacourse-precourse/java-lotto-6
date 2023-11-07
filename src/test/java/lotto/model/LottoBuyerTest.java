package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.dto.LottoResultDto;

class LottoBuyerTest {
    private static LottoManager lottoManager;

    @BeforeAll
    static void beforeAll() {
        final LottoMachine lottoMachine = new LottoMachine(() -> List.of(1, 2, 3, 4, 5, 6));
        lottoManager = new LottoManager(lottoMachine);
    }

    @Test
    @DisplayName("로또를 구입한다.")
    void buyLotto() throws Exception {
        // given
        final int amount = 8000;

        // when
        // then
        assertThatCode(() -> new LottoBuyer(amount, lottoManager))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("로또 당첨 결과를 계산한다.")
    void calculateLottoResult() throws Exception {
        // given
        final int amount = 8000;
        final LottoBuyer lottoBuyer = new LottoBuyer(amount, lottoManager);

        final List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        final LottoResult lottoResult = new LottoResult(winningNumbers, 45, lottoManager);

        // when
        final List<LottoResultDto> result = lottoBuyer.calculateResult(lottoResult);

        // then
        assertThat(result).hasSize(5);
        assertThat(result.get(0).winningCount()).isZero();
        assertThat(result.get(1).winningCount()).isZero();
        assertThat(result.get(2).winningCount()).isZero();
        assertThat(result.get(3).winningCount()).isZero();
        assertThat(result.get(4).winningCount()).isEqualTo(8);
    }

    @Test
    @DisplayName("수익률을 계산한다.")
    void returnOnInvestment() throws Exception {
        // given
        final int amount = 8000;
        final LottoBuyer lottoBuyer = new LottoBuyer(amount, lottoManager);

        final List<Integer> winningNumbers = List.of(2, 3, 4, 5, 6, 7);
        final LottoResult lottoResult = new LottoResult(winningNumbers, 1, lottoManager);

        // when
        lottoBuyer.calculateResult(lottoResult);
        final double returnOnInvestment = lottoBuyer.returnOnInvestment();

        // then
        assertThat(returnOnInvestment).isEqualTo(3_000_000);
    }

    @Test
    @DisplayName("당첨 수익이 0원이라면 수익률은 0이다.")
    void returnOnInvestmentZero() throws Exception {
        // given
        final int amount = 8000;
        final LottoBuyer lottoBuyer = new LottoBuyer(amount, lottoManager);

        final List<Integer> winningNumbers = List.of(10, 11, 12, 13, 14, 15);
        final LottoResult lottoResult = new LottoResult(winningNumbers, 45, lottoManager);

        // when
        lottoBuyer.calculateResult(lottoResult);
        final double returnOnInvestment = lottoBuyer.returnOnInvestment();

        // then
        assertThat(returnOnInvestment).isZero();
    }
}
