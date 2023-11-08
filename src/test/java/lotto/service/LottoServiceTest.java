package lotto.service;

import lotto.exception.ExceptionMessage;
import lotto.model.Lotto;
import lotto.model.LottoTickets;
import lotto.model.LottoTotalPrize;
import lotto.model.WinningLotto;
import lotto.model.constants.LottoWinningRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class LottoServiceTest {
    private final LottoService lottoService = new LottoService();

    @ParameterizedTest
    @ValueSource(ints = {123, -1000, 0, 7800})
    @DisplayName("잘못된_금액_유효성_검사_예외_발생")
    void invalidInputAmount(int inputAmount) {
        assertThatThrownBy(
                () -> lottoService.createLottoTickets(inputAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_PURCHASE_AMOUNT.getErrorMessage());
    }

    @ParameterizedTest
    @MethodSource("inputWinningNumbers")
    @DisplayName("당첨 로또 번호 생성 확인")
    void createWinningLotto(List<Integer> inputWinningNumbers, int inputBonusNumber) {
        assertThat(lottoService.createWinningLotto(inputWinningNumbers, inputBonusNumber))
                .isInstanceOf(WinningLotto.class);
    }

    private static Stream<Arguments> inputWinningNumbers() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 7),
                Arguments.of(List.of(7, 8, 9, 10, 11, 12), 13),
                Arguments.of(List.of(13, 14, 15, 16, 17, 18), 19)
        );
    }

    @Test
    @DisplayName("당첨_번호_비교_정상작동_확인")
    void compareWinningNumberWithLottoTickets() {
        LottoTickets lottoTickets = Mockito.mock(LottoTickets.class);
        WinningLotto winningLotto = Mockito.mock(WinningLotto.class);
        Lotto lotto = Mockito.mock(Lotto.class);
        Lotto lotto2 = Mockito.mock(Lotto.class);
        LottoTotalPrize totalPrize = new LottoTotalPrize();
        totalPrize.prizeCountPlus(LottoWinningRank.FIRST);
        totalPrize.prizeCountPlus(LottoWinningRank.SECOND);

        Mockito.when(lottoTickets.getTickets()).thenReturn(List.of(lotto, lotto2));
        Mockito.when(lotto.getNumbers()).thenReturn(List.of(1, 2, 3, 4, 5, 6));
        Mockito.when(lotto2.getNumbers()).thenReturn(List.of(2, 3, 4, 5, 6, 7));
        Mockito.when(winningLotto.getNumbers()).thenReturn(List.of(2, 3, 4, 5, 6, 7));
        Mockito.when(winningLotto.getBonusNumber()).thenReturn(1);

        assertThat(lottoService.compareWinningNumbers(lottoTickets, winningLotto).getPrizeCounts())
                .isEqualTo(totalPrize.getPrizeCounts());
    }

    @Test
    @DisplayName("로또_수익률_확인")
    void calculateProfitability() {
        int AMOUNT = 2000;
        float result = (LottoWinningRank.FIRST.getPrize() + LottoWinningRank.SECOND.getPrize()) / AMOUNT * 100;

        LottoTickets lottoTickets = Mockito.mock(LottoTickets.class);
        LottoTotalPrize totalPrize = new LottoTotalPrize();
        Lotto lotto = Mockito.mock(Lotto.class);
        Lotto lotto2 = Mockito.mock(Lotto.class);
        totalPrize.prizeCountPlus(LottoWinningRank.FIRST);
        totalPrize.prizeCountPlus(LottoWinningRank.SECOND);

        Mockito.when(lottoTickets.getTickets()).thenReturn(List.of(lotto, lotto2));
        Mockito.when(lotto.getNumbers()).thenReturn(List.of(1, 2, 3, 4, 5, 6));
        Mockito.when(lotto2.getNumbers()).thenReturn(List.of(2, 3, 4, 5, 6, 7));

        assertThat(lottoService.calculateProfitability(lottoTickets, totalPrize))
                .isEqualTo(result);
    }
}
