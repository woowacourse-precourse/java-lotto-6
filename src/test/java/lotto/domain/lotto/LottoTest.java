package lotto.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    private final Lotto lottoContainOneToSix = new Lotto(List.of(1, 2, 3, 4, 5, 6));

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

    @DisplayName("로또를 hasNumber 로 확인할 때, 있는 번호는 True 를, 없는 번호는 False 를 반환한다.")
    @Test
    void checkLottoContainNumberTest() {
        assertThat(lottoContainOneToSix.hasNumber(1)).isTrue();
        assertThat(lottoContainOneToSix.hasNumber(7)).isFalse();
    }

    @DisplayName("숫자 3개가 같은 로또와 같은 숫자의 개수를 확인하면, 3이 나온다.")
    @Test
    void countSameLottoNumberWithOtherLotto_1() {
        Lotto threeNumbersSameLotto = new Lotto(List.of(1, 3, 5, 7, 9, 11));
        assertThat(lottoContainOneToSix.compareLottoNumber(threeNumbersSameLotto)).isEqualTo(3);
    }

    @DisplayName("숫자 0개가 같은 로또와 같은 숫자의 개수를 확인하면, 0이 나온다.")
    @Test
    void countSameLottoNumberWithOtherLotto_2() {
        Lotto zeroNumberSameLotto = new Lotto(List.of(7, 8, 9, 10, 11, 12));
        assertThat(lottoContainOneToSix.compareLottoNumber(zeroNumberSameLotto)).isEqualTo(0);
    }

    @DisplayName("숫자 6개가 같은 로또와 같은 숫자의 개수를 확인하면, 6이 나온다.")
    @Test
    void countSameLottoNumberWithOtherLotto_6() {
        Lotto sixNumbersSameLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lottoContainOneToSix.compareLottoNumber(sixNumbersSameLotto)).isEqualTo(6);
    }

    @DisplayName("6개가 아닌 숫자로 Lotto 를 만들면 에러가 발생한다.")
    @Test
    void lottoErrorTest_1() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5))).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복되는 숫자로 Lotto 를 만들면 에러가 발생한다.")
    @Test
    void lottoErrorTest_2() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 1, 2, 3, 4, 5))).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1~45 의 숫자가 아닌 수로 로또를 만들면 에러가 발생한다.")
    @Test
    void lottoErrorTest_3() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 1, 2, 3, 4, 5))).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46))).isInstanceOf(IllegalArgumentException.class);
    }
}