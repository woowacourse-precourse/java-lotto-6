package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.Service.GameService;
import lotto.Validator.LottoValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class GameServiceTest {
    @DisplayName("게임서비스는 유저로부터 당첨번호를 입력받아 저장한다.")
    @Test
    void askWinningNumbers() {
        GameService game = new GameService();
        game.setWinningLotto(List.of(1, 2, 3, 4, 5, 6));

        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.getHowManySameNumbers(game.getWinningLotto())).isEqualTo(LottoValidator.getLottoSize());
    }

    @DisplayName("게임서비스는 유저로부터 보너스 번호를 입력받아 저장한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void setWinningNumbers(int n) {
        GameService game = new GameService();
        game.setBonusNumber(n);
        assertThat(game.getBonusNumber()).isEqualTo(n);
    }

    @DisplayName("게임서비스는 유저로부터 금액을 입력받아 저장한다.")
    @ParameterizedTest
    @ValueSource(ints = {14000, 1000})
    void setMoney(int money) {
        GameService game = new GameService();
        game.setMoney(money);
        assertThat(game.getMoney()).isEqualTo(money);
    }

    @DisplayName("게임서비스는 유저로부터 받는 금액이 1000원 이상 21 * 10^8원 이하이다 ")
    @ParameterizedTest
    @ValueSource(ints = {0, Integer.MIN_VALUE, -1000})
    void setMoneyWithExceptionMinMax(int money) {
        GameService game = new GameService();

        assertThatThrownBy(() -> game.setMoney(money))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("게임서비스는 유저로부터 받는 금액이 1000원 단위이다.")
    @ParameterizedTest
    @ValueSource(ints = {1001, 1003, 1500})
    void setMoneyWithExceptionThousand(int money) {
        GameService game = new GameService();

        assertThatThrownBy(() -> game.setMoney(money))
                .isInstanceOf(IllegalArgumentException.class);

    }


}
