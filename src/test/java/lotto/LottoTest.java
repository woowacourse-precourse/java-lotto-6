package lotto;

import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @Test
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    void createLottoByOverSize() {
        // given
        // when
        // then
        assertThatThrownBy(() -> Lotto.generateLotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    void createLottoByDuplicatedNumber() {
        // given
        // when
        // then
        assertThatThrownBy(() -> Lotto.generateLotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능

    @Test
    @DisplayName("로또 번호에 정해진 범위보다 큰 값이 들어오면 예외가 발생한다.")
    void createLotto_NumberMoreThanThreshold() {
        // given
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 46);

        // when
        // then
        assertThatThrownBy(() -> Lotto.generateLotto(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호에 정해진 범위보다 작은 값이 들어오면 예외가 발생한다.")
    void createLotto_NumberLessThanThreshold() {
        // given
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 0);

        // when
        // then
        assertThatThrownBy(() -> Lotto.generateLotto(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호 생성 테스트")
    void createLotto() {
        // given
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);

        // when
        Lotto lotto = Lotto.generateLotto(lottoNumbers);

        // then
        assertThat(lotto).isNotNull();
    }

    @Test
    @DisplayName("랜덤으로 로또를 생성하는 테스트")
    void generateGandomLotto() {
        // given

        // when
        Lotto lotto = Lotto.generateGandomLotto();
        // then
        assertThat(lotto).isNotNull();
    }
}