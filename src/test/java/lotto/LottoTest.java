package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto("1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 숫자의 범위가 1 ~ 45 사이가 아니면 예외가 발생한다.")
    @Test
    void createLottoByInvalidRange() {
        assertThatThrownBy(() -> new Lotto("0,-1,145,46,77,1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 숫자가 아니면 예외가 발생한다.")
    @Test
    void createLottoByString() {
        assertThatThrownBy(() -> new Lotto("가,나,다,a,b,1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호를 쉼표로 구분하지 않으면 예외가 발생한다.")
    @Test
    void createLottoByInvalidSeparator() {
        assertThatThrownBy(() -> new Lotto("1.2.3.4.5.6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("일치하는 로또 번호의 개수를 반환한다.")
    @Test
    void countMatchingNumber() {
        Lotto lotto = new Lotto("1,2,3,4,5,6");
        Lotto userLotto = new Lotto("1,2,3,4,5,6");

        assertThat(lotto.countMatchingNumber(userLotto)).isEqualTo(6);
    }

}