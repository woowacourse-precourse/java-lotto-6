package lotto.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LottoTicketServiceTest {
    private IOConfig ioConfig = new IOConfig();

    @BeforeEach
    void setUp() {
        ioConfig.setUpOutput();
    }

    @AfterEach
    void tearDown() {
        ioConfig.restoreInputOutput();
    }

    @DisplayName("로또가 정상적으로 발행될 경우")
    @Test
    void issueLottoTicketTest() {
        // given
        ioConfig.mockInput("4000\n");

        // when/then
        assertDoesNotThrow(() -> {
            LottoTicketService lottoTicketCounter = new LottoTicketService();
            lottoTicketCounter.issueLottoTicket();
        });
    }
}
