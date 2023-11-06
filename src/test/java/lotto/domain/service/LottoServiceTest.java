package lotto.domain.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningNumber;
import lotto.domain.dto.Result;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoServiceTest {

    @DisplayName("로또를 구매할 수 있다.")
    @Test
    void purchaseByAmount() {
        List<Lotto> lottos = new LottoService().purchase(new PurchaseAmount(10000L));

        assertThat(lottos).size().isEqualTo(10);
    }

    @DisplayName("수익률을 구할 수 있다.")
    @ParameterizedTest
    @MethodSource
    void getWinningResult(List<Lotto> lottos,
                          WinningNumber winningNumber,
                          PurchaseAmount purchaseAmount,
                          BigDecimal expected) {

        LottoService lottoService = new LottoService();

        Result winningResult = lottoService.getWinningResult(lottos, winningNumber, purchaseAmount);

        assertThat(winningResult.getRateOfReturn().compareTo(expected)).isZero();
    }

    public static Stream<Arguments> getWinningResult() {
        return Stream.of(
                Arguments.of(
                        List.of(
                                createLotto(1, 2, 3, 10, 11, 12),
                                createLotto(1, 2, 3, 10, 11, 12)
                        ),
                        createWinningNumber(7, 1, 2, 3, 4, 5, 6),
                        new PurchaseAmount(2000L),
                        new BigDecimal("500")),
                Arguments.of(
                        List.of(
                                createLotto(1, 2, 3, 10, 11, 12),
                                createLotto(10, 11, 12, 13, 14, 15),
                                createLotto(10, 11, 12, 13, 14, 15),
                                createLotto(10, 11, 12, 13, 14, 15),
                                createLotto(10, 11, 12, 13, 14, 15),
                                createLotto(10, 11, 12, 13, 14, 15),
                                createLotto(10, 11, 12, 13, 14, 15),
                                createLotto(10, 11, 12, 13, 14, 15),
                                createLotto(10, 11, 12, 13, 14, 15),
                                createLotto(10, 11, 12, 13, 14, 15)
                        ),
                        createWinningNumber(7, 1, 2, 3, 4, 5, 6),
                        new PurchaseAmount(10000L),
                        new BigDecimal("50"))
        );
    }

    private static Lotto createLotto(Integer... nums) {
        return new Lotto(Arrays.asList(nums));
    }

    private static WinningNumber createWinningNumber(int bonusNumber, Integer... nums) {
        return new WinningNumber(createLotto(nums), new LottoNumber(bonusNumber));
    }
}
