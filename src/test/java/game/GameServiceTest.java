package game;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class GameServiceTest {

    GameService game = new GameService();

    @Test
    void roundTest() {

        Assertions.assertThat(game.roundToTwoDecimalPlaces(5000, 8000)).isEqualTo(62.5);
    }

    @Test
    void createLottoByPriceTest() {
        Assertions.assertThat(game.createLottoByPrice(14000).size()).isEqualTo(14);
    }

    @Test
    void roundToTwoDecimalPlacesTest() {
        Assertions.assertThat(game.roundToTwoDecimalPlaces(5000, 8000)).isEqualTo(62.5);
    }
}