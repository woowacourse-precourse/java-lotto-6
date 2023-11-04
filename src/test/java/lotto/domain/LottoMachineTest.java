package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LottoMachineTest {

    private LottoMachine lottoMachine;
    private final int LOTTO_PRICE = 1000;

    @BeforeEach
    void setUp() {
        lottoMachine = new LottoMachine();
    }

    @Test
    @DisplayName("지불한 금액에 맞게 로또 티켓을 구매한다.")
    void purchaseTickets() {
        int money = 5000;
        List<LottoTicket> tickets = lottoMachine.purchaseTickets(money);
        assertEquals(money / LOTTO_PRICE, tickets.size());
    }

    @Test
    @DisplayName("생성된 로또 티켓에 중복된 숫자가 없어야 한다.")
    void noDuplicateNumbersInTickets() {
        List<LottoTicket> tickets = lottoMachine.purchaseTickets(1000);
        for (LottoTicket ticket : tickets) {
            Set<Integer> uniqueNumbers = new HashSet<>(ticket.getNumbers());
            assertEquals(6, uniqueNumbers.size());
        }
    }

    @Test
    @DisplayName("로또 티켓의 숫자가 1부터 45 사이여야 한다.")
    void numbersShouldBeBetween1And45() {
        List<LottoTicket> tickets = lottoMachine.purchaseTickets(1000);
        for (LottoTicket ticket : tickets) {
            for (int number : ticket.getNumbers()) {
                assertTrue(number >= 1 && number <= 45);
            }
        }
    }

    @Test
    @DisplayName("다수의 로또 티켓 생성 시 각 티켓이 고유해야 한다.")
    void generateMultipleUniqueTickets() {
        List<LottoTicket> firstBatch = lottoMachine.purchaseTickets(5000);
        List<LottoTicket> secondBatch = lottoMachine.purchaseTickets(5000);
        Set<LottoTicket> uniqueTickets = new HashSet<>();
        uniqueTickets.addAll(firstBatch);
        uniqueTickets.addAll(secondBatch);

        assertEquals(firstBatch.size() + secondBatch.size(), uniqueTickets.size());
    }
}
