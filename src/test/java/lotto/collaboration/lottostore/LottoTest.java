package lotto.collaboration.lottostore;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void make를_통해서_로또번호_생성가능() {
        assertThatNoException()
                .isThrownBy(() -> Lotto.make(() -> List.of(1, 2, 3, 4, 5, 6)));
    }

    @Test
    void make를_통해서_중복에대해_예외처리가능() {
        assertThatThrownBy(() -> Lotto.make(() -> List.of(1, 1, 1, 2, 2, 2)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void make를_통해서_숫자개수가맞지않는경우에대해_예외처리가능() {
        assertThatThrownBy(() -> Lotto.make(() -> List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void make를_통해서_범위를벗어나는숫자에대해_예외처리가능() {
        assertThatThrownBy(() -> Lotto.make(() -> List.of(100, 101, 102, 103, 104, 105)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void toString으로_기본표현문자열을확인할수있다() {
        String expected = "[1, 2, 3, 4, 5, 6]";

        Lotto actualLotto = Lotto.make(() -> List.of(1, 2, 3, 4, 5, 6));
        String actual = actualLotto.toString();

        Assertions.assertThat(actual).isEqualTo(expected);
    }

}