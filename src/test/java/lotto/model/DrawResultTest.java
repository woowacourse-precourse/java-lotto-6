package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DrawResultTest {

    private List<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            numbers.add(i);
        }
    }

    @Test
    @DisplayName("당첨 번호와 보너스 번호 중복 조회 검증")
    void validateDuplication() {
        int bonusNumber = 6;
        DrawResult drawResult = new DrawResult(new Lotto(numbers), bonusNumber);
        assertThatThrownBy(drawResult::validateDuplication).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호 범위 검증")
    void validateRange() {
        Lotto lotto = new Lotto(numbers);
        assertThatThrownBy(() -> lotto.validateRange(46)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> lotto.validateRange(-1)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("DrawResult 생성자 검증")
    void DrawResult() {
        List<Integer> duplicationNumbers = new ArrayList<>();
        for (int i = 38; i < 46; i++) {
            duplicationNumbers.add(i);
        }
        assertThrows(IllegalArgumentException.class, () -> new DrawResult(new Lotto(numbers), -1));
        assertThrows(IllegalArgumentException.class, () -> new DrawResult(new Lotto(duplicationNumbers), 45));
    }
}