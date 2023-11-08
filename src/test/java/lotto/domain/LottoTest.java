package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest { //입력값 예외발생 로직은 InputView에서 담당.
    @Test
    @DisplayName("유효한 입력이 들어올 경우 Lotto 객체가 생성된다.")
    public void createLottoInstanceWhenGivenValidNumbers() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);

        Lotto lotto = new Lotto(numbers);

        assertThat(lotto.getNumbers()).hasSize(6);
        assertThat(lotto.getNumbers()).isSorted();
    }

//    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
//    @Test
//    void createLottoByOverSize() {
//        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
//                .isInstanceOf(IllegalArgumentException.class);
//    }
//
//    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
//    @Test
//    void createLottoByDuplicatedNumber() {
//        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
//                .isInstanceOf(IllegalArgumentException.class);
//    }
//
//    @DisplayName("로또 번호의 개수가 6개가 안되면 예외가 발생한다.")
//    @Test
//    void createLottoByUnderSize() {
//        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4)))
//                .isInstanceOf(IllegalArgumentException.class);
//    }
//
//    @DisplayName("로또 번호가 1에서 45 사이의 숫자가 아니면 예외가 발생한다")
//    @Test
//    void createLottoWithNumbersOutOfRange() {
//        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 35, 44, 100)))
//                .isInstanceOf(IllegalArgumentException.class);
//    }
}