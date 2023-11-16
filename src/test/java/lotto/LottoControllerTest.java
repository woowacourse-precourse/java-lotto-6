package lotto;

import lotto.controller.LottoController;
import lotto.domain.Lotto;
import lotto.service.LottoMachine;
import lotto.view.InputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LottoControllerTest {
    private LottoController lottoController;
    private LottoMachine lottoMachine;
    private InputView inputView;

    @BeforeEach
    public void setUp() {
        lottoMachine = new LottoMachine();
        inputView = new InputView();
        lottoController = new LottoController(lottoMachine, inputView);
    }

    @Test
    @DisplayName("로또 티켓 생성 테스트")
    public void testGenerateLottoTickets() {
        // 구입 금액을 설정하고 예상 티켓 수를 계산
        int purchaseAmount = 5000;
        int expectedTicketCount = purchaseAmount / 1000;

        // generateLottoTickets 메서드를 호출하여 로또 티켓을 생성
        List<Lotto> generatedLottoTickets = lottoController.generateLottoTickets(purchaseAmount);

        // 예상 티켓 수와 실제 생성된 티켓 수 비교
        assertEquals(expectedTicketCount, generatedLottoTickets.size());

        // 각 로또 티켓에 대한 검증
        for (Lotto lotto : generatedLottoTickets) {
            // 로또 번호 목록 가져오기
            List<Integer> numbers = lotto.getNumbers();
            Set<Integer> numberSet = new HashSet<>(numbers);

            // 중복된 숫자가 없는지 확인
            assertEquals(numbers.size(), numberSet.size());

            // 각 로또 번호가 1부터 45 사이에 있는지 확인
            for (int number : numbers) {
                assertTrue(number >= 1 && number <= 45);
            }

            // 각 로또 티켓은 6개의 숫자를 가져야 함
            assertEquals(6, numbers.size());
        }
    }

    @Test
    @DisplayName("수익률 계산 테스트")
    public void testCalculateEarningRate() {

        // 수익률 계산을 테스트할 데이터
        int totalPrize = 50000;
        int ticketCount = 50;

        // 예상되는 수익률 (0.0부터 1.0 사이의 값)
        double expectedEarningRate = (double) totalPrize / (ticketCount * 1000);

        // 수익률 계산 메서드를 호출하고 예상 값과 비교
        double actualEarningRate = lottoController.calculateEarningRate(totalPrize, ticketCount);
        assertEquals(expectedEarningRate, actualEarningRate, 0.0001);
    }
}