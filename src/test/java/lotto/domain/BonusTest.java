package lotto.domain;

import static lotto.constant.GameNumber.MAX_NUMBER;
import static lotto.constant.GameNumber.MIN_NUMBER;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusTest {

    Lotto winLotto;

    @BeforeEach
    void beforeEach() {
        List<Integer> list = new ArrayList<>(Arrays.asList(5, 6, 7, 8, 9, 10));
        winLotto = new Lotto(list);
    }

    @Test
    @DisplayName("숫자 범위를 벗어나면 예외 발생")
    void validateNumber() {
        assertThatThrownBy(() -> new Bonus((int)MIN_NUMBER.getNumber() - 1, winLotto))
            .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new Bonus((int)MAX_NUMBER.getNumber() + 1, winLotto))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("기존 당첨 번호와 중복되면 예외 발생")
    void validateDuplication() {
        assertThatThrownBy(() -> new Bonus(5, winLotto))
            .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new Bonus(10, winLotto))
            .isInstanceOf(IllegalArgumentException.class);
    }
}