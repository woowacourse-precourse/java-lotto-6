package lotto.model;

import lotto.model.Lotto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 범위가 1부터 45가 아니라면 예외가 발생힌다.")
    @Test
    void createLottoByOverRange() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lotto(List.of(1, 2, 3, 4, 5, 50));
        });
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 보너스 번호가 포함되어 있으면 true를 반환한다.")
    @Test
    void lottoHasBonus() {
        Assertions.assertTrue(new Lotto(List.of(1,2,3,4,5,6)).hasBonus(5));
    }

    @DisplayName("로또 번호에 보너스 번호가 포함되어 있으면 false를 반환한다.")
    @Test
    void lottoHasNotBonus() {
        Assertions.assertTrue(new Lotto(List.of(1,2,3,4,5,6)).hasBonus(7));
    }
}