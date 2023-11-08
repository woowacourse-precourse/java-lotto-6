package lotto.model;

import lotto.dto.LottoDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Game Domain 테스트")
public class GameTest {
    private final List<Integer> lotto = List.of(1,2,3,4,5,6);
    private final List<Integer> gameResult = List.of(0,0,0,0,0);
    private final int INIT_VALUE = 10_000;
    private final int LOTTO_PRIZE = 1_000;
    private final int WIN_CASE = 5;
    private final int PROFIT = 0;
    private Game game;

    @BeforeEach
    public void initTest() {
        game = new Game(INIT_VALUE);
    }

    @Test
    @DisplayName("Game Domain이 성공적으로 생성된다.")
    public void createDomainTest() {
        // when - then
        assertAll(
                () -> assertThat(game.getGameProfit()).isEqualTo(PROFIT),
                () -> assertThat(game.getLottoQuantity()).isEqualTo(INIT_VALUE / LOTTO_PRIZE)
        );
    }

    @Test
    @DisplayName("winTheGame() method 테스트")
    public void winTheGameTest() {
        // when
        game.winTheGame(WIN_CASE);

        // then
        assertThat(game.getGameProfit()).isNotEqualTo(PROFIT);
    }

    @Test
    @DisplayName("getLottoQuantity() method 테스트")
    public void getLottoQuantityTest() {
        // when
        int lottoQuantity = game.getLottoQuantity();

        // then
        assertThat(lottoQuantity).isEqualTo(INIT_VALUE / LOTTO_PRIZE);
    }

    @Test
    @DisplayName("getGameProfit() method 테스트")
    public void getGameProfitTest() {
        // when
        double gameProfit = game.getGameProfit();

        // then
        assertThat(gameProfit).isEqualTo(PROFIT);
    }

    @Test
    @DisplayName("buyLotto() method 테스트")
    public void buyLottoTest() {
        // when
        game.buyLotto(lotto);
        List<Integer> lottoNumbers = game.getLottoNumbers().get(0).getLottoNumber();

        // then
        assertThat(lottoNumbers).isEqualTo(lotto);
    }

    @Test
    @DisplayName("getLottoNumbers() method 테스트")
    public void getLottoNumbersTest() {
        // when
        List<LottoDto> lottoNumbers = game.getLottoNumbers();

        // then
        assertThat(lottoNumbers.size()).isEqualTo(0);
    }

    @Test
    @DisplayName("getResultInfo() method 테스트")
    public void getResultInfoTest() {
        // when
        List<Integer> resultInfo = game.getResultInfo();

        // then
        assertThat(resultInfo).isEqualTo(gameResult);
    }
}
