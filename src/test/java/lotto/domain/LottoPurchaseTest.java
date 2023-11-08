package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.strategy.LottoNumberGenerator;
import lotto.vo.TotalAmount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoPurchaseTest {

    private LottoNumberGenerator mockNumberGenerator;

    // 고정된 로또 번호를 생성하는 모킹된 LottoNumberGenerator
    private LottoNumberGenerator createMockNumberGenerator() {
        return () -> IntStream.rangeClosed(1, 6)
                .boxed()
                .collect(Collectors.toList());
    }

    @ParameterizedTest
    @CsvSource({
            "14000, 14",
            "15000, 15",
            "20000, 20"
    })
    @DisplayName("LottoPurchase가 주어진 금액에 따라 올바른 수의 로또 티켓을 생성해야 한다")
    void testGenerateTickets(int totalAmountValue, int expectedTicketCount) {
        TotalAmount totalAmount = TotalAmount.from(totalAmountValue);
        mockNumberGenerator = createMockNumberGenerator();
        LottoPurchase lottoPurchase = LottoPurchase.from(totalAmount, mockNumberGenerator);

        LottoTickets tickets = lottoPurchase.generateTickets();

        assertThat(tickets.getTickets()).hasSize(expectedTicketCount);
        tickets.getTickets().forEach(ticket -> assertThat(ticket
                .getNumbers())
                .containsExactlyElementsOf(mockNumberGenerator.generate()));
    }
}
