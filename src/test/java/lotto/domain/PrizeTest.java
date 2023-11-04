package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PrizeTest {
    private final Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

    @DisplayName("로또 당첨 번호 객체 생성을 테스트한다.")
    @Test
    void createLottoByValidNumber() {
        Prize prize = Prize.of(lotto, 10);
        assertThat(prize).isNotNull();
    }

    @DisplayName("로또 당첨 번호와 보너스 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> Prize.of(lotto, 3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 보너스 번호가 범위인 1 ~ 45가 아니라면 예외가 발생한다.")
    @Test
    void createLottoByOverRange() {
        assertThatThrownBy(() -> Prize.of(lotto, 100))
                .isInstanceOf(IllegalArgumentException.class);
    }
}