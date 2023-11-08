package lotto.model;

import lotto.dto.LottoDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.utility.TestConstant.*;
import static org.assertj.core.api.Assertions.*;

@DisplayName("Game Domain 테스트")
public class GameTest {
    private final List<Integer> lotto = List.of(1,2,3,4,5,6);
    private final List<Integer> gameResult = List.of(0,0,0,0,0);
    private Game game;

    @BeforeEach
    public void initTest() {
        game = new Game(INIT_COST.getConstant());
    }

    @Test
    @DisplayName("winTheGame() method 테스트")
    public void winTheGameTest() {
        // when
        game.winTheGame(VALID_MATCHED_NUMBER.getConstant());

        // then
        assertThat(game.getGameProfit()).isNotEqualTo(CONSTANT_ZERO.getConstant());
    }

    @Test
    @DisplayName("getLottoQuantity() method 테스트")
    public void getLottoQuantityTest() {
        // when
        int lottoQuantity = game.getLottoQuantity();

        // then
        assertThat(lottoQuantity).isEqualTo(INIT_COST.getConstant() / LOTTO_PRICE.getConstant());
    }

    @Test
    @DisplayName("getGameProfit() method 테스트")
    public void getGameProfitTest() {
        // when
        double gameProfit = game.getGameProfit();

        // then
        assertThat(gameProfit).isEqualTo(CONSTANT_ZERO.getConstant());
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
