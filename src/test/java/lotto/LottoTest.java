package lotto;

import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {
    private static final Lotto TEST = new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));

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

    @DisplayName("로또를 정해진 형식의 문자열로 만드는 것을 확인한다.")
    @Test
    void toStringIsCorrect() {
        String expected = "[1, 2, 3, 4, 5, 6]";
        assertThat(TEST.toString()).isEqualTo(expected);
    }

    @DisplayName("로또가 주어진 숫자를 가지고 있는지 여부를 잘 알려주는 것을 확인한다.")
    @Test
    void containsIsCorrect() {
        int correct = 1;
        int wrong = 11;
        assertThat(TEST.contains(correct)).isTrue();
        assertThat(TEST.contains(wrong)).isFalse();
    }

    @DisplayName("당첨 번호들과 비교해서 몇개가 같은지 개수를 전달하는 것을 확인한다.")
    @ParameterizedTest
    @CsvSource({"1,2,3,4,5,6,6", "1,2,3,4,5,7,5", "1,2,3,4,7,8,4", "1,2,3,7,8,9,3", "1,2,7,8,9,10,2", "1,7,8,9,10,11,1",
            "7,8,9,10,11,12,0"})
    void checkCountMatchWithWinningLotto(int number1, int number2, int number3, int number4, int number5, int number6,
                                         int expected) {
        Lotto winnings = new Lotto(new ArrayList<>(List.of(number1, number2, number3, number4, number5, number6)));
        assertThat(TEST.countMatchWithWinningLotto(winnings)).isEqualTo(expected);
    }

}