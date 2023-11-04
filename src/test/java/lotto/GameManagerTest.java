package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class GameManagerTest {

    private GameManager gameManager;

    @BeforeEach
    void setUp(){
        gameManager = new GameManager();
    }

    @Test
    void 입력받은_금액이_천원으로_나누어_떨어지지_않는_경우_예외_발생(){
        // Arrange
        String payment = "1200";
        // Action, Action
        assertThatThrownBy(() -> gameManager.getPaymentForLottoByRead(payment))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력받은_금액이_숫자로_이뤄지지않은경우_예외발생(){
        // Arrange
        String payment = "100f";
        // Action, Action
        assertThatThrownBy(() -> gameManager.getPaymentForLottoByRead(payment))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
