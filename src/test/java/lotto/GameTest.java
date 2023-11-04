package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {
    @DisplayName("생성자의 매개변수와 일치하는 개수의 로또 생성하는지 확인")
    @Test
    void createGame() {
        int expected = 5;
        Game game = new Game(expected);
        int result = game.getLottos().size();

        assertThat(result).isEqualTo(expected);
    }
}
