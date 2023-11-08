package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;


class BonusTest {

    @DisplayName("로또 번호 6개랑 보너스 번호랑 중복되는 수가 있다면 예외가 발행한다.")
    @Test
    void createBonusByDuplicatedWithLotto() {
        assertThatThrownBy(() -> new Bonus(1, new Lotto(List.of(1, 2, 3, 4, 5, 6)))).isInstanceOf(IllegalArgumentException.class);
    }


}