package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
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
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 범위에서 벗어난 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호_범위_예외() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 55)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 인자로 받은 번호와 같은 번호가 있는지 확인한다.")
    @Test
    void 같은_숫자_존재_여부_확인() {

        //given
        Lotto lotto = new Lotto(List.of(1, 3, 5, 7, 9, 10));
        int sameNumber = 1;
        int uniqueNumber = 8;

        //when&then
        assertThat(lotto.hasSameNumber(sameNumber)).isTrue();
        assertThat(lotto.hasSameNumber(uniqueNumber)).isFalse();

    }

}