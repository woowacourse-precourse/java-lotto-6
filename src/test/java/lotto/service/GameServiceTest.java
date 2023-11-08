package lotto.service;

import lotto.dto.GameDto;
import lotto.dto.LottoDto;
import lotto.model.Game;
import lotto.util.LottoNumberFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.utility.TestConstant.*;
import static lotto.utility.model.GameFactory.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class GameServiceTest {
    private final List<Integer> winnerNumber = List.of(1,2,3,4,5,6);
    private final int bonusNumber = BONUS_NUMBER.getConstant();
    private GameService gameService;
    private Game game;

    @BeforeEach
    public void initTest() {
        gameService = new GameService(new LottoNumberFactory());
        game = GAME_1.getInstance();
    }

    @Test
    @DisplayName("로또를 구매한다.")
    public void purchaseLottoTest() {
        // when
        List<LottoDto> lottoDtos = gameService.purchaseLotto(game);

        // then
        assertThat(lottoDtos.size()).isEqualTo(game.getLottoQuantity());
    }

    @Test
    @DisplayName("로또 결과를 확인한다.")
    public void getLottoResultTest() {
        // when
        gameService.purchaseLotto(game);
        GameDto lottoResult = gameService.getLottoResult(game, winnerNumber, bonusNumber);

        // then
        assertAll(
                () -> assertThat(lottoResult.gameResults()).isEqualTo(game.getResultInfo()),
                () -> assertThat(lottoResult.profit()).isEqualTo(game.getGameProfit())
        );
    }
}
