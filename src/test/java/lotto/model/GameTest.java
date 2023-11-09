package lotto.model;

import lotto.testLottoNumberGenerator.TestLottoNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("[Test] Game")
public class GameTest {
    @Test
    @DisplayName("Game 생성 테스트 - 정상")
    void gameTest() {
        // Given
        int amountOfLotto = 3;

        // When
        Game game = new Game(amountOfLotto);

        // Then
        assertThat(game.getAmountOfLotto()).isEqualTo(amountOfLotto);
    }

    @Test
    @DisplayName("로또 번호 비교 테스트 - 일치하는 개수가 6개일 때")
    void compareLottoTest1() {
        // Given
        Game game = new Game(1);
        game.generateLottoNumber(new TestLottoNumberGenerator());
        game.createWinningLotto("1,2,3,4,5,6");

        // When
        List<Integer> lottoNumberCompareResult = game.compareLotto();

        // Then
        assertThat(lottoNumberCompareResult).isEqualTo(List.of(6));
    }

    @Test
    @DisplayName("로또 번호 비교 테스트 - 일치하는 개수가 3개일 때")
    void compareLottoTest2() {
        // Given
        Game game = new Game(1);
        game.generateLottoNumber(new TestLottoNumberGenerator());
        game.createWinningLotto("1,2,3,7,8,9");

        // When
        List<Integer> lottoNumberCompareResult = game.compareLotto();

        // Then
        assertThat(lottoNumberCompareResult).isEqualTo(List.of(3));
    }

    @Test
    @DisplayName("보너스 번호 비교 테스트 - true")
    void compareBonusLottoTest1() {
        // Given
        Game game = new Game(1);
        game.createWinningLotto("1,2,4,5,6,7");
        game.createBonusNumber("3");
        game.generateLottoNumber(new TestLottoNumberGenerator());

        // When
        List<Boolean> bonusNumberCompareResult = game.compareBonusLotto();

        // Then
        assertThat(bonusNumberCompareResult).isEqualTo(List.of(true));
    }

    @Test
    @DisplayName("보너스 번호 비교 테스트 - false")
    void compareBonusLottoTest2() {
        // Given
        Game game = new Game(1);
        game.createWinningLotto("1,2,4,5,6,7");
        game.createBonusNumber("9");
        game.generateLottoNumber(new TestLottoNumberGenerator());

        // When
        List<Boolean> bonusNumberCompareResult = game.compareBonusLotto();

        // Then
        assertThat(bonusNumberCompareResult).isEqualTo(List.of(false));
    }
}
