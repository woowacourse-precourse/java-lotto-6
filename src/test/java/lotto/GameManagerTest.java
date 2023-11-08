package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameManagerTest {
    GameManager gameManager = new GameManager();

    @Test
    @DisplayName("구매금액만큼 로또를 발행하는 테스트")
    void createLotto_test(){
        assertThat(gameManager.createLotto(8000).size()).isEqualTo(8);
    }
}
