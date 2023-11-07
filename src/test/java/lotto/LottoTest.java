package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import lotto.Model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void validateSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호를 6개 입력해 주세요.");
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void validateDuplicate() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 중복될수 없습니다.");
    }

    @DisplayName("로또 번호가 1~45인지 테스트.")
    @Test
    void validateNumberRange() {
        assertThatThrownBy(() -> new Lotto(Arrays.asList(1, 3, 5, 50, 4, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1~45의 숫자만 가능합니다.");
    }

    @DisplayName("로또 번호가 오름차순으로 출력되는지 확인한다.")
    @Test
    void sorted() {
        Lotto lotto = new Lotto(Arrays.asList(1,6,5,42,34,2));

        String expectedResult = "[1, 2, 5, 6, 34, 42]";
        assertThat(lotto.toString()).isEqualTo(expectedResult);
    }
}