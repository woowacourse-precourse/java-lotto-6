package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.constant.LottoConstants;
import lotto.domain.strategy.LottoNumberGenerator;
import lotto.domain.strategy.RandomLottoNumberGenerator;
import lotto.vo.TotalAmount;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoPurchaseTest {

    @ParameterizedTest
    @CsvSource({
            "1000,1",
            "2000,2",
            "3000,3"
    })
    void testLottoPurchaseAndTicketGeneration(int totalAmountValue, int expectedTicketCount) {
        // TotalAmount 객체를 준비합니다.
        TotalAmount totalAmount = TotalAmount.from(totalAmountValue);
        LottoNumberGenerator lottoNumberGenerator = new RandomLottoNumberGenerator();

        // 실제 로또 티켓 수를 계산합니다.
        LottoPurchase lottoPurchase = LottoPurchase.from(totalAmount, lottoNumberGenerator);
        assertThat(lottoPurchase.getTicketCount()).isEqualTo(expectedTicketCount);

        // Randoms 클래스의 pickUniqueNumbersInRange 메소드를 mocking합니다.
        List<Integer> mockNumbers = IntStream.rangeClosed(1, LottoConstants.LOTTO_COUNT).boxed().collect(Collectors.toList());
        when(Randoms.pickUniqueNumbersInRange(
                LottoConstants.MIN_NUMBER,
                LottoConstants.MAX_NUMBER,
                LottoConstants.LOTTO_COUNT)
        ).thenReturn(mockNumbers);

        // 로또 티켓을 생성하고 결과를 검증합니다.
        LottoTickets generatedTickets = lottoPurchase.generateTickets();
        assertThat(generatedTickets.getTickets()).hasSize(expectedTicketCount);
        for (Lotto ticket : generatedTickets.getTickets()) {
            // 티켓의 번호가 mocking된 번호와 같은지 확인합니다.
            assertThat(ticket.getNumbers()).containsExactlyElementsOf(mockNumbers);
        }
    }
}
