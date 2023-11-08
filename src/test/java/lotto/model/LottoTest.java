package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    private Lotto lotto;

    @BeforeEach
    void setUp() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            numbers.add(i);
        }
        lotto = new Lotto(numbers);
    }

    @Test
    @DisplayName("로또 범위 검증")
    void validateRange() {
        assertThatThrownBy(() -> lotto.validateRange(46)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        assertThatThrownBy(() -> lotto.validateRange(-1)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @Test
    @DisplayName("로또 번호 중복 검증")
    void validateDuplication() {
        List<Integer> duplicationNumbers = new ArrayList<>();
        duplicationNumbers.add(1);
        duplicationNumbers.add(2);
        duplicationNumbers.add(3);
        duplicationNumbers.add(3);
        duplicationNumbers.add(4);
        duplicationNumbers.add(4);
        assertThatThrownBy(() -> lotto.validateDuplication(duplicationNumbers)).isInstanceOf(
                IllegalArgumentException.class).hasMessageContaining("[ERROR] 중복되지 않은 숫자를 입력하세요.");
    }

    @Test
    @DisplayName("List<Integer> 사이즈 및 범위, 중복 검증 테스트")
    void validate() {
        List<Integer> outSizeNumbers = new ArrayList<>();
        for (int i = 1; i < 8; i++) {
            outSizeNumbers.add(i);
        }
        assertThatThrownBy(() -> new Lotto(outSizeNumbers)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호 사이즈는 6입니다.");
    }
}