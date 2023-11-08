package lotto.domain;

import lotto.LottoTicket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class LottoTicketGeneratorTest {
    private LottoTicketGenerator lottoTicketGenerator;

    @BeforeEach
    void setUp() {
        lottoTicketGenerator = new LottoTicketGenerator();
    }

    @Test
    void 티켓_수_확인() {
        List<LottoTicket> tickets = lottoTicketGenerator.generateLottoTicket(6000);
        assertEquals(6, tickets.size()); // 티켓 수 확인

    }

    @Test
    void 랜덤_로또_번호_테스트() {
        List<Integer> numbers = lottoTicketGenerator.generateLottoNumbers();
        assertEquals(6, numbers.size()); // 발행된 로또 번호가 6개인지 확인

        for (int number : numbers) { // 1~45 사이의 숫자인지 확인
            assertTrue(number >= 1 && number <= 45);
        }

        Set<Integer> uniqueNumbers = new HashSet<>(numbers); // 중복된 숫자가 있는지 확인
        assertEquals(numbers.size(), uniqueNumbers.size());

    }
}