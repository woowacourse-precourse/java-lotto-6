package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ControllerTest {
    private Controller controller;

    @BeforeEach
    void setUp() {
        controller = new Controller();
    }

    @DisplayName("로또 구매 기능 테스트")
    @Test
    void purchaseLottoTicketsTest() {
        controller.purchaseLotto(8);
        assertThat(8).isEqualTo(controller.getLottoTickets().size());
    }
}