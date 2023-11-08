package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoServiceTest {

    LottoService lottoService;

    @BeforeEach
    void setup() {
        lottoService = new LottoService();
    }

    @ParameterizedTest
    @MethodSource("invalidWinningNumberProvider")
    @DisplayName("잘못된 숫자 문자열, 보너스 번호를 통해 당첨 번호를 생성할 수 예외를 던진다.")
    void generateWinningNumber_InvalidInput_ThrownException(List<Integer> winningNumbers, int bonusNumber) {
        // given
        // when
        // then
        assertThatThrownBy(() -> lottoService.generateWinningNumber(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구매 금액으로 로또 금액단위가 아닌 값이 들어온 경우 예외를 던진다.")
    void purchaseLotto_InValidAmount() {
        // given
        int paymentAmount = 900;

        // when
        // then
        assertThatThrownBy(() -> lottoService.purchaseLotto(paymentAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구매 금액으로 음수가 들어온 경우 예외를 던진다.")
    void purchaseLotto_NegativeAmount_ThrownException() {
        // given
        int paymentAmount = -2000;

        // when
        // then
        assertThatThrownBy(() -> lottoService.purchaseLotto(paymentAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 가격 단위 구매시 로또를 발행한다.")
    void purchaseLotto() {
        // given
        int paymentAmount = 2000;

        // when
        lottoService.purchaseLotto(paymentAmount);

        // then
        assertThat(lottoService.getLottoNumbers()).hasSize(2);
    }

    @Test
    @DisplayName("전체 구매 금액이 0인 경우 수익률을 0%를 반환한다.")
    void calculateProfitRate_ZeroTotalPaymentAmount_Return0() {
        // given
        int paymentAmount = 0;

        // when
        lottoService.purchaseLotto(paymentAmount);

        // then
        assertThat(lottoService.calculateProfitRate()).isEqualTo(0.00);
    }

    private static Stream<Arguments> invalidWinningNumberProvider() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 6),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6, 7), 8),
                Arguments.of(List.of(11, 12, 13, 14, 15, 46), 1),
                Arguments.of(List.of(1, 2, 3, 4, 15, 16), 46),
                Arguments.of(List.of(1, 2, 3, 4, 7, 6), -2)
        );
    }
}

