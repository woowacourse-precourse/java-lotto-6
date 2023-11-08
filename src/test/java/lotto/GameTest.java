package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.Validator.LottoValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class GameTest {
    @DisplayName("게임서비스는 유저로부터 당첨번호를 입력받아 저장한다.")
    @Test
    void askWinningNumbers(){
        Game game = new Game();
        game.setWinningLotto(List.of(1,2,3,4,5,6));

        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        assertThat(lotto.getHowManySameNumbers(game.getWinningLotto())).isEqualTo(LottoValidator.getLottoSize());
    }
    @DisplayName("게임서비스는 유저로부터 보너스 번호를 입력받아 저장한다.")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5})
    void setWinningNumbers(int n) {
        Game game = new Game();
        game.setBonusNumber(n);
        assertThat(game.getBonusNmber()).isEqualTo(n);
    }

}
