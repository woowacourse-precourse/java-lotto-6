package lotto.domain;

import lotto.constant.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> Lotto.from(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> Lotto.from(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("[기능]Lotto_정렬기능__로또는_정렬된_상태로_가져와진다")
    @Test
    void getNumbers() {
        List<Integer> numbers = List.of(43, 12, 7, 1, 9, 18);
        Lotto lotto = Lotto.from(numbers);

        assertThat(lotto.getNumbers()).isSorted();
    }

    @DisplayName("[예외]Lotto_검증기능__숫자_개수_잘못됨")
    @Test
    void checkFormat1() {
        List<Integer> numbers = List.of(4, 6, 34, 11, 3);
        assertThatThrownBy(() -> Lotto.checkFormat(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NUMBER_COUNT_OF_LOTTO.get());
    }

    @DisplayName("[예외]Lotto_검증기능__숫자_중복_존재")
    @Test
    void checkFormat2() {
        List<Integer> numbers = List.of(4, 6, 6, 11, 3, 1);
        assertThatThrownBy(() -> Lotto.checkFormat(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NUMBER_DUPLICATED.get());
    }
    @DisplayName("[예외]Lotto_검증기능__범위_벗어난_수_존재")
    @Test
    void checkFormat3() {
        List<Integer> numbers = List.of(4, 6, 34, 46, 11, 3);
        assertThatThrownBy(() -> Lotto.checkFormat(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.LOTTO_RANGE.get());
    }

    @DisplayName("[예외]Lotto_검증기능__숫자_하나의_범위")
    @Test
    void checkRange() {
        List<Integer> boundaryValue = List.of(0, 46);

        for (int value : boundaryValue) {
            assertThatThrownBy(() -> Lotto.checkRange(value))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.LOTTO_RANGE.get());
        }
    }
}