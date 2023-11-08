package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoGameTest {

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    void validateBonus(){
        assertThatThrownBy(() -> new LottoGame(6, new Lotto(List.of(1,2,3,4,5,6))))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 일치하는 숫자가 있는지 확인하는 기능 테스트")
    @Test
    void matchBonus(){
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,8));
        LottoGame lottoGame = new LottoGame(8, new Lotto(List.of(1,2,3,4,5,6)));
        boolean result = lottoGame.matchBonus(lotto);
        assertThat(result).isTrue();
    }

    @DisplayName("당첨 번호와 일치한 숫자가 몇개인지 반환하는 기능 테스트")
    @Test
    void matchWinningLotto(){
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,8));
        LottoGame lottoGame = new LottoGame(8, new Lotto(List.of(1,2,3,4,5,6)));
        int result = lottoGame.countMatchLotto(lotto);
        assertThat(result).isEqualTo(5);
    }

}
