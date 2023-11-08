package lotto;

import lotto.domain.lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    @DisplayName("로또번호는 중복된 숫자가 있을 수 없다.")
    void createLotto_Numbers_throwsIllegalArgumentException() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 5);

        // when & then
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또번호는 1-45 사이의 숫자를 가진다.")
    void createLotto_Numbers2_throwsIllegalArgumentException() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 46);

        // when & then
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또번호는 6개여야 한다.")
    void createLotto_Numbers3_throwsIllegalArgumentException() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);

        // when & then
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또번호는 당첨번호와 비교하여 일치하는 개수를 확인할 수 있다.")
    void getHitCount_Lotto_Success() {
        // given
        Lotto purchaseLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 23));

        // when
        int getHitCount = purchaseLotto.getHitCount(winningLotto);

        //then
        assertThat(getHitCount).isEqualTo(5);
    }

    @Test
    @DisplayName("로또번호는 특정 번호가 속하는지 확인할 수 있다.")
    void isContainNumber_Lotto_Success() {
        // given
        Lotto purchaseLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // when
        boolean isContainNumber = purchaseLotto.isContainNumber(1);

        //then
        assertThat(isContainNumber).isTrue();
    }

}
