package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        List<Integer> overSizeList = List.of(1, 2, 3, 4, 5, 6, 7);
        assertThatThrownBy(() -> new Lotto(overSizeList))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        List<Integer> duplicatedNumberList = List.of(1, 2, 3, 4, 5, 5);
        assertThatThrownBy(() -> new Lotto(duplicatedNumberList))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호는 1~45 까지이다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void createLottoByInvalidNumber(int invalidNumber){
        List<Integer> listContainsInvalidNumber = List.of(1, 2, 3, 4, 5, invalidNumber);
        assertThatThrownBy(() -> new Lotto(listContainsInvalidNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호는 중복되지 않는다.")
    @Test
    void createLottoByDuplicatedNumbers() {
        int duplicatedNumber = 1;
        List<Integer> duplicatedNumbers = List.of(duplicatedNumber, duplicatedNumber, 3, 4, 5, 6);
        assertThatThrownBy(() -> new Lotto(duplicatedNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("일치율(matches) 확인 - 6개 전부 일치")
    @Test
    void compare_ALL_MATHCES() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.compare(lotto2)).isEqualTo(6);
    }

    @DisplayName("일치율(matches) 확인 - 매칭되는것이 없다")
    @Test
    void compare_NONE_MATCHES() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(7, 8, 9, 10, 11, 12));
        assertThat(lotto.compare(lotto2)).isZero();
    }
}