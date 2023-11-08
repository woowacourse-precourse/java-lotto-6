package lotto.validator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {

    @Test
    @DisplayName("로또 번호가 유효하면 생성되어야 함")
    void createLottoWithValidNumbers() {
        List<Integer> validNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(validNumbers);
        assertThat(lotto).isNotNull();
    }

    @Test
    @DisplayName("로또 번호가 6개가 아니면 예외가 발생해야 함")
    void createLottoWithInvalidSize() {
        List<Integer> invalidNumbers = Arrays.asList(1, 2, 3, 4, 5);
        assertThatThrownBy(() -> new Lotto(invalidNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 6개여야 합니다.");
    }

    @Test
    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생해야 함")
    void createLottoWithDuplicateNumbers() {
        List<Integer> duplicateNumbers = Arrays.asList(1, 2, 3, 4, 5, 5);
        assertThatThrownBy(() -> new Lotto(duplicateNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호에 중복된 숫자가 있습니다.");
    }

}
