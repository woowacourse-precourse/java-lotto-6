package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.Validator.LottoValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameTest {
    @DisplayName("게임서비스는 유저로부터 당첨번호를 입력받아 저장한다.")
    @Test
    void askWinningNumbers(){
        Game game = new Game();
        game.setWinningLotto(List.of(1,2,3,4,5,6));

        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        assertThat(lotto.getHowManySameNumbers(game.getWinningLotto())).isEqualTo(LottoValidator.getLottoSize());
    }
}
