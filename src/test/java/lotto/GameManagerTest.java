package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameManagerTest {
    
    GameManager gameManager = new GameManager();
    
    @Test
    @DisplayName("Lotto number들을 횟수만큼 생성해내는 메서드 정상 작동")
    void testGenerateLotto() {
        gameManager.setMoneyYouPut(12000);
        gameManager.generateLotto();
        PrintHandler.printLottos(gameManager.getLottos());
        assertThat(gameManager.getGameSize()).isEqualTo(12);
    }
}
