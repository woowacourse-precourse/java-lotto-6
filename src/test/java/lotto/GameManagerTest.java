package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameManagerTest {

    private GameManager gameManager;

    @BeforeEach
    void setUp(){
        gameManager = new GameManager();
    }

    @Test
    void 입력받은_로또_번호가_천원으로_나누어_떨어지지_않는_경우_예외_발생(){
        // Arrange
        String payment = "1200";
        // Action, Action
        assertThrows(IllegalArgumentException.class, () -> gameManager.getPaymentForLottoByRead(payment));
    }
}
