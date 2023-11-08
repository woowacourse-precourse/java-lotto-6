package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class GameManagerTest {

    @DisplayName("GameManager 생성 테스트")
    @Test
    void createGameManager() {
        GameManager gameManager = new GameManager();
        assertNotNull(gameManager);
    }

    @DisplayName("GameManager startLottoGame() 테스트")
    @Test
    void startLottoGame() {
        GameManager gameManager = new GameManager();
        gameManager.startLottoGame();
    }
}