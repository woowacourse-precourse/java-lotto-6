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

    @DisplayName("GameManager showLottoCount() 테스트")
    @Test
    void showLottoCount() {
        GameManager gameManager = new GameManager();
        gameManager.showLottoCount(1);
    }

    @DisplayName("lottoCount가 0이하이면 예외가 발생한다.")
    @Test
    void showLottoCountThatIsLessThanZero() {
        GameManager gameManager = new GameManager();
        // error 메시지에 "[ERROR] lottoCount가 0이하입니다."가 포함되어 있는지 확인
        assertThrows(IllegalStateException.class, () -> gameManager.showLottoCount(-1));
    }

    @DisplayName("GameManager instantiateLottos() 테스트")
    @Test
    void instantiateLottos() {
        GameManager gameManager = new GameManager();
        gameManager.instantiateLottos(1);
    }

    @DisplayName("GameManager showLottos() 테스트")
    @Test
    void showLottos() {
        GameManager gameManager = new GameManager();
        gameManager.showLottos(gameManager.instantiateLottos(6));
    }
}