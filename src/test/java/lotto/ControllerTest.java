package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

public class ControllerTest {
    private Controller controller;

    @BeforeEach
    void setUp() {
        controller = new Controller();
    }

    @DisplayName("로또 개수 확인")
    @Test
    void getLottoCountFromPrice() {
        int result = controller.getLottoCount(15000);
        assertThat(result).isEqualTo(15);
    }

    @DisplayName("잘못된 금액일 경우 예외")
    @ParameterizedTest(name = "{displayName} ({0}원)")
    @ValueSource(ints = {20500, 500})
    void getLottoCountFromPriceException(int userMoney) {
        assertThatThrownBy(() -> controller.getLottoCount(userMoney)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구매 기능 테스트")
    @Test
    void purchaseLottoTicketsTest() {
        controller.purchaseLotto(8);
        assertThat(8).isEqualTo(controller.getLottoTickets().size());
    }
}