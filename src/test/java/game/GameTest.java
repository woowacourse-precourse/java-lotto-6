package game;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    void roundTest() {
        GameService game = new GameService();
        Assertions.assertThat(game.roundToTwoDecimalPlaces(5000, 8000)).isEqualTo(62.5);
    }
}
