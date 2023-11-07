package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.settings.ErrorMessage.DUPLICATE_NUM;
import static lotto.settings.ErrorMessage.INVALID_COUNT;
import static lotto.settings.ErrorMessage.INVALID_RANGE;
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

    // 아래에 추가 테스트 작성 가능
    @DisplayName("로또 번호가 모두 올바르게 입력된 경우 예외없이 저장된다.")
    @Test
    void createCorrectLotto() {
        Lotto lotto = new Lotto(List.of(1, 2, 35, 5, 6, 7));
    }

    @DisplayName("로또 번호에 1보다 작은 숫자가 있다면 예외가 발생한다.")
    @Test
    void createLottoByUngerRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 0, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_RANGE.getMessage());
    }

    @DisplayName("로또 번호에 45보다 큰 숫자가 있다면 예외가 발생한다.")
    @Test
    void createLottoByOverRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 46, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_RANGE.getMessage());
    }
}