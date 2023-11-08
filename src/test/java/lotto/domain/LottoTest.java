package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또번호에 숫자를 포함하고 있는지 반환")
    @ParameterizedTest()
    @CsvSource({"1,true", "7,false"})
    void containNum(int num, boolean expectedValue) {
        boolean result = new Lotto(List.of(1, 2, 3, 4, 5, 6)).checkContainNumber(num);
        assertThat(result).isEqualTo(expectedValue);
    }

    @DisplayName("당첨번호와 몇개 겹치는지 반환")
    @Test
    void countContainNum() {
        int result = new Lotto(List.of(1, 2, 3, 4, 5, 6)).countContainNumbers(List.of(1, 2, 8, 9, 6, 3));
        assertThat(result).isEqualTo(4);
    }
}