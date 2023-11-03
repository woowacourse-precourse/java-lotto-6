package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;
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

    @DisplayName("로또 번호에 1 ~ 45 범위 밖의 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByWrongRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.WRONG_RANGE.getMessage());
    }

    @DisplayName("보너스 번호도 기존 번호와 중복되면 안된다.")
    @Test
    void validateBonusNumberByDuplicatedNumber() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonus = 5;

        // when then
        assertThatThrownBy(() -> lotto.validateBonusNumber(bonus))
                .isInstanceOf(LottoException.class)
                .hasMessage(ErrorMessage.DUPLICATE_NUMBER.getMessage());
    }

    @DisplayName("보너스 번호도 범위에 있어야 한다.")
    @Test
    void validateBonusNumberByRange() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonus = 46;

        // when then
        assertThatThrownBy(() -> lotto.validateBonusNumber(bonus))
                .isInstanceOf(LottoException.class)
                .hasMessage(ErrorMessage.WRONG_RANGE.getMessage());
    }

    @DisplayName("다른 로또와 중복 숫자를 카운트 할 수 있다.")
    @Test
    void countSameNumber() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto answerLotto = new Lotto(List.of(1, 2, 3, 4, 7, 8));

        // when
        int count = lotto.countSameNumber(answerLotto);

        // then
        assertThat(count).isEqualTo(4);
    }

    @DisplayName("보너스 번호를 포함하고 있으면 true를 반환한다.")
    @Test
    void containsTrue() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 6;

        // when
        boolean isContain = lotto.contains(bonusNumber);

        // then
        assertThat(isContain).isTrue();
    }

    @DisplayName("보너스 번호를 포함하고 있지 않으면 false를 반환한다.")
    @Test
    void containsFalse() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        // when
        boolean isContain = lotto.contains(bonusNumber);

        // then
        assertThat(isContain).isFalse();
    }
}