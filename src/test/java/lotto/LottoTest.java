package lotto;

import lotto.model.Lotto;
import lotto.service.LottoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoTest {
    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        lottoService = new LottoService();
    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1000원으로 나누어떨어지지 않는 경우 예외 처리")
    @Test
    void purchaseAmountNotDivisibleBy1000Exception() {
        int purchaseAmount = 7777;
        assertThatThrownBy(() -> lottoService.validatePurchaseAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액에 따라 로또 티켓 수를 계산")
    @Test
    void calculateNumberOfLottoTicketsToBuy() {
        int purchaseAmount = 8000;
        int expectedTicketCount = 8;
        int actualTicketCount = lottoService.calculateNumberOfLottoTicketsToBuy(purchaseAmount);
        assertEquals(expectedTicketCount, actualTicketCount);
    }

    @DisplayName("로또 티켓 개수에 따라 정확한 티켓 목록 생성")
    @Test
    void generateLottoTickets() {
        int numberOfTickets = 3;
        List<Lotto> lottoTickets = lottoService.generateLottoTickets(numberOfTickets);
        assertEquals(numberOfTickets, lottoTickets.size());
    }

    @DisplayName("구입 금액에 따라 로또 티켓 목록 생성")
    @Test
    void buyLottoTickets() {
        int purchaseAmount = 5000;
        int expectedTicketCount = 5;
        List<Lotto> lottoTickets = lottoService.buyLottoTickets(purchaseAmount);
        assertEquals(expectedTicketCount, lottoTickets.size());
    }

    @DisplayName("로또 번호가 오름차순으로 출력")
    @Test
    void testGetAscendingSortedNumbers() {
        List<Integer> numbers = Arrays.asList(26, 42, 4, 12, 5, 31);
        Lotto lotto = new Lotto(numbers);
        List<Integer> sortedNumbers = lotto.getAscendingSortedNumbers();
        List<Integer> expectedSortedNumbers = Arrays.asList(4, 5, 12, 26, 31, 42);
        assertEquals(expectedSortedNumbers, sortedNumbers);
    }
}