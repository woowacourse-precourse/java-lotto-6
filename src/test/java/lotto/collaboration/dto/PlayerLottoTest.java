package lotto.collaboration.dto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.collaboration.Lotto;
import org.junit.jupiter.api.Test;

class PlayerLottoTest {

    @Test
    void 기본적인생성이정상적으로동작함() {
        assertThatNoException().isThrownBy(() -> {
            Lotto make = Lotto.make(() -> List.of(1, 2, 3, 4, 5, 6));
            PlayerLotto playerLotto = new PlayerLotto(make);
        });
    }

    @Test
    void 생성된결과를_toString으로_기본적인형태확인가능() {
        Lotto make = Lotto.make(() -> List.of(1, 2, 3, 4, 5, 6));
        PlayerLotto playerLotto = new PlayerLotto(make);

        String expected = "[1, 2, 3, 4, 5, 6]";
        String actual = playerLotto.toString();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 생성된결과를_stream으로_활용가능() {
        Lotto make = Lotto.make(() -> List.of(1, 2, 3, 4, 5, 6));
        PlayerLotto playerLotto = new PlayerLotto(make);

        assertThatNoException()
                .isThrownBy(() -> playerLotto.stream());
    }

    @Test
    void 같은값의객체에대해_동등판단시_true() {
        Lotto make1 = Lotto.make(() -> List.of(1, 2, 3, 4, 5, 6));
        Lotto make2 = Lotto.make(() -> List.of(1, 2, 3, 4, 5, 6));
        PlayerLotto playerLotto1 = new PlayerLotto(make1);
        PlayerLotto playerLotto2 = new PlayerLotto(make2);

        boolean actual = playerLotto1.equals(playerLotto2);

        assertThat(actual).isTrue();
    }

    @Test
    void 다른값의객체에대해_동등판단시_false() {
        Lotto make1 = Lotto.make(() -> List.of(7, 2, 3, 4, 5, 6));
        Lotto make2 = Lotto.make(() -> List.of(1, 2, 3, 4, 5, 6));
        PlayerLotto playerLotto1 = new PlayerLotto(make1);
        PlayerLotto playerLotto2 = new PlayerLotto(make2);

        boolean actual = playerLotto1.equals(playerLotto2);

        assertThat(actual).isFalse();
    }

    @Test
    void 숫자갯수가부족한로또로_초기화시도시_예외발생() {
        assertThatThrownBy(() -> new PlayerLotto(Lotto.make(() -> List.of(1, 2, 3, 4, 5))))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자갯수가넘치는로또로_초기화시도시_예외발생() {
        assertThatThrownBy(() -> new PlayerLotto(Lotto.make(() -> List.of(1, 2, 3, 4, 5, 6, 7))))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 범위를벗어난로또로_초기화시도시_예외발생() {
        assertThatThrownBy(() -> new PlayerLotto(Lotto.make(() -> List.of(111, 222, 333, 444, 555, 666))))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void null값의로또로_초기화시도시_예외발생() {
        assertThatThrownBy(() -> new PlayerLotto(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

}