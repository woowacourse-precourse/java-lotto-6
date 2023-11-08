package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import lotto.dto.Bill;
import java.util.stream.Stream;
import lotto.exception.ImpossibleAmountException;
import lotto.exception.NotCorrectUnitAmountException;
import lotto.exception.NotPositivePurchaseAmountException;
import lotto.exception.OverMaxPurchaseAmountException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoTicketsPurchasingMachineTest {
    private final LottoTicketsPurchasingMachine lottoTicketsPurchasingMachine = new LottoTicketsPurchasingMachine();
    @ParameterizedTest
    @DisplayName("로또 금액으로 음수를 지불하면 예외가 발생한다.")
    @ValueSource(ints = {-10_000, -1_000})
    void purchaseOfLottoTicketsNotPositiveAmount(int amount) {
        assertThrows(ImpossibleAmountException.class,
                () -> lottoTicketsPurchasingMachine.purchaseOfLottoTickets(amount));
    }

    @Test
    @DisplayName("로또 금액으로 0원을 지불하면 예외가 발생한다.")
    void purchaseOfLottoTicketsNotPositiveAmount() {
        assertThrows(NotPositivePurchaseAmountException.class,
                () -> lottoTicketsPurchasingMachine.purchaseOfLottoTickets(0));
    }

    @ParameterizedTest
    @DisplayName("로또 금액으로 구매 금액 단위에 맞지 않는 수를 지불하면 예외가 발생한다.")
    @ValueSource(ints = {1, 11, 111, 1_111, 11_111})
    void purchaseOfLottoTicketsNotCorrectUnitAmount(int amount) {
        assertThrows(NotCorrectUnitAmountException.class,
                () -> lottoTicketsPurchasingMachine.purchaseOfLottoTickets(amount));
    }

    @Test
    @DisplayName("최대치를 넘는 금액을 입력하면 예외가 발생한다.")
    void purchaseOfLottoTicketsOverMaxAmount() {
        assertThrows(OverMaxPurchaseAmountException.class,
                () -> lottoTicketsPurchasingMachine.purchaseOfLottoTickets(Integer.MAX_VALUE));
    }

    @ParameterizedTest
    @DisplayName("로또 금액 정상 지불")
    @MethodSource("purchaseAmountAndExpectLottoTicketsNumber")
    void purchaseOfLottoTicketsSuccessTest(int purchaseAmount, int expectLottoTicketsNumber) {
        Bill bill = lottoTicketsPurchasingMachine.purchaseOfLottoTickets(purchaseAmount);
        TicketSize ticketSize = bill.getTicketSize();
        assertThat(ticketSize.getTicketSize()).isEqualTo(expectLottoTicketsNumber);
    }

    public static Stream<Arguments> purchaseAmountAndExpectLottoTicketsNumber() {
        return Stream.of(
                Arguments.of(1_000, 1),
                Arguments.of(10_000, 10),
                Arguments.of(100_000, 100)
        );
    }

}
