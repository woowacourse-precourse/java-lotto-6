package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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
    @DisplayName("로또 번호가 MIN_NUMBER 미만인 경우 예외가 발생한다.")
    @Test
    void createLottoByNumberBelowMinNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 6)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 MAX_NUMBER 초과인 경우 예외가 발생한다.")
    @Test
    void createLottoByNumberAboveMaxNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("getNumbers() 메서드가 올바른 로또 번호 리스트를 반환한다.")
    @Test
    void getNumbersReturnsCorrectList() {
        List<Integer> inputNumbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(inputNumbers);

        List<Integer> expectedNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertThat(lotto.getNumbers()).isEqualTo(expectedNumbers);
    }

}