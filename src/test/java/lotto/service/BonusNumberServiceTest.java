package lotto.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.WinningTicket;
import lotto.repository.MemoryTicketRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberServiceTest {

    private BonusNumberService bonusNumberService;
    private MemoryTicketRepository memoryTicketRepository;

    @BeforeEach
    void setUp() {
        memoryTicketRepository = new MemoryTicketRepository();
        bonusNumberService = new BonusNumberService(memoryTicketRepository);
        setUpWinningNumbers(); // 당첨 번호 설정
    }

    private void setUpWinningNumbers() {
        WinningTicket winningTicket = new WinningTicket();
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        winningTicket.setNumbers(winningLotto);
        memoryTicketRepository.announcement(winningTicket);
    }

    @DisplayName("당첨 번호와 중복 되지 않은 올바른 입력 이라면, 보너스 번호를 저장한다.")
    @Test
    void announcementBonusNumberMethodTest() {
        String input = "7";

        BonusNumber bonusNumber = bonusNumberService.announcementBonusNumber(input);

        assertEquals(7, bonusNumber.getBonusNumber());
    }

}