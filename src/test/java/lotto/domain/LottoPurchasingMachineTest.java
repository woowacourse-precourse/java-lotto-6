package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import domain.LottoPurchasingMachine;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoPurchasingMachineTest {
    @ParameterizedTest
    @DisplayName("로또 금액 지불 실패 테스트 - 구입할 수 없는 금액")
    @ValueSource(ints = {-10_000, -1_000, 0})
    void purchaseOfLottoTicketsImpossiblePayAmountTest(int amount) {
        LottoPurchasingMachine lottoPurchasingMachine = new LottoPurchasingMachine();
        assertThrows(IllegalArgumentException.class, () -> lottoPurchasingMachine.purchaseOfLottoTickets(amount));
    }

    @ParameterizedTest
    @DisplayName("로또 금액 지불 실패 테스트 - 구매 금액 단위 맞지 않음")
    @ValueSource(ints = {1, 11, 111, 1_111, 11_111})
    void purchaseOfLottoTicketsNotCorrectPayAmountTest(int amount) {
        LottoPurchasingMachine lottoPurchasingMachine = new LottoPurchasingMachine();
        assertThrows(IllegalArgumentException.class, () -> lottoPurchasingMachine.purchaseOfLottoTickets(amount));
    }

    @ParameterizedTest
    @DisplayName("로또 금액 정상 지불 테스트")
    @MethodSource("purchaseAmountAndExpectLottoTicketsNumber")
    void purchaseOfLottoTicketsSuccessTest(int purchaseAmount, int expectLottoTicketsNumber) {
        LottoPurchasingMachine lottoPurchasingMachine = new LottoPurchasingMachine();
        assertThat(lottoPurchasingMachine.purchaseOfLottoTickets(purchaseAmount))
                .isEqualTo(expectLottoTicketsNumber);
    }

    public static Stream<Arguments> purchaseAmountAndExpectLottoTicketsNumber() {
        return Stream.of(
                Arguments.of(1_000, 1),
                Arguments.of(10_000, 10),
                Arguments.of(100_000, 100)
        );
    }

}
