package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Map;
import lotto.constant.Rank;
import lotto.controller.GameController;
import lotto.domain.Game;
import lotto.util.Generator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("당첨 테스트")
class GameTest {

    private Game game;
    private GameController gameController;

    @BeforeEach
    void setup() {
        Generator mockGenerator = mock(Generator.class);
        when(mockGenerator.generateRandomNumbers()).thenReturn(List.of(1, 2, 3, 4, 5, 6));
        game = new Game(mockGenerator);
        game.createUserLottos(1);
    }

    @Test
    @DisplayName("1등 당첨 테스트")
    void winFirstTest() {
        game.createWinnerNumber("1,2,3,4,5,6");
        game.createBonusNumber("7");

        Map<Rank, Integer> results = game.compare();
        assertThat(results.get(Rank.FIRST)).isEqualTo(1);
    }

    @Test
    @DisplayName("2등 당첨 테스트")
    void winSecondTest() {
        game.createWinnerNumber("1,2,3,4,5,7");
        game.createBonusNumber("6");

        Map<Rank, Integer> results = game.compare();
        assertThat(results.get(Rank.SECOND)).isEqualTo(1);
    }

    @Test
    @DisplayName("3등 당첨 테스트")
    void winThirdTest() {
        game.createWinnerNumber("1,2,3,4,5,7");
        game.createBonusNumber("8");

        Map<Rank, Integer> results = game.compare();
        assertThat(results.get(Rank.THIRD)).isEqualTo(1);
    }

    @Test
    @DisplayName("4등 당첨 테스트")
    void winFourthTest() {
        game.createWinnerNumber("1,2,3,4,7,8");
        game.createBonusNumber("6");

        Map<Rank, Integer> results = game.compare();
        assertThat(results.get(Rank.FOURTH)).isEqualTo(1);
    }
}
