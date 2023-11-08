package lotto.Model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 아니면 예외가 발생한다.")
    @Test
    void createLottoByInvalidSize() {
        List<Integer> lessNumbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> moreNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        assertThatThrownBy(() -> new Lotto(lessNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("6개");

        assertThatThrownBy(() -> new Lotto(moreNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("6개");
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        List<Integer> duplicatedNumbers = Arrays.asList(1, 2, 3, 4, 5, 5);

        assertThatThrownBy(() -> new Lotto(duplicatedNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복");
    }

    @DisplayName("로또 번호가 유효하면 로또 객체가 생성된다.")
    @Test
    void createValidLotto() {
        List<Integer> validNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        assertDoesNotThrow(() -> new Lotto(validNumbers));
    }
}
