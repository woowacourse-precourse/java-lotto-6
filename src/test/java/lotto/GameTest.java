package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameTest {
    @DisplayName("돈 입력이 1000으로 나누어지지 않을 경우")
    @Test
    void createGameWithInvalidMoney() {
        assertThatThrownBy(() -> new Game("500"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("돈 입력이 정수가 아닐 경우")
    @Test
    void createGameWithStringdMoney() {
        assertThatThrownBy(() -> new Game("js"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호의 개수가 6이 아닌 경우")
    @Test
    void winNumberCountError() {
        Game game = new Game("1000");
        assertThatThrownBy(() -> game.setWinNumbers("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 문자열인 경우")
    @Test
    void winNumberStringError() {
        Game game = new Game("1000");
        assertThatThrownBy(() -> game.setWinNumbers("1,2,3,h,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 중복되는 경우")
    @Test
    void winNumberDuplicateError() {
        Game game = new Game("1000");
        assertThatThrownBy(() -> game.setWinNumbers("1,2,3,3,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 범위를 벗어난 경우")
    @Test
    void winNumberInvalidError() {
        Game game = new Game("1000");
        assertThatThrownBy(() -> game.setWinNumbers("1,2,3,300,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 정수가 아닌 경우")
    @Test
    void bonusNumberStringError() {
        Game game = new Game("1000");
        assertThatThrownBy(() -> game.setWinNumbers("s"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 범위를 벗어난 경우")
    @Test
    void bonusNumberInvalidError() {
        Game game = new Game("1000");
        assertThatThrownBy(() -> game.setWinNumbers("46"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 겹치는 경우")
    @Test
    void bonusNumberDuplicateError() {
        Game game = new Game("1000");
        game.setWinNumbers("1,2,3,4,5,6");
        assertThatThrownBy(() -> game.setWinNumbers("6"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}